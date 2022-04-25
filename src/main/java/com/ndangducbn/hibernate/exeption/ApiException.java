package com.ndangducbn.hibernate.exeption;

import lombok.Data;

@Data
public class ApiException extends RuntimeException{
    private String errorCode;
    private String errorMessage;
}
