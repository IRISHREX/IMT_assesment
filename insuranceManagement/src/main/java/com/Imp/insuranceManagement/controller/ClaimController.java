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

import com.Imp.insuranceManagement.dto.ClaimDTO;
import com.Imp.insuranceManagement.service.ClaimService;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {

    private final ClaimService claimService;
    public ClaimController(ClaimService claimService) {
        this.claimService = claimService;
    }

    @GetMapping
    public ResponseEntity<List<ClaimDTO>> getAllClaims() {
        List<ClaimDTO> claimDTOs = claimService.getAllClaims();
        return ResponseEntity.ok(claimDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClaimDTO> getClaimById(@PathVariable Long id) throws Exception {
        ClaimDTO claimDTO = claimService.getClaimById(id);
        return ResponseEntity.ok(claimDTO);
    }

    @PostMapping
    public ResponseEntity<ClaimDTO> createClaim(@Validated @RequestBody ClaimDTO claimDTO) {
        ClaimDTO createdClaimDTO = claimService.createClaim(claimDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdClaimDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClaimDTO> updateClaim(@PathVariable Long id, @Validated @RequestBody ClaimDTO claimDTO) throws Exception {
        ClaimDTO updatedClaimDTO = claimService.updateClaim(id, claimDTO);
        return ResponseEntity.ok(updatedClaimDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClaim(@PathVariable Long id) {
        claimService.deleteClaim(id);
        return ResponseEntity.noContent().build();
    }
}
