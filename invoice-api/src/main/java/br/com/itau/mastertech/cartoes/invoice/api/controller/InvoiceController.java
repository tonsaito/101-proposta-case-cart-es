package br.com.itau.mastertech.cartoes.invoice.api.controller;

import br.com.itau.mastertech.cartoes.invoice.api.entity.InvoiceEntity;
import br.com.itau.mastertech.cartoes.invoice.api.exception.CardDoesNotBelongToClientException;
import br.com.itau.mastertech.cartoes.invoice.api.model.*;
import br.com.itau.mastertech.cartoes.invoice.api.service.CardService;
import br.com.itau.mastertech.cartoes.invoice.api.service.ClientService;
import br.com.itau.mastertech.cartoes.invoice.api.service.InvoiceService;
import br.com.itau.mastertech.cartoes.invoice.api.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InvoiceController {

    @Autowired
    private CardService cardService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/v1/invoice/{clientId}/{cardId}")
    public List<PaymentModel> getInvoiceByClientIdAndCardIdV1(@PathVariable Integer clientId, @PathVariable Integer cardId){
        ClientModel client = clientService.getClientById(clientId);
        CardModel card = cardService.findById(cardId);
        if(card.getClientId().equals(client.getId())){
            return paymentService.getPaymentsByCardId(card.getId());
        } else{
            throw new CardDoesNotBelongToClientException("Card does not belong to client.");
        }
    }

    @PostMapping("/v1/invoice/{clientId}/{cardId}/pay")
    public InvoiceEntity payInvoiceCardByClientIdAndCardIdV1(@PathVariable Integer clientId, @PathVariable Integer cardId){
        ClientModel client = clientService.getClientById(clientId);
        CardModel card = cardService.findById(cardId);
        if(card.getClientId().equals(client.getId())){
            return invoiceService.payInvoice(client, card);
        } else{
            throw new CardDoesNotBelongToClientException("Card does not belong to client.");
        }
    }

    @PostMapping("/v1/invoice/{clientId}/{cardId}/invalidate")
    public ResponseEntity<ResponseStatusModel> invalidateCardByClientIdAndCardIdV1(@PathVariable Integer clientId, @PathVariable Integer cardId){
        ClientModel client = clientService.getClientById(clientId);
        CardModel card = cardService.findById(cardId);
        if(card.getClientId().equals(client.getId())){
            cardService.inactivateCardByNumber(card.getNumber(), new StatusModel(Boolean.FALSE));
            return ResponseEntity.ok(new ResponseStatusModel("ok"));
        } else{
            throw new CardDoesNotBelongToClientException("Card does not belong to client.");
        }
    }

}
