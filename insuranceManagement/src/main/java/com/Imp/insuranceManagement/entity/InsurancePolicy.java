package com.Imp.insuranceManagement.entity;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.Imp.insuranceManagement.dto.ClientDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "insurance_policies")
public class InsurancePolicy {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "policy_number")
    private String policyNumber;

    @Column(name = "type")
    private String type;

    @Column(name = "coverage_amount")
    private Double coverageAmount;

    @Column(name = "premium")
    private Double premium;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;
    
    public InsurancePolicy(Long id, String policyNumber) {
        this.id = id;
        this.policyNumber = policyNumber;
    }
   
}
