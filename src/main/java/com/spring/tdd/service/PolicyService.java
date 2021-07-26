package com.spring.tdd.service;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.tdd.model.PolicyModel;
import com.spring.tdd.respository.PolicyRepository;

@Service
public class PolicyService {
	
	@Autowired
	PolicyRepository policyRepository;
	
	public boolean checkPolicyResource(String id) {
		if (id == null || id.isEmpty())
			return false;
		
		Optional<PolicyModel> policy = policyRepository.findById(id);
		
		return !Objects.isNull(policy.get().getResourceUrl()) 
				&& !policy.get().getResourceUrl().isEmpty();
	}

}
