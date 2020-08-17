package br.com.itau.mastertech.cartoes.invoice.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class NoPaymentsToPayException extends RuntimeException{

    public NoPaymentsToPayException(String message){
        super(message);
    }
}
