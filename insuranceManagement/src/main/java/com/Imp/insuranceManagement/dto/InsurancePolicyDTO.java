package com.Imp.insuranceManagement.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class InsurancePolicyDTO {
    private Long id;
    private String policyNumber;
    private String type;
    private Double coverageAmount;
    private Double premium;
    private LocalDate startDate;
    private LocalDate endDate;
    private ClientDto client;
    public InsurancePolicyDTO(Long id, String policyNumber) {
        this.id = id;
        this.policyNumber = policyNumber;
    }
}