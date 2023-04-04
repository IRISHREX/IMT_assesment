package com.Imp.insuranceManagement.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Imp.insuranceManagement.entity.Claim;
import com.Imp.insuranceManagement.entity.InsurancePolicy;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {
    
    List<Claim> findByInsurancePolicy(InsurancePolicy insurancePolicy);
    
}
