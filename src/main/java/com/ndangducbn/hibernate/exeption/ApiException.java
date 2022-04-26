package com.ndangducbn.hibernate.exeption;

import lombok.Data;

@Data
public class ApiException extends RuntimeException {
    private int code;
    private String errorCode;

    public ApiException(int code, String errorMsg) {
        super(errorMsg);
        this.code = code;
    }

    public ApiException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}
