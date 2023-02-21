package com.example.product;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.executable.ValidateOnExecution;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ProductControllerAdvice {
    @ExceptionHandler(ProductException.class)
    public String exception(ProductException e)
    {
        return e.getMessage();
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    Map<String,String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String,String> map=new HashMap<>();
        ex.getBindingResult().getFieldErrors().stream().forEach(error->{map.put(error.getField(),error.getDefaultMessage());});
        return map;
}}
