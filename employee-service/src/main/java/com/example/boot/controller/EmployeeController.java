package com.example.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.boot.model.Employee;
import com.example.boot.model.Project;
import com.example.boot.service.EmployeeService;

@RestController
@CrossOrigin()
@RequestMapping(value="/api")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	
	@RequestMapping(value ="/employee",method = RequestMethod.POST)
	public Employee save(@RequestBody Employee employee){
		return employeeService.save(employee);
	}
	@RequestMapping(value ="/employee", method = RequestMethod.GET)
	public List<Employee> fetchAllStocks(){
		return employeeService.fetchAll();
	}
	@RequestMapping(value = "/employee/{id}",method = RequestMethod.GET)
	public ResponseEntity<Employee> fetctEmployee(@PathVariable Integer id) {
		Employee employee = new Employee();
		employee.setId(id);
		Employee employee2 =employeeService.fetchEmployee(employee);
		if(employee2==null) {
			 return ResponseEntity.notFound().build();
		 }else{
			 return ResponseEntity.ok(employee2);
		 }
	}
	
	@RequestMapping(value = "/employee/{id}/project",method = RequestMethod.GET)
	public ResponseEntity<List<Project>> fetchAllEmployeeProjects(@PathVariable Integer id) {
		Employee employee = new Employee();
		employee.setId(id);
		Employee employee2 =employeeService.fetchEmployee(employee);
		if(employee2==null) {
			 return ResponseEntity.notFound().build();
		 }else{
			 return ResponseEntity.ok(employee2.getProjects());
}
	}

}
