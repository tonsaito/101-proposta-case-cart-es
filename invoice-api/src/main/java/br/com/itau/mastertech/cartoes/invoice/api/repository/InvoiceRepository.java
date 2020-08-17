package br.com.itau.mastertech.cartoes.invoice.api.repository;

import br.com.itau.mastertech.cartoes.invoice.api.entity.InvoiceEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends CrudRepository<InvoiceEntity, Integer> {

}
