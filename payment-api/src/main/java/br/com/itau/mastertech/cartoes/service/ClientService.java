package br.com.itau.mastertech.cartoes.service;

import br.com.itau.mastertech.cartoes.entity.ClientEntity;

public interface ClientService {
    Iterable<ClientEntity> findAll();
    ClientEntity findById(Integer id);
    ClientEntity save(ClientEntity userEntity);
}
