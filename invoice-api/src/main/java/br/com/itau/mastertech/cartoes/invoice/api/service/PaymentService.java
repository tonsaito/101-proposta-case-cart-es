package br.com.itau.mastertech.cartoes.invoice.api.service;

import br.com.itau.mastertech.cartoes.invoice.api.config.FeignConfig;
import br.com.itau.mastertech.cartoes.invoice.api.config.OauthInterceptorConfig;
import br.com.itau.mastertech.cartoes.invoice.api.model.PaymentModel;
import br.com.itau.mastertech.cartoes.invoice.api.model.ResponseInvoicePaymentModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "payment-api", configuration = {OauthInterceptorConfig.class, FeignConfig.class})
public interface PaymentService {

    @GetMapping("/v1/payments/{cardId}")
    public List<PaymentModel> getPaymentsByCardId(@PathVariable Integer cardId);

    @DeleteMapping("/v1/payments/{cardId}")
    public ResponseInvoicePaymentModel payInvoiceByCardId(@PathVariable Integer cardId);
}
