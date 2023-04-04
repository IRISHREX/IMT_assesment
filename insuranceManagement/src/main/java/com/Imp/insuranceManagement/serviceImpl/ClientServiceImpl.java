package com.Imp.insuranceManagement.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Imp.insuranceManagement.dto.ClientDto;
import com.Imp.insuranceManagement.entity.Client;
import com.Imp.insuranceManagement.repo.ClientRepository;
import com.Imp.insuranceManagement.service.ClientService;
@Service
public class ClientServiceImpl implements ClientService {
    
    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    private ClientDto convertToDto(Client client) {
        return new ClientDto(
            client.getId(),
            client.getName(),
            client.getDateOfBirth(),
            client.getAddress(),
            client.getContactInformation()
        );
    }

    private Client convertToEntity(ClientDto clientDto) {
        return new Client(
            clientDto.getId(),
            clientDto.getName(),
            clientDto.getDateOfBirth(),
            clientDto.getAddress(),
            clientDto.getContactInformation()
        );
    }

    @Override
    public List<ClientDto> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream()
            .map(this::convertToDto)
            .collect(Collectors.toList());
    }

    @Override
    public ClientDto getClientById(Long id) throws Exception {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            return convertToDto(optionalClient.get());
        } else {
            throw new Exception("Client not found with id: " + id);
        }
    }

    @Override
    public ClientDto createClient(ClientDto clientDto) {     
        Client client = convertToEntity(clientDto);
        Client savedClient = clientRepository.save(client);
        return convertToDto(savedClient);
    }

    @Override
    public ClientDto updateClient(Long id, ClientDto clientDto) throws Exception {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            client.setName(clientDto.getName());
            client.setDateOfBirth(clientDto.getDateOfBirth());
            client.setAddress(clientDto.getAddress());
            client.setContactInformation(clientDto.getContactInformation());
            Client savedClient = clientRepository.save(client);
            return convertToDto(savedClient);
        } else {
            throw new Exception("Client not found with id: " + id);
        }
    }

    @Override
    public void deleteClient(Long id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
        } else {
            System.out.println("Client not found with id: " + id);
        }
    }
    
}
