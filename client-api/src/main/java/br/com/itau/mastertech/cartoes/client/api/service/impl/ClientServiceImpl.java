package br.com.itau.mastertech.cartoes.client.api.service.impl;

import br.com.itau.mastertech.cartoes.client.api.entity.ClientEntity;
import br.com.itau.mastertech.cartoes.client.api.exception.ClientNotFoundException;
import br.com.itau.mastertech.cartoes.client.api.repository.ClientRepository;
import br.com.itau.mastertech.cartoes.client.api.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Iterable<ClientEntity> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public ClientEntity findById(Integer id) {
        return clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException("Cliente não encontrado"));
    }

    @Override
    public ClientEntity save(ClientEntity userEntity) {
        return clientRepository.save(userEntity);
    }
}
