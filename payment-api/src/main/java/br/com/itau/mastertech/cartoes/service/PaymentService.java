package br.com.itau.mastertech.cartoes.service;

import br.com.itau.mastertech.cartoes.entity.PaymentEntity;

import java.util.List;

public interface PaymentService {
    List<PaymentEntity> findAllByCardId(Integer id);
    PaymentEntity save(PaymentEntity paymentEntity);
}
