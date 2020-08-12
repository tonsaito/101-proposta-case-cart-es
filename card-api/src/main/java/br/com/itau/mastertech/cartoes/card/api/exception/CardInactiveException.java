package br.com.itau.mastertech.cartoes.card.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY, reason = "Cartão inativo")
public class CardInactiveException extends RuntimeException{

    public CardInactiveException(){
        super();
    }

    public CardInactiveException(String message){
        super(message);
    }
}
