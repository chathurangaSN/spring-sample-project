package com.example.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.boot.model.Allocation;

public interface AllocationRepository extends JpaRepository<Allocation, Integer> {
	
	List<Allocation> findByEmpId(Integer id);
}
