package com.skobeev.exceptions;

public class MyException extends Exception {
    private String error;

    public MyException(String message) {
        this.error = message;
    }

    public String getError() {
        return error;
    }
}
