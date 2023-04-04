package com.Imp.insuranceManagement.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.Imp.insuranceManagement.dto.ClientDto;
import com.Imp.insuranceManagement.dto.InsurancePolicyDTO;
import com.Imp.insuranceManagement.entity.Client;
import com.Imp.insuranceManagement.entity.InsurancePolicy;
import com.Imp.insuranceManagement.repo.ClientRepository;
import com.Imp.insuranceManagement.repo.InsurancePolicyRepository;
import com.Imp.insuranceManagement.service.InsurancePolicyService;

import jakarta.persistence.EntityNotFoundException;

    @Service
    public class InsurancePolicyServiceImpl implements InsurancePolicyService {

        private final InsurancePolicyRepository policyRepository;
        private final ClientRepository clientRepository;

        public InsurancePolicyServiceImpl(InsurancePolicyRepository policyRepository, ClientRepository clientRepository) {
            this.policyRepository = policyRepository;
            this.clientRepository = clientRepository;
        }

        @Override
        public List<InsurancePolicyDTO> getAllInsurancePolicies() {
            List<InsurancePolicy> policies = policyRepository.findAll();
            return policies.stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());
        }

        @Override
        public InsurancePolicyDTO getInsurancePolicyById(Long id) {
            InsurancePolicy policy = policyRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Policy with id " + id + " not found"));
            return convertToDTO(policy);
        }

        @Override
        public InsurancePolicyDTO createInsurancePolicy(InsurancePolicyDTO insurancePolicyDTO) {
            InsurancePolicy policy = convertToEntity(insurancePolicyDTO);
            policy.setId(null);
            Client client = clientRepository.findById(insurancePolicyDTO.getClient().getId())
                    .orElseThrow(() -> new EntityNotFoundException("Client with id " + insurancePolicyDTO.getClient().getId() + " not found"));
            policy.setClient(client);
            policy = policyRepository.save(policy);
            return convertToDTO(policy);
        }

        @Override
        public InsurancePolicyDTO updateInsurancePolicy(Long id, InsurancePolicyDTO insurancePolicyDTO) {
            InsurancePolicy policy = policyRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Policy with id " + id + " not found"));
            policy.setPolicyNumber(insurancePolicyDTO.getPolicyNumber());
            policy.setType(insurancePolicyDTO.getType());
            policy.setCoverageAmount(insurancePolicyDTO.getCoverageAmount());
            policy.setPremium(insurancePolicyDTO.getPremium());
            policy.setStartDate(insurancePolicyDTO.getStartDate());
            policy.setEndDate(insurancePolicyDTO.getEndDate());
            Client client = clientRepository.findById(insurancePolicyDTO.getClient().getId())
                    .orElseThrow(() -> new EntityNotFoundException("Client with id " + insurancePolicyDTO.getClient().getId() + " not found"));
            policy.setClient(client);
            policy = policyRepository.save(policy);
            return convertToDTO(policy);
        }

        @Override
        public void deleteInsurancePolicy(Long id) {
            if (!policyRepository.existsById(id)) {
                throw new EntityNotFoundException("Policy with id " + id + " not found");
            }
            policyRepository.deleteById(id);
        }

        private InsurancePolicyDTO convertToDTO(InsurancePolicy policy) {
            InsurancePolicyDTO policyDTO = new InsurancePolicyDTO();
            policyDTO.setId(policy.getId());
            policyDTO.setPolicyNumber(policy.getPolicyNumber());
            policyDTO.setType(policy.getType());
            policyDTO.setCoverageAmount(policy.getCoverageAmount());
            policyDTO.setPremium(policy.getPremium());
            policyDTO.setStartDate(policy.getStartDate());
            policyDTO.setEndDate(policy.getEndDate());
            ClientDto clientDTO = new ClientDto();
            clientDTO.setId(policy.getClient().getId());
            clientDTO.setName(policy.getClient().getName());
            clientDTO.setAddress(policy.getClient().getAddress());
            clientDTO.setContactInformation(policy.getClient().getContactInformation());
            clientDTO.setDateOfBirth(policy.getClient().getDateOfBirth());
            policyDTO.setClient(clientDTO);
            return policyDTO;
        }

        private InsurancePolicy convertToEntity(InsurancePolicyDTO policyDTO) {
            InsurancePolicy policy = new InsurancePolicy();
            if (policyDTO.getId() != null) {
                policy.setId(policyDTO.getId());
            }
            policy.setPolicyNumber(policyDTO.getPolicyNumber());
            policy.setType(policyDTO.getType());
            policy.setCoverageAmount(policyDTO.getCoverageAmount());
            policy.setPremium(policyDTO.getPremium());
            policy.setStartDate(policyDTO.getStartDate());
            policy.setEndDate(policyDTO.getEndDate());
            policy.setClient(clientRepository.findById(policyDTO.getClient().getId())
                    .orElseThrow(() -> new EntityNotFoundException("Client with id " + policyDTO.getClient().getId() + " not found")));
            return policy;
        }
    }
    
