package com.produtos.api_teste.model.execption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ResourseNotfaund extends RuntimeException{
    public ResourseNotfaund(String mensagem){
        super(mensagem);
    }
}
