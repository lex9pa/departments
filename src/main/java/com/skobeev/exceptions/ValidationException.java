package com.skobeev.exceptions;


import java.util.List;
import java.util.Map;

public class ValidationException extends Exception {
    private Map<String, List<String>> error;

    public ValidationException(Map<String, List<String>> map) {
        this.error = map;
    }

    public Map<String, List<String>> getError(){
        return error;
    }
}
