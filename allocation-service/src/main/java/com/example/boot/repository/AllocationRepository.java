package com.example.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.boot.model.Allocation;

public interface AllocationRepository extends JpaRepository<Allocation, Integer> {

}
