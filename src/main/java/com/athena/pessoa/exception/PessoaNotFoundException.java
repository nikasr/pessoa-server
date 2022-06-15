package com.athena.pessoa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PessoaNotFoundException extends Exception {

    public PessoaNotFoundException(Long id) {
        super("Pessoa não encontrada com ID " + id);
    }
}
