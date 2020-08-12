package br.com.itau.mastertech.cartoes.controller;

import br.com.itau.mastertech.cartoes.entity.ClientEntity;
import br.com.itau.mastertech.cartoes.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/v1/clients", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<ClientEntity> getClientsV1(){
        return clientService.findAll();
    }

    @GetMapping(value = "/v1/clients/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ClientEntity getClientByIdV1(@PathVariable(value = "id") Integer id){
        return clientService.findById(id);
    }

    @PostMapping(value = "/v1/clients", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientEntity> saveClientV1(@RequestBody ClientEntity clientEntity){
        ClientEntity client = clientService.save(clientEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(client);
    }


}
