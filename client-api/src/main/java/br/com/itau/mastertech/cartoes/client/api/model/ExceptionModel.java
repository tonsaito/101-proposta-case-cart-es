package br.com.itau.mastertech.cartoes.client.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
