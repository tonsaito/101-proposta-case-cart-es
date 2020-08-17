package br.com.itau.mastertech.cartoes.invoice.api.service.fallback;

import br.com.itau.mastertech.cartoes.invoice.api.exception.ServiceNotAvailableException;
import br.com.itau.mastertech.cartoes.invoice.api.model.PaymentModel;
import br.com.itau.mastertech.cartoes.invoice.api.model.ResponseInvoicePaymentModel;
import br.com.itau.mastertech.cartoes.invoice.api.service.PaymentService;

import java.util.List;

public class PaymentServiceFallback implements PaymentService {
    @Override
    public List<PaymentModel> getPaymentsByCardId(Integer cardId) {
        throw new ServiceNotAvailableException("Service not available");
    }

    @Override
    public ResponseInvoicePaymentModel payInvoiceByCardId(Integer cardId) {
        throw new ServiceNotAvailableException("Service not available");
    }
}
