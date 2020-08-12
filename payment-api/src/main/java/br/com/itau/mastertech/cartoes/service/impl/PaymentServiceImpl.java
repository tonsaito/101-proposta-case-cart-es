package br.com.itau.mastertech.cartoes.service.impl;

import br.com.itau.mastertech.cartoes.entity.PaymentEntity;
import br.com.itau.mastertech.cartoes.repository.PaymentRepository;
import br.com.itau.mastertech.cartoes.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
}
