package com.daniel.booktrackerapi.domain.book.repo;

import com.daniel.booktrackerapi.domain.book.models.Book;
import com.daniel.booktrackerapi.domain.book.models.BookGenre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepo extends JpaRepository<Book,Long> {

    List<Book> findAllByGenre(BookGenre genre);
}
