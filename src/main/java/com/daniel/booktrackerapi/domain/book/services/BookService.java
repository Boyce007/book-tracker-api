package com.daniel.booktrackerapi.domain.book.services;

import com.daniel.booktrackerapi.domain.book.models.Book;
import com.daniel.booktrackerapi.domain.book.models.BookGenre;
import com.daniel.booktrackerapi.domain.exceptions.BookGenreNotFoundException;
import com.daniel.booktrackerapi.domain.exceptions.ResourceNotFoundException;

public interface BookService {

     Book create(Book book);

     Book update(Long id, Book book) throws ResourceNotFoundException;

     Iterable<Book> getAllBooks();

     Iterable<Book> getAllBookByGenre(BookGenre genre)throws BookGenreNotFoundException;

     Book getBookById(Long id) throws ResourceNotFoundException;

}