package com.noxus.draven.router.advice;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.support.WebExchangeBindException;

import javax.xml.ws.Response;

@ControllerAdvice
public class AdviceException {

    @ExceptionHandler(WebExchangeBindException.class)
    public ResponseEntity<String> handleBindException(WebExchangeBindException e) {
        return new ResponseEntity<String>(toStr(e), HttpStatus.BAD_REQUEST);
    }

    private String toStr(WebExchangeBindException e) {
        return e.getFieldErrors().stream()
                .map(ex -> ex.getField() + ":" + ex.getDefaultMessage())
                .reduce("", (s1, s2) -> s1 + "\n" + s2);
    }


}
