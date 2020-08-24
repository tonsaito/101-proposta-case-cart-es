package br.com.itau.mastertech.cartoes.payment.api.service;

import br.com.itau.mastertech.cartoes.payment.api.config.CardClientConfig;
import br.com.itau.mastertech.cartoes.payment.api.model.CardModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "card-api", configuration = CardClientConfig.class)
public interface CardService {

    @GetMapping("/v1/cards/by/{id}")
    CardModel findById(@PathVariable Integer id);
}
