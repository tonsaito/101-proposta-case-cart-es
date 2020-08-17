package br.com.itau.mastertech.cartoes.invoice.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class CardDoesNotBelongToClientException extends RuntimeException{

    public CardDoesNotBelongToClientException(String message){
        super(message);
    }
}
