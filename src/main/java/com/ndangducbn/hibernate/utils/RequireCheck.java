package com.ndangducbn.hibernate.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class RequireCheck {
    private RequireCheck() {

    }

    public static RequireCheck newBuilder() {
        return new RequireCheck();
    }

    private List<String> invalidField = new ArrayList<>();

    public RequireCheck checkBlank(String key, Object value) {
        if (value == null || StringUtils.isBlank(value.toString())) {
            invalidField.add(key);
        }
        return this;
    }

    public RequireCheck setInvalid(String key, Object value) {
        invalidField.add(key);
        return this;
    }

    public List<String> build() {
        return invalidField;
    }
}
