package com.spring.tdd;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.spring.tdd.model.PolicyModel;
import com.spring.tdd.respository.PolicyRepository;
import com.spring.tdd.service.PolicyService;

@ExtendWith(SpringExtension.class)
public class PolicyServiceTest {
	
	@TestConfiguration
	static class PolicyServiceTestConfiguration {
		@Bean
		public PolicyService policyService() {
			return new PolicyService();
		}
		
		// TODO:: Other services here
	}
	
	@Autowired
	PolicyService policyService;
	@MockBean
	PolicyRepository policyRepository; 
	
	@BeforeEach
	public void setup() {
		LocalDate createdAt = LocalDate.parse("2021-07-23");
		LocalDate updatedAt = LocalDate.parse("2021-07-24");
		
		PolicyModel policyModel = new PolicyModel(
				"007", 
				"policy_test", 
				createdAt, 
				updatedAt, 
				"s3://path/to/bucket"
		);
		
		Mockito.when(policyRepository.findById(policyModel.getId()))
			.thenReturn(Optional.ofNullable(policyModel));
	}
	
	@Test
	public void policyTestServiceValidName() {
		String id = "007";
		boolean isValid = policyService.checkPolicyResource(id);
		
		Assertions.assertEquals(isValid, true);
	}
	
	
}
