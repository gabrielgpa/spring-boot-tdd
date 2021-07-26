package com.spring.tdd.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.tdd.model.PolicyModel;

public interface PolicyRepository extends JpaRepository<PolicyModel, String> { }
