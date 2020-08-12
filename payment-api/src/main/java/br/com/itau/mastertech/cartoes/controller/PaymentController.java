package br.com.itau.mastertech.cartoes.controller;

import br.com.itau.mastertech.cartoes.model.PaymentModel;
import br.com.itau.mastertech.cartoes.entity.CardEntity;
import br.com.itau.mastertech.cartoes.entity.PaymentEntity;
import br.com.itau.mastertech.cartoes.service.CardService;
import br.com.itau.mastertech.cartoes.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private CardService cardService;

    @PostMapping(value = "/v1/payments", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PaymentEntity> savePaymentV1(@RequestBody PaymentModel paymentModel){
        CardEntity card = cardService.findById(paymentModel.getCardId());
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setCard(card);
        paymentEntity.setDescription(paymentModel.getDescription());
        paymentEntity.setValue(paymentModel.getValue());
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentService.save(paymentEntity));
    }

    @GetMapping(value = "/v1/payments/{cardId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PaymentEntity> getPaymentsByCardIdV1(@PathVariable(name = "cardId") Integer id){
        CardEntity card = cardService.findById(id);
        return paymentService.findAllByCardId(id);
    }
}
