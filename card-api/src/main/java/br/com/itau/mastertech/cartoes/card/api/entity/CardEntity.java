package br.com.itau.mastertech.cartoes.card.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "card")
public class CardEntity {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id;

    @Column(name = "client_id")
    private Integer clientId;

    @Column
    private String number;

    @Column
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Boolean status = false;

}
