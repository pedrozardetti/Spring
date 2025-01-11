package br.com.gestao_vagas.exceptions;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerRest {

    @
    public void handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {

    }
}
