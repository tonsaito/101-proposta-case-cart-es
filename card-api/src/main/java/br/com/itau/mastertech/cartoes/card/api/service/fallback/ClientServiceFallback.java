package br.com.itau.mastertech.cartoes.card.api.service.fallback;

import br.com.itau.mastertech.cartoes.card.api.exception.ServiceNotAvailableException;
import br.com.itau.mastertech.cartoes.card.api.model.ClientModel;
import br.com.itau.mastertech.cartoes.card.api.service.ClientService;

public class ClientServiceFallback implements ClientService {

    @Override
    public ClientModel getClientById(Integer id) {
        throw new ServiceNotAvailableException("client service not available");
    }
}
