package com.kumar.jpaexample.repository;

import com.kumar.jpaexample.entity.Employee;
import com.kumar.jpaexample.entity.PassengerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByEmpId(Long empId);

    // delete data where filter using designation
    List<Employee> deleteByDesignation(String designation);

    Employee findTopByDesignationOrderBySalaryDesc(String designation);
}
