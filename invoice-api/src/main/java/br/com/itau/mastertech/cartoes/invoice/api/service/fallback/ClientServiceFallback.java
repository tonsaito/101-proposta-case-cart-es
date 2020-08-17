package br.com.itau.mastertech.cartoes.invoice.api.service.fallback;

import br.com.itau.mastertech.cartoes.invoice.api.exception.ServiceNotAvailableException;
import br.com.itau.mastertech.cartoes.invoice.api.model.ClientModel;
import br.com.itau.mastertech.cartoes.invoice.api.service.ClientService;

public class ClientServiceFallback implements ClientService {

    @Override
    public ClientModel getClientById(Integer id) {
        throw new ServiceNotAvailableException("Service not available");
    }
}
