package com.Imp.insuranceManagement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Imp.insuranceManagement.dto.ClientDto;
import com.Imp.insuranceManagement.service.ClientService;

@RestController
@RequestMapping("/Imp/clients")
public class ClientController {

    private final ClientService clientService;
    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<ClientDto> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public ClientDto getClientById(@PathVariable Long id) throws Exception {
        return clientService.getClientById(id);
    }

    @PostMapping
    public ClientDto createClient(@RequestBody ClientDto ClientDto) {
        return clientService.createClient(ClientDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateClient(@PathVariable Long id, @RequestBody ClientDto clientDto) throws Exception {
        ClientDto updatedClient = clientService.updateClient(id, clientDto);
        String message = updatedClient.getId() + "-Updated successfully...";
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("client", updatedClient);
        responseMap.put("message", message);
        return ResponseEntity.ok(responseMap);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.ok(id + "-Deleted successfully...");
    }

}

