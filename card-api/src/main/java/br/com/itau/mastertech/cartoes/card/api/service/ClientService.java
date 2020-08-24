package br.com.itau.mastertech.cartoes.card.api.service;

import br.com.itau.mastertech.cartoes.card.api.config.ClientClientConfig;
import br.com.itau.mastertech.cartoes.card.api.model.ClientModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "client-api", configuration = ClientClientConfig.class)
public interface ClientService {

    @GetMapping("/v1/clients/{id}")
    public ClientModel getClientById(@PathVariable Integer id);
}
