package br.com.itau.mastertech.cartoes.invoice.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CardModel {
    private Integer id;
    private String number;
    private Integer clientId;
    private Boolean status;
}
