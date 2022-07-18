package com.daniel.booktrackerapi.domain.book.services;

import com.daniel.booktrackerapi.domain.book.models.Book;
import com.daniel.booktrackerapi.domain.book.models.BookGenre;
import com.daniel.booktrackerapi.domain.book.repo.BookRepo;
import com.daniel.booktrackerapi.domain.exceptions.BookGenreNotFoundException;
import com.daniel.booktrackerapi.domain.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    private BookRepo bookRepo;

    @Autowired
    public BookServiceImpl(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public Book create(Book book) {

        return bookRepo.save(book);
    }

    @Override
    public Book update(Long id, Book book) {
        Optional<Book> bookOptional = bookRepo.findById(id);
        if(bookOptional.isEmpty()) {
            throw new ResourceNotFoundException("Book with id "+ id + "does not exist");
        }

        bookOptional.get().setGenre(book.getGenre());
        bookOptional.get().setName(book.getName());
        return bookRepo.save(bookOptional.get());
    }

    @Override
    public Iterable<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    @Override
    public Iterable<Book> getAllBookByGenre(BookGenre genre) {
        List<Book> books = bookRepo.findAllByGenre(genre);
        if(books.size() == 0)
            throw new BookGenreNotFoundException(" no Books with genre "+ genre.name() + " does not exist");
        return books;
    }

    @Override
    public Book getBookById(Long id) throws ResourceNotFoundException {
        Optional<Book> book =  bookRepo.findById(id);
        if(book.isEmpty()) {
            throw new ResourceNotFoundException("Book with id "+ id + "does not exist");
        }
         return book.get();
    }
}
