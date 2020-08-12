package br.com.itau.mastertech.cartoes.client.api.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionModel {

    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String path;
}
