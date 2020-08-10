package br.com.itau.mastertech.cartoes.service.impl;

import br.com.itau.mastertech.cartoes.entity.CardEntity;
import br.com.itau.mastertech.cartoes.exception.CardNotFoundException;
import br.com.itau.mastertech.cartoes.repository.CardRepository;
import br.com.itau.mastertech.cartoes.service.CardService;
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
        return cardRepository.findById(id).orElseThrow(() -> new CardNotFoundException("Cartão não encontrado."));
    }

    @Override
    public CardEntity findByNumber(String number) {
        return Optional.of(cardRepository.findByNumber(number)).orElseThrow(() -> new CardNotFoundException("Cartão não encontrado."));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public CardEntity save(CardEntity cardEntity) {
        return cardRepository.save(cardEntity);
    }

    @Override
    public CardEntity activateByNumber(String number, Boolean status) {
        CardEntity card = findByNumber(number);
        card.setStatus(status);
        return cardRepository.save(card);
    }
}
