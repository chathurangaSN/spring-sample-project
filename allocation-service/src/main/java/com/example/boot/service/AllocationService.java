package com.example.boot.service;

import java.util.List;
import java.util.Optional;

import com.example.boot.model.Allocation;

public interface AllocationService {

	Allocation save(Allocation allocation);

	List<Allocation> fetchAll();
	
	Optional<Allocation> findAllocationById(Integer id);
	
	List<Allocation> findAllocationByEmpId(Integer id);

}