package com.exemplo.starterkit.api.exceptionhandler;

import com.exemplo.starterkit.domain.exception.DataIntegratyViolationException;
import com.exemplo.starterkit.domain.exception.UserNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Date;

@ControllerAdvice
public class UserControllerAdvice {

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<MessageExceptionHandler> userNotFound(UserNotFoundException userNotFoundException, HttpServletRequest request) {
        MessageExceptionHandler error =
                new MessageExceptionHandler(new Date(), HttpStatus.NOT_FOUND.value(), "Usuário não encontrado!");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ResponseBody
    @ExceptionHandler(DataIntegratyViolationException.class)
    public ResponseEntity<MessageExceptionHandler> dataIntegrityViolationNotFound(DataIntegratyViolationException dataIntegratyViolationException, HttpServletRequest request) {
        MessageExceptionHandler error =
                new MessageExceptionHandler(new Date(), HttpStatus.BAD_REQUEST.value(), "E-mail já cadastrado!");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}