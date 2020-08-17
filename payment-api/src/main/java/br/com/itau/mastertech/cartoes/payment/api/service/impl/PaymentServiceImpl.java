package br.com.itau.mastertech.cartoes.payment.api.service.impl;

import br.com.itau.mastertech.cartoes.payment.api.repository.PaymentRepository;
import br.com.itau.mastertech.cartoes.payment.api.entity.PaymentEntity;
import br.com.itau.mastertech.cartoes.payment.api.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public List<PaymentEntity> findAllByCardId(Integer id) {
        return paymentRepository.findAllByCardId(id);
    }

    @Override
    public PaymentEntity save(PaymentEntity paymentEntity) {
        return paymentRepository.save(paymentEntity);
    }

    @Override
    @Transactional
    public void deleteByCardId(Integer cardId) {
        paymentRepository.deleteByCardId(cardId);
    }
}
