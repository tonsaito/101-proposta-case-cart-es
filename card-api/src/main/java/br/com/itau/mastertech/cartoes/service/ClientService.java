package br.com.itau.mastertech.cartoes.service;

import br.com.itau.mastertech.cartoes.model.ClientModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "client-api")
public interface ClientService {

    @GetMapping("/v1/clients/{id}")
    public ClientModel getClientById(@PathVariable Integer id);
}
