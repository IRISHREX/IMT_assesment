package com.Imp.insuranceManagement.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Imp.insuranceManagement.dto.InsurancePolicyDTO;
import com.Imp.insuranceManagement.service.InsurancePolicyService;

@RestController
@RequestMapping("/api/policies")
public class InsurancePolicyController {

    private final InsurancePolicyService insurancePolicyService;

    public InsurancePolicyController(InsurancePolicyService insurancePolicyService) {
        this.insurancePolicyService = insurancePolicyService;
    }

    @GetMapping
    public ResponseEntity<List<InsurancePolicyDTO>> getAllInsurancePolicies() {
        List<InsurancePolicyDTO> policies = insurancePolicyService.getAllInsurancePolicies();
        return new ResponseEntity<>(policies, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InsurancePolicyDTO> getInsurancePolicyById(@PathVariable Long id) {
        InsurancePolicyDTO policy = insurancePolicyService.getInsurancePolicyById(id);
        return new ResponseEntity<>(policy, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<InsurancePolicyDTO> createInsurancePolicy(@Validated @RequestBody InsurancePolicyDTO insurancePolicyDTO) {
        InsurancePolicyDTO createdPolicy = insurancePolicyService.createInsurancePolicy(insurancePolicyDTO);
        return new ResponseEntity<>(createdPolicy, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InsurancePolicyDTO> updateInsurancePolicy(@PathVariable Long id, @Validated @RequestBody InsurancePolicyDTO insurancePolicyDTO) {
        InsurancePolicyDTO updatedPolicy = insurancePolicyService.updateInsurancePolicy(id, insurancePolicyDTO);
        return new ResponseEntity<>(updatedPolicy, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInsurancePolicy(@PathVariable Long id) {
        insurancePolicyService.deleteInsurancePolicy(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
