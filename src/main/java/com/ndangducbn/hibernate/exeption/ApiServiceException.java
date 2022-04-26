package com.ndangducbn.hibernate.exeption;

import com.ndangducbn.hibernate.enums.ResponseStatus;
import lombok.Data;

@Data
public class ApiServiceException extends ApiException{
    private ResponseStatus responseStatus;

    public ApiServiceException(ResponseStatus responseStatus) {
        super(responseStatus.code,responseStatus.message);
        this.responseStatus = responseStatus;
    }


    public ApiServiceException(ResponseStatus responseStatus, String errorMsg) {
        super(responseStatus.code,errorMsg);
        this.responseStatus = responseStatus;
    }

}
