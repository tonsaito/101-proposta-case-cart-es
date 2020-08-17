package br.com.itau.mastertech.cartoes.invoice.api.service.impl;

import br.com.itau.mastertech.cartoes.invoice.api.entity.InvoiceEntity;
import br.com.itau.mastertech.cartoes.invoice.api.exception.NoPaymentsToPayException;
import br.com.itau.mastertech.cartoes.invoice.api.model.CardModel;
import br.com.itau.mastertech.cartoes.invoice.api.model.ClientModel;
import br.com.itau.mastertech.cartoes.invoice.api.model.PaymentModel;
import br.com.itau.mastertech.cartoes.invoice.api.repository.InvoiceRepository;
import br.com.itau.mastertech.cartoes.invoice.api.service.InvoiceService;
import br.com.itau.mastertech.cartoes.invoice.api.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Component
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private PaymentService paymentService;

    @Override
    @Transactional
    public InvoiceEntity payInvoice(ClientModel client, CardModel card) {
        List<PaymentModel> payments = paymentService.getPaymentsByCardId(card.getId());
        if(!payments.isEmpty()){
            InvoiceEntity invoiceEntity = new InvoiceEntity();

            Double totalAmount = payments.stream().mapToDouble(o -> o.getValue().doubleValue()).sum();

            invoiceEntity.setDate(new Date());
            invoiceEntity.setTotalAmount(new BigDecimal(totalAmount));

            invoiceEntity = invoiceRepository.save(invoiceEntity);
            paymentService.payInvoiceByCardId(card.getId());
            return invoiceEntity;
        } else{
            throw new NoPaymentsToPayException("No Payments left to pay.");
        }
    }
}
