package br.com.itau.mastertech.cartoes.invoice.api.service.fallback;

import br.com.itau.mastertech.cartoes.invoice.api.exception.ServiceNotAvailableException;
import br.com.itau.mastertech.cartoes.invoice.api.model.CardModel;
import br.com.itau.mastertech.cartoes.invoice.api.model.StatusModel;
import br.com.itau.mastertech.cartoes.invoice.api.service.CardService;

public class CardServiceFallback implements CardService {
    @Override
    public CardModel findById(Integer id) {
        throw new ServiceNotAvailableException("Service not available");
    }

    @Override
    public CardModel inactivateCardByNumber(String number, StatusModel statusModel) {
        throw new ServiceNotAvailableException("Service not available");
    }
}
