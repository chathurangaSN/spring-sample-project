package com.example.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.boot.model.Employee;
import com.example.boot.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee save(Employee employee){
		
		return employeeRepository.save(employee);
	}
	
	@Override
	public List<Employee> fetchAll(){
		return employeeRepository.findAll();
	}
}
