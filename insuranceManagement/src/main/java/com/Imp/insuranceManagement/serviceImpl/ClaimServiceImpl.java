package com.Imp.insuranceManagement.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.Imp.insuranceManagement.dto.ClaimDTO;
import com.Imp.insuranceManagement.dto.ClientDto;
import com.Imp.insuranceManagement.dto.InsurancePolicyDTO;
import com.Imp.insuranceManagement.entity.Claim;
import com.Imp.insuranceManagement.entity.InsurancePolicy;
import com.Imp.insuranceManagement.repo.ClaimRepository;
import com.Imp.insuranceManagement.service.ClaimService;
@Service
public class ClaimServiceImpl implements ClaimService {
    private final ClaimRepository claimRepository;
    
    public ClaimServiceImpl(ClaimRepository claimRepository) {
        this.claimRepository = claimRepository;
    }

    private Claim convertToEntity(ClaimDTO claimDto) {
        return new Claim(
            claimDto.getId(),
            claimDto.getClaimNumber(),
            claimDto.getDescription(),
            claimDto.getClaimDate(),
            claimDto.getClaimStatus(),
            new InsurancePolicy(claimDto.getInsurancePolicy().getId(), claimDto.getInsurancePolicy().getPolicyNumber())
        );
    }
    private ClaimDTO convertToDto(Claim claim) {
    	ClaimDTO claimDTO = new ClaimDTO();
    	claimDTO.setId(claim.getId());
    	claimDTO.setClaimNumber(claim.getClaimNumber());
    	claimDTO.setDescription(claim.getDescription());
    	claimDTO.setClaimDate(claim.getClaimDate());
    	claimDTO.setClaimStatus(claim.getClaimStatus());     
        InsurancePolicyDTO policyDTO = new InsurancePolicyDTO();
        policyDTO.setId(claim.getInsurancePolicy().getId());
        policyDTO.setPolicyNumber(claim.getInsurancePolicy().getPolicyNumber());
        policyDTO.setType(claim.getInsurancePolicy().getType());
        policyDTO.setCoverageAmount(claim.getInsurancePolicy().getCoverageAmount());
        policyDTO.setPremium(claim.getInsurancePolicy().getPremium());
        policyDTO.setStartDate(claim.getInsurancePolicy().getStartDate());
        policyDTO.setEndDate(claim.getInsurancePolicy().getEndDate());
        ClientDto clientDTO = new ClientDto();
        clientDTO.setId(claim.getInsurancePolicy().getClient().getId());
        clientDTO.setName(claim.getInsurancePolicy().getClient().getName());
        clientDTO.setAddress(claim.getInsurancePolicy().getClient().getAddress());
        clientDTO.setContactInformation(claim.getInsurancePolicy().getClient().getContactInformation());
        clientDTO.setDateOfBirth(claim.getInsurancePolicy().getClient().getDateOfBirth());

        policyDTO.setClient(clientDTO);
        claimDTO.setInsurancePolicy(policyDTO);
        return claimDTO;
    }

    @Override
    public List<ClaimDTO> getAllClaims() {
        List<Claim> claims = claimRepository.findAll();
        return claims.stream()
            .map(this::convertToDto)
            .collect(Collectors.toList());
    }

    @Override
    public ClaimDTO getClaimById(Long id) throws Exception {
        Optional<Claim> optionalClaim = claimRepository.findById(id);
        if (optionalClaim.isPresent()) {
            return convertToDto(optionalClaim.get());
        } else {
            throw new Exception("Claim not found with id: " + id);
        }
    }

    @Override
    public ClaimDTO createClaim(ClaimDTO claimDto) {
        Claim claim = convertToEntity(claimDto);
        Claim savedClaim = claimRepository.save(claim);
        return convertToDto(savedClaim);
    }

    @Override
    public ClaimDTO updateClaim(Long id, ClaimDTO claimDto) throws Exception {
        Optional<Claim> optionalClaim = claimRepository.findById(id);
        if (optionalClaim.isPresent()) {
            Claim claim = optionalClaim.get();
            claim.setClaimNumber(claimDto.getClaimNumber());
            claim.setDescription(claimDto.getDescription());
            claim.setClaimDate(claimDto.getClaimDate());
            claim.setClaimStatus(claimDto.getClaimStatus());
            claim.setInsurancePolicy(new InsurancePolicy(claimDto.getInsurancePolicy().getId(), claimDto.getInsurancePolicy().getPolicyNumber()));
            Claim savedClaim = claimRepository.save(claim);
            return convertToDto(savedClaim);
        } else {
            throw new Exception("Claim not found with id: " + id);
        }
    }

    @Override
    public void deleteClaim(Long id) {
        if (claimRepository.existsById(id)) {
            claimRepository.deleteById(id);
        } else {
            System.out.println("Claim not found with id: " + id);
        }
    }
}
