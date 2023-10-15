package com.fricle.joblisting.controller;

import com.fricle.joblisting.model.Employee;
import com.fricle.joblisting.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/create")
    public Employee createEmployee(@RequestBody Employee employee){
        return  employeeService.createEmployee(employee);
    }
    @GetMapping("/getById/{employeeId}")
    public Employee createEmployee(@PathVariable String employeeId){
        return  employeeService.findEmployee(employeeId);
    }

    @PatchMapping("/updateById/{employeeId}")
    public Employee updateEmployee(@PathVariable String employeeId,@RequestBody Employee employee){
        return  employeeService.updateEmployee(employeeId,employee);
    }
    @DeleteMapping("/deleteById/{employeeId}")
    public void deleteEmployee(@PathVariable String employeeId){
        try {
            employeeService.remove(employeeId);
        }
        catch (Exception e){
            System.out.println("No Employee found");
        }

    }

    @GetMapping("/findAll")
    public List<Employee> findAllEmployee(){
        return  employeeService.findAllEmployee();
    }



}
