package br.com.itau.mastertech.cartoes.service;

import br.com.itau.mastertech.cartoes.entity.CardEntity;

public interface CardService {
    Iterable<CardEntity> findAll();
    CardEntity findById(Integer id);
    CardEntity findByNumber(String number);
    CardEntity save(CardEntity cardEntity);
    CardEntity activateByNumber(String number, Boolean status);

}
