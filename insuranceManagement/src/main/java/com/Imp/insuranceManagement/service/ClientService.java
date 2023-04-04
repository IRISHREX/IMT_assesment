package com.Imp.insuranceManagement.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Imp.insuranceManagement.dto.ClientDto;
import com.Imp.insuranceManagement.entity.Client;
@Service
public interface ClientService {

    List<ClientDto> getAllClients();

    ClientDto getClientById(Long id)throws Exception;

    ClientDto createClient(ClientDto clientDto);

    ClientDto updateClient(Long id, ClientDto clientDto)throws Exception;

    void deleteClient(Long id);

}
