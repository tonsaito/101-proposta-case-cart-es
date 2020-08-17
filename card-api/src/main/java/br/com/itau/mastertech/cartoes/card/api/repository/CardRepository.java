package br.com.itau.mastertech.cartoes.card.api.repository;

import br.com.itau.mastertech.cartoes.card.api.entity.CardEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends CrudRepository<CardEntity, Integer> {

    @Query("SELECT c FROM CardEntity c WHERE c.number = ?1")
    CardEntity findByNumber(String number);

}
