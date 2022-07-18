package com.daniel.booktrackerapi.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class BookCreationException extends RuntimeException{
    public BookCreationException(String message) {
        super(message);
    }
}
