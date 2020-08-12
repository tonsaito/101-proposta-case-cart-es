package br.com.itau.mastertech.cartoes.card.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CardModel {

    private String number;
    private Integer clientId;
}
