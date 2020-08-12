package br.com.itau.mastertech.cartoes.card.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Cartão já existente")
public class CardAlredyExistsException extends RuntimeException{

    public CardAlredyExistsException(){
        super();
    }

    public CardAlredyExistsException(String message){
        super(message);
    }
}
