package com.example.boot.service;

import java.util.List;

import com.example.boot.model.Employee;

public interface EmployeeService {

	Employee save(Employee employee);

	List<Employee> fetchAll();
	Employee fetchEmployee(Employee employee);

}