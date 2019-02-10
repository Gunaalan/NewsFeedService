package com.company.exception;

/**
 * Created by gunaas
 */
public class FlipKartException extends RuntimeException {

    public FlipKartException(String message) {
        super(message);
    }

    public FlipKartException(String message, Throwable cause) {
        super(message, cause);
    }
}
