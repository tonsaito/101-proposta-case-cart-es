package br.com.itau.mastertech.cartoes.payment.api.service;

import br.com.itau.mastertech.cartoes.payment.api.entity.PaymentEntity;

import java.util.List;

public interface PaymentService {
    List<PaymentEntity> findAllByCardId(Integer id);
    PaymentEntity save(PaymentEntity paymentEntity);
    void deleteByCardId(Integer id);
}
