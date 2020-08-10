package br.com.itau.mastertech.cartoes.config;

import java.time.LocalDateTime;
import br.com.itau.mastertech.cartoes.exception.CardNotFoundException;
import br.com.itau.mastertech.cartoes.exception.ClientNotFoundException;
import br.com.itau.mastertech.cartoes.model.ExceptionModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { ClientNotFoundException.class, CardNotFoundException.class })
    protected ResponseEntity<Object> handleConflict(
            RuntimeException ex, WebRequest request) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        ExceptionModel exceptionModel = new ExceptionModel();
        exceptionModel.setTimestamp(LocalDateTime.now());
        exceptionModel.setStatus(httpStatus.value());
        exceptionModel.setError(httpStatus.getReasonPhrase());
        exceptionModel.setMessage(ex.getMessage());
        exceptionModel.setPath(((ServletWebRequest)request).getRequest().getRequestURI().toString());
        return ResponseEntity.status(httpStatus).body(exceptionModel);
    }
}