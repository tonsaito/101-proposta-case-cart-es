package br.com.itau.mastertech.cartoes.payment.api.repository;

import br.com.itau.mastertech.cartoes.payment.api.entity.PaymentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends CrudRepository<PaymentEntity, Integer> {

    @Query("SELECT p FROM PaymentEntity p WHERE p.cardId = ?1")
    List<PaymentEntity> findAllByCardId(Integer id);
}
