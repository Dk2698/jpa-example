package com.kumar.jpaexample.service;

import com.kumar.jpaexample.entity.Employee;
import com.kumar.jpaexample.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> saveEmployeeData(List<Employee> employeeList) {
        return  employeeRepository.saveAll(employeeList);
    }

    public List<Employee> getEmployees() {
        return  employeeRepository.findAllEmployeesQuery();
    }

    public Employee getEmployeeById(Long empId) {
        return  employeeRepository.findByEmpId(empId);
    }

    public List<Employee> deleteEmployeeByDesignation(String designation) {
        return  employeeRepository.deleteByDesignation(designation);
    }

    public Employee getEmployeeByDesignation(String designation) {
        return  employeeRepository.findTopByDesignationOrderBySalaryDesc(designation);
    }

    public Page<Employee> getEmployeePagination(Integer pageNumber, Integer pageSize, String sortProperty) {

//        Sort sort = Sort.by(Sort.Direction.ASC,"name")
//        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        Pageable pageable = null;
        if(null != sortProperty){
             pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC,sortProperty);
        }else {
            pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC, "name");
        }


        return  employeeRepository.findAll(pageable);
    }

    public List<Employee> findEmployeesByDesignationAndActiveData(boolean activeState, List<String> designationList) {

        return employeeRepository.findAllEmployeeByDesignationAndActiveQuery(activeState,designationList);
    }

    public int updateEmployeeState(Boolean activeState, List<Long> empIdList) {
        return employeeRepository.updateEmployeeStateByEmployeeId(activeState,empIdList);
    }
}
