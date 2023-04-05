package com.produtos.api_teste.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.produtos.api_teste.model.erro.ErrorMesage;
import com.produtos.api_teste.model.execption.ResourseNotfaund;



@ControllerAdvice
public class RestExcepitonHandler {
   @ExceptionHandler(ResourseNotfaund.class)
    public ResponseEntity <?> handleResourceNotFaund(ResourseNotfaund ex){
        ErrorMesage erro = new ErrorMesage("Not Faund" ,
         HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
    }
    
}
