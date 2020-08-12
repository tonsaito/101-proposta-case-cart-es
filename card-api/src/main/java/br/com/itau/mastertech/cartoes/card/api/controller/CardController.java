package br.com.itau.mastertech.cartoes.card.api.controller;

import br.com.itau.mastertech.cartoes.card.api.model.ClientModel;
import br.com.itau.mastertech.cartoes.card.api.entity.CardEntity;
import br.com.itau.mastertech.cartoes.card.api.model.CardModel;
import br.com.itau.mastertech.cartoes.card.api.model.StatusModel;
import br.com.itau.mastertech.cartoes.card.api.service.CardService;
import br.com.itau.mastertech.cartoes.card.api.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CardController {

    @Autowired
    private CardService cardService;

    @Autowired
    private ClientService clientService;

    @GetMapping("/v1/cards")
    public Iterable<CardEntity> getCardsV1(){
        return cardService.findAll();
    }

    @GetMapping("/v1/cards/{number}")
    public CardEntity getCardByNumberV1(@PathVariable(name = "number") String number){
        return cardService.findByNumber(number);
    }

    @GetMapping("/v1/cards/by/{id}")
    public CardEntity getCardByIdV1(@PathVariable(name = "id") Integer id){
        return cardService.findById(id);
    }

    @PatchMapping(value = "/v1/cards/{number}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CardEntity activateCardByNumberV1(@PathVariable(name = "number") String number, @RequestBody StatusModel statusModel){
        return cardService.activateByNumber(number, statusModel.getStatus());
    }

    @PostMapping(value = "/v1/cards", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CardEntity> saveCardV1(@RequestBody CardModel cardModel){
        CardEntity cardEntity = new CardEntity();
        ClientModel client = clientService.getClientById(cardModel.getClientId());
        cardEntity.setClientId(client.getId());
        cardEntity.setNumber(cardModel.getNumber());
        return ResponseEntity.status(HttpStatus.CREATED).body(cardService.save(cardEntity));
    }
}
