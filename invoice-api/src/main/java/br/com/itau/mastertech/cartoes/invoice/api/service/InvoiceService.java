package br.com.itau.mastertech.cartoes.invoice.api.service;

import br.com.itau.mastertech.cartoes.invoice.api.entity.InvoiceEntity;
import br.com.itau.mastertech.cartoes.invoice.api.model.CardModel;
import br.com.itau.mastertech.cartoes.invoice.api.model.ClientModel;

public interface InvoiceService {
    InvoiceEntity payInvoice(ClientModel clientModel, CardModel card);
}
