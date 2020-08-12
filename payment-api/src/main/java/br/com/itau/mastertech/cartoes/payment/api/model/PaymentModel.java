package br.com.itau.mastertech.cartoes.payment.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentModel {

    private Integer cardId;
    private String description;
    private BigDecimal value;
}
