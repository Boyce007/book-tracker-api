package com.daniel.booktrackerapi.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BookGenreNotFoundException extends RuntimeException{
    public BookGenreNotFoundException(String message) {
        super(message);
    }
}
