package com.Imp.insuranceManagement.service;

import java.util.List;

import com.Imp.insuranceManagement.dto.ClaimDTO;

public interface ClaimService {
    List<ClaimDTO> getAllClaims();
    ClaimDTO getClaimById(Long id) throws Exception;
    ClaimDTO createClaim(ClaimDTO claimDTO);
    ClaimDTO updateClaim(Long id, ClaimDTO claimDTO) throws Exception;
    void deleteClaim(Long id);
}
