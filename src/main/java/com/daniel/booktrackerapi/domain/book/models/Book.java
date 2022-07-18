package com.daniel.booktrackerapi.domain.book.models;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name = "book-table")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;

    private BookGenre genre;

    public Book(String name, BookGenre genre) {
        this.name = name;
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(name, book.name) && genre == book.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, genre);
    }
}
