package br.com.itau.mastertech.cartoes.invoice.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseInvoicePaymentModel {

    private Integer id;
    private BigDecimal totalAmout;
    private Date date;
}
