package br.com.itau.mastertech.cartoes.controller;

import br.com.itau.mastertech.cartoes.model.CardModel;
import br.com.itau.mastertech.cartoes.model.StatusModel;
import br.com.itau.mastertech.cartoes.entity.CardEntity;
import br.com.itau.mastertech.cartoes.entity.ClientEntity;
import br.com.itau.mastertech.cartoes.service.CardService;
import br.com.itau.mastertech.cartoes.service.ClientService;
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

    @PatchMapping(value = "/v1/cards/{number}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CardEntity activateCardByNumberV1(@PathVariable(name = "number") String number, @RequestBody StatusModel statusModel){
        return cardService.activateByNumber(number, statusModel.getStatus());
    }

    @PostMapping(value = "/v1/cards", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CardEntity> saveCardV1(@RequestBody CardModel cardModel){
        CardEntity cardEntity = new CardEntity();
        ClientEntity client = clientService.findById(cardModel.getClientId());
        cardEntity.setClient(client);
        cardEntity.setNumber(cardModel.getNumber());
        return ResponseEntity.status(HttpStatus.CREATED).body(cardService.save(cardEntity));
    }
}
