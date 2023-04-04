package com.Imp.insuranceManagement.dto;

import java.time.LocalDate;

import com.Imp.insuranceManagement.entity.ClaimStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClaimDTO {

	private Long id;
    private String claimNumber;
    private String description;
    private LocalDate claimDate;
    private ClaimStatus claimStatus;
    private InsurancePolicyDTO insurancePolicy;
}