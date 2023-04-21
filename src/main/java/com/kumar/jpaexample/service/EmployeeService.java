package com.kumar.jpaexample.service;

import com.kumar.jpaexample.entity.Employee;
import com.kumar.jpaexample.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        return  employeeRepository.findAll();
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
}
