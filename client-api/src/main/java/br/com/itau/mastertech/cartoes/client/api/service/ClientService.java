package br.com.itau.mastertech.cartoes.client.api.service;

import br.com.itau.mastertech.cartoes.client.api.entity.ClientEntity;

public interface ClientService {
    Iterable<ClientEntity> findAll();
    ClientEntity findById(Integer id);
    ClientEntity save(ClientEntity userEntity);
}
