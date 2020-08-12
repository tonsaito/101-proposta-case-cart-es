package br.com.itau.mastertech.cartoes.card.api.service;

import br.com.itau.mastertech.cartoes.card.api.entity.CardEntity;

public interface CardService {
    Iterable<CardEntity> findAll();
    CardEntity findById(Integer id);
    CardEntity findByNumber(String number);
    CardEntity save(CardEntity cardEntity);
    CardEntity activateByNumber(String number, Boolean status);

}
