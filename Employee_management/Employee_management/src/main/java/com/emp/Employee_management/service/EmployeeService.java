package com.emp.Employee_management.service;

import com.emp.Employee_management.Repository.EmployeeRepository;
import com.emp.Employee_management.exception.EmployeeNotFoundException;
import com.emp.Employee_management.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepository.findEmployeeById(id)
                .orElseThrow(() -> new EmployeeNotFoundException
                        ("Employee by id "+id+"was not found"));
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        Employee existingEmployee = this.employeeRepository
                .findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException
                        ("Employee by id "+id+"was not found"));
        this.employeeRepository.delete(existingEmployee);

    }
}