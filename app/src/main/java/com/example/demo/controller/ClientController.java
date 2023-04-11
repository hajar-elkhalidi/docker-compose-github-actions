package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Client;
import com.example.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/clients")
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    //create client
    @PostMapping("/clients")
    public Client createClient(@Validated @RequestBody Client client) {
        return clientRepository.save(client);
    }

    //get client by id
    @GetMapping("/clients/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable(value = "id") long clientId) throws ResourceNotFoundException {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found for this id ::" + clientId));
        return ResponseEntity.ok().body(client);
    }

    //update client
    @PutMapping("/clients/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable(value = "id") long clientId, @RequestBody Client clientDetails) throws ResourceNotFoundException {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found for this id ::" + clientId));
        client.setId(clientDetails.getId());
        client.setFirstName(clientDetails.getFirstName());
        client.setLastName(clientDetails.getLastName());
        client.setEmail(clientDetails.getEmail());
        client.setGender(clientDetails.getGender());
        client.setIpAddress(clientDetails.getIpAddress());
        clientRepository.save(client);
        return ResponseEntity.ok().body(client);
    }

    //delete client
    @DeleteMapping("/clients/{id}")
    public ResponseEntity<Client> deleteClient(@PathVariable(value = "id") long clientId) throws ResourceNotFoundException {
        clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found for this id ::" + clientId));
        clientRepository.deleteById(clientId);
        return ResponseEntity.ok().build();
    }
    //print hello world
    @GetMapping("/hello")
    public String hello() {
        return "Hello, world!\n";

    }
}
