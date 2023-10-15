package com.fricle.joblisting.service;

import com.fricle.joblisting.model.Employee;
import com.fricle.joblisting.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee findEmployee(String id){
        return employeeRepository.findById(id).get();
    }
    public List<Employee> findAllEmployee(){
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(String employeeId, Employee employee) {
       Employee existingEmployee= employeeRepository.findById(employeeId).get();

        existingEmployee.setDesignation(employee.getDesignation());
        existingEmployee.setExperiences(employee.getExperiences());
        return employeeRepository.save(existingEmployee);

    }

    public void remove(String employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
