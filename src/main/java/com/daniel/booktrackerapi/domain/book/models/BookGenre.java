package com.daniel.booktrackerapi.domain.book.models;

public enum BookGenre {

    SCIENCE_FICTION("Science fiction"),NON_FICTION("Non fiction"),ROMANCE("Romance"),ACTION("Action"),
    FANTASY("Fantasy"),MANGA("Manga"),ADVENTURE("Adventure");

    private String name;

    BookGenre(String name) {
        this.name = name;
    }
}
