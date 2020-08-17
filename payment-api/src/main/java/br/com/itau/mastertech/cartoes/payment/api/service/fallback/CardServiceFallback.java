package br.com.itau.mastertech.cartoes.payment.api.service.fallback;

import br.com.itau.mastertech.cartoes.payment.api.exception.ServiceNotAvailableException;
import br.com.itau.mastertech.cartoes.payment.api.model.CardModel;
import br.com.itau.mastertech.cartoes.payment.api.service.CardService;

public class CardServiceFallback implements CardService {

    @Override
    public CardModel findById(Integer id) {
        throw new ServiceNotAvailableException("Service not available");
    }
}
