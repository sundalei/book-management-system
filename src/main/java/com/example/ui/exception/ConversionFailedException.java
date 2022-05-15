package com.example.ui.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author dsun1
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ConversionFailedException extends RuntimeException {

    public ConversionFailedException(String message) {
        super(message);
    }
}
