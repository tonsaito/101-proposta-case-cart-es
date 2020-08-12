package br.com.itau.mastertech.cartoes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Cliente não encontrado")
public class ClientNotFoundException extends RuntimeException{

    public ClientNotFoundException(){ super(); }

    public ClientNotFoundException(String message){
        super(message);
    }
}
