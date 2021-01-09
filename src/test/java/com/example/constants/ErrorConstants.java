package com.example.constants;

public final class ErrorConstants {
    private ErrorConstants() {
        throw new IllegalStateException(INITIALIZE_CONSTANT_CLASS_ERROR);
    }

    public static final String INITIALIZE_CONSTANT_CLASS_ERROR = "Can not initialize constant class";
}