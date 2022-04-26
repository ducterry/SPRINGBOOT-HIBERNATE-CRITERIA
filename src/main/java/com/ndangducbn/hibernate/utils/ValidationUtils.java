package com.ndangducbn.hibernate.utils;


import com.ndangducbn.hibernate.enums.ResponseStatus;
import com.ndangducbn.hibernate.exeption.ApiException;
import com.ndangducbn.hibernate.exeption.ApiServiceException;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;


public class ValidationUtils {
    public static void checkRequireFields(Object... fields) {
        for (Object f : fields) {
            if (f == null || StringUtils.isBlank(f.toString())) {
                throw new ApiServiceException(ResponseStatus.ILLEGAL_ARGUMENT);
            }
        }
    }


    public static boolean validateFormatField(Map<String, String> validateMap) {
        if (!StringUtils.isBlank(validateMap.get("customerName"))) {
            if (validateMap.get("customerName").length() > 255 || validateMap.get("customerName").length() < 3) {
                throw new ApiServiceException(ResponseStatus.INPUT_FIELD_INVALID, "Tên KH vi phạm độ dài quy định: 3-255 ký tự");
            }
        }
        return true;
    }
}
