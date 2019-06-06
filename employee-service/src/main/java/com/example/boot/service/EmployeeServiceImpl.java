package com.example.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.boot.model.Employee;
import com.example.boot.model.EmployeeAllocation;
import com.example.boot.model.Telephone;
import com.example.boot.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee save(Employee employee){
		
		for (Telephone telephone : employee.getTelephones()) {
			telephone.setEmployee(employee);
		}
		
		return employeeRepository.save(employee);
	}
	
	@Override
	public List<Employee> fetchAll(){
		return employeeRepository.findAll();
	}
	
	@Override
	public Employee fetchEmployee(Employee employee) {
		Optional<Employee> optionalEmployee = employeeRepository.findById(employee.getId());
		if (optionalEmployee.isPresent()) {
			//fetch project allocation
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders httpHeaders = new HttpHeaders();

            //extract token from context
            OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
            httpHeaders.add("Authorization", "bearer ".concat(details.getTokenValue()));

            ResponseEntity<EmployeeAllocation> responseEntity;
            HttpEntity<String> entity = new HttpEntity<>("", httpHeaders);
            responseEntity = restTemplate.exchange("http://allocation-service/allocationcloud/allocation/employee/".concat(employee.getId().toString()), HttpMethod.GET, entity, EmployeeAllocation.class);
            Employee employee1 = optionalEmployee.get();
//            System.out.println(responseEntity.getBody().getEmpId()+">>>>>>>>>");
            employee1.setAllocations(responseEntity.getBody());
            return employee1;
			//return optionalEmployee.get();
		}else {
			return null;
		}
	}
	
}
