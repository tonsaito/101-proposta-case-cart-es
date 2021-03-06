package br.com.itau.mastertech.cartoes.invoice.api.service;

import br.com.itau.mastertech.cartoes.invoice.api.config.FeignConfig;
import br.com.itau.mastertech.cartoes.invoice.api.config.OauthInterceptorConfig;
import br.com.itau.mastertech.cartoes.invoice.api.model.ClientModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "client-api", configuration = {OauthInterceptorConfig.class, FeignConfig.class})
public interface ClientService {

    @GetMapping("/v1/clients/{id}")
    public ClientModel getClientById(@PathVariable Integer id);
}
