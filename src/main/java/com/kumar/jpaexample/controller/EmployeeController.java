package com.kumar.jpaexample.controller;

import com.kumar.jpaexample.dto.FlightBookingAcknowledgement;
import com.kumar.jpaexample.dto.FlightBookingRequest;
import com.kumar.jpaexample.entity.Employee;
import com.kumar.jpaexample.service.EmployeeService;
import com.kumar.jpaexample.service.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class EmployeeController {
    @Autowired
    private FlightBookingService service;


    @PostMapping("/bookFlightTicket")
    public FlightBookingAcknowledgement bookFlightTicket(@RequestBody FlightBookingRequest request){
        return service.bookFlightTicket(request);
    }


    @Autowired
    EmployeeService employeeService;

    @PostMapping("/saveEmployees")
    public List<Employee> saveEmployees(@RequestBody List<Employee> employeeList){
        return  employeeService.saveEmployeeData(employeeList);
    }

    @GetMapping("/getEmployee")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("/getEmployeeById/{empId}")
    public Employee getEmployee(@PathVariable Long empId){
        return employeeService.getEmployeeById(empId);
    }

    @GetMapping("/deleteEmployeeByDesignation/{designation}")
    public List<Employee> deleteEmployeeByDesignation(@PathVariable String designation){
        return employeeService.deleteEmployeeByDesignation(designation);
    }

    @GetMapping("/getEmployeeByDesignation/{designation}")
    public Employee getEmployeeByDesignation(@PathVariable String designation){
        return employeeService.getEmployeeByDesignation(designation);
    }


    @RequestMapping(value = "/pagingAndSortingEmployee/{pageNumber}/{pageSize}", method = RequestMethod.GET)
    public Page<Employee> employeePagination(@PathVariable Integer pageNumber, @PathVariable Integer pageSize){
        return  employeeService.getEmployeePagination(pageNumber, pageSize, null);
    }

    @RequestMapping(value = "/pagingAndSortingEmployee/{pageNumber}/{pageSize}/{sortProperty}", method = RequestMethod.GET)
    public Page<Employee> employeePaginationAndSorting(@PathVariable Integer pageNumber,
                                                       @PathVariable Integer pageSize,
                                                       @PathVariable String sortProperty){
        return  employeeService.getEmployeePagination(pageNumber, pageSize, sortProperty);
    }



    @GetMapping(value = "/findEmployeesByDesignationAndActiveData/{activeState}/{designationList}")
    public List<Employee> findEmployeesByDesignationAndActiveData(@PathVariable boolean activeState,
                                                       @PathVariable List<String> designationList){
        return  employeeService.findEmployeesByDesignationAndActiveData(activeState, designationList);
    }


    @PutMapping("/updateEmployeeState/{activeState}/{empIdList}")
    public  int updateEmployeeState(
            @PathVariable Boolean activeState,
            @PathVariable List<Long> empIdList
    ){
        return  employeeService.updateEmployeeState(activeState, empIdList);
    }
}
