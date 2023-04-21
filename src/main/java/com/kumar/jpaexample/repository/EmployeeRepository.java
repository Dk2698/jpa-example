package com.kumar.jpaexample.repository;

import com.kumar.jpaexample.entity.Employee;
import com.kumar.jpaexample.entity.PassengerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByEmpId(Long empId);

    // delete data where filter using designation
    List<Employee> deleteByDesignation(String designation);

    Employee findTopByDesignationOrderBySalaryDesc(String designation);

    // write query
    //SELECT * FROM employee;
    @Query("select e from Employee e")
    List<Employee> findAllEmployeesQuery();


    // select * from employee e
    //           where e.active=true  and e.designation in ('Manager','Developer');
    @Query("select e from Employee e where e.active=:activeState  and e.designation in :designationList")
    List<Employee> findAllEmployeeByDesignationAndActiveQuery(@Param("activeState")  boolean activeState,
                                                              @Param("designationList") List<String> designationList);


    // update employee e
    // set e.active= true
    // where e.emp_id in(13, 14);
    @Modifying
    @Query("update Employee e set e.active= ?1 where e.empId in ?2")
    int updateEmployeeStateByEmployeeId(Boolean activeState, List<Long> empIdList);
}
