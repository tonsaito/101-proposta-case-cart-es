package br.com.itau.mastertech.cartoes.card.api.service.impl;

import br.com.itau.mastertech.cartoes.card.api.exception.CardAlredyExistsException;
import br.com.itau.mastertech.cartoes.card.api.exception.CardInactiveException;
import br.com.itau.mastertech.cartoes.card.api.exception.CardNotFoundException;
import br.com.itau.mastertech.cartoes.card.api.repository.CardRepository;
import br.com.itau.mastertech.cartoes.card.api.service.CardService;
import br.com.itau.mastertech.cartoes.card.api.entity.CardEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;

    @Override
    public Iterable<CardEntity> findAll() {
        return cardRepository.findAll();
    }

    @Override
    public CardEntity findById(Integer id) {
        CardEntity card = cardRepository.findById(id).orElseThrow(() -> new CardNotFoundException("Cartão não encontrado."));
        if(!card.getStatus()){
            throw new CardInactiveException("Cartão inativo");
        }
        return card;
    }

    @Override
    public CardEntity findByNumber(String number) {
        return Optional.ofNullable(cardRepository.findByNumber(number)).orElseThrow(() -> new CardNotFoundException("Cartão não encontrado."));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public CardEntity save(CardEntity cardEntity) {
        if(cardRepository.findByNumber(cardEntity.getNumber()) != null){
            throw new CardAlredyExistsException("Cartão já existente");
        }
        return cardRepository.save(cardEntity);
    }

    @Override
    public CardEntity activateByNumber(String number, Boolean status) {
        CardEntity card = findByNumber(number);
        card.setStatus(status);
        return cardRepository.save(card);
    }
}
