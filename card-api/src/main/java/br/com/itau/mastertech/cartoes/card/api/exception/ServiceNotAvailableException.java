package br.com.itau.mastertech.cartoes.card.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class ServiceNotAvailableException extends RuntimeException {
    public ServiceNotAvailableException(String message) {
        super(message);
    }
}
