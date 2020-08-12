package br.com.itau.mastertech.cartoes.card.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Cartão não encontrado")
public class CardNotFoundException extends RuntimeException{

    public CardNotFoundException(){ super(); }

    public CardNotFoundException(String message){
        super(message);
    }
}
