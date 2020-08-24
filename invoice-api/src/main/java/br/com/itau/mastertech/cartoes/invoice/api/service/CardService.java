package br.com.itau.mastertech.cartoes.invoice.api.service;

import br.com.itau.mastertech.cartoes.invoice.api.config.FeignConfig;
import br.com.itau.mastertech.cartoes.invoice.api.config.OauthInterceptorConfig;
import br.com.itau.mastertech.cartoes.invoice.api.model.CardModel;
import br.com.itau.mastertech.cartoes.invoice.api.model.StatusModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "card-api", configuration = {OauthInterceptorConfig.class, FeignConfig.class})
public interface CardService {

    @GetMapping("/v1/cards/by/{id}")
    CardModel findById(@PathVariable Integer id);

    @PatchMapping("/v1/cards/{number}")
    CardModel inactivateCardByNumber(@PathVariable String number, @RequestBody StatusModel statusModel);
}
