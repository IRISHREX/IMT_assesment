package com.Imp.insuranceManagement.service;

import java.util.List;

import com.Imp.insuranceManagement.dto.InsurancePolicyDTO;

public interface InsurancePolicyService {
    List<InsurancePolicyDTO> getAllInsurancePolicies();
    InsurancePolicyDTO getInsurancePolicyById(Long id);
    InsurancePolicyDTO createInsurancePolicy(InsurancePolicyDTO insurancePolicyDTO);
    InsurancePolicyDTO updateInsurancePolicy(Long id, InsurancePolicyDTO insurancePolicyDTO);
    void deleteInsurancePolicy(Long id);
}
