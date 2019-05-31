package com.example.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.boot.model.Allocation;
import com.example.boot.repository.AllocationRepository;


@Service
public class AllocationServiceImpl implements AllocationService {
	
	@Autowired
	AllocationRepository allocationRepository;

	@Override
	public Allocation save(Allocation allocation){
		
		return allocationRepository.save(allocation);
	}

	@Override
	public List<Allocation> fetchAll(){
		return allocationRepository.findAll();
	}
	@Override
	public Optional<Allocation> findAllocationById(Integer id) {
        return allocationRepository.findById(id);
    }
	public List<Allocation> findAllocationByEmpId(Integer id){
		return allocationRepository.findByEmpId(id);
	}
	
    public List<Allocation> findByEmployeeId(Integer empId) {
        return allocationRepository.findByEmpId(empId);
    }

}
