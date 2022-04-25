package com.ndangducbn.hibernate.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalException {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity<?> handlerMethodArgumentException(MethodArgumentNotValidException ex) {

        Map<String, String> errorList = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(
                (err) -> {
                    String fieldName = "This field " + ((FieldError) err).getField();
                    String errorMessage = err.getDefaultMessage();

                    errorList.put(fieldName, errorMessage);
                });
        return new ResponseEntity<Object>(errorList, HttpStatus.BAD_REQUEST);
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<Object> handlerException(Exception ex) {
        return new ResponseEntity<Object>("Excepton", HttpStatus.BAD_REQUEST);
    }
}
