package com.globallogic.user.controller;

import com.globallogic.user.exception.ValidDataException;
import com.globallogic.user.model.MessageError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by cristianfgr on 13-02-20.
 */
@ControllerAdvice
@ResponseBody
public class ExceptionControllerAdvice {

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(ValidDataException.class)
    public ResponseEntity<MessageError> handlerException(ValidDataException e) {
        return new ResponseEntity<>(new MessageError(e.getMessage()),
                HttpStatus.UNPROCESSABLE_ENTITY);
    }

}
