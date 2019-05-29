package com.example.boot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.boot.model.Allocation;
import com.example.boot.service.AllocationService;

@RestController
@RequestMapping(value="/allocationcloud")
public class AllocationController {
	@Autowired
	AllocationService allocationService;
	
	
	@RequestMapping(value ="/allocation",method = RequestMethod.POST)
	public Allocation save(@RequestBody Allocation allocation ){
		return allocationService.save(allocation);
	}
	@RequestMapping(value ="/allocation", method = RequestMethod.GET)
	public List<Allocation> fetchAllStocks(){
		return allocationService.fetchAll();
	}
	@RequestMapping(value = "/allocation/{id}",method = RequestMethod.GET)
	public ResponseEntity<Allocation> findUserById(@PathVariable Integer id) {
        Optional<Allocation> allocation = allocationService.findAllocationById(id);
        if (!allocation.isPresent()) {
            return ResponseEntity.notFound().build();
        }else {

        return ResponseEntity.ok(allocation.get());
        }
    }
	@RequestMapping(value ="/employee/{id}", method = RequestMethod.GET)
	public List<Allocation> fetchAllStocks(@PathVariable Integer id){
		return allocationService.findAllocationByEmpId(id);
	}
	
	

}
