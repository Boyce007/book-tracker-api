package com.daniel.booktrackerapi.book;

import com.daniel.booktrackerapi.domain.book.models.Book;
import com.daniel.booktrackerapi.domain.book.models.BookGenre;
import com.daniel.booktrackerapi.domain.book.repo.BookRepo;
import com.daniel.booktrackerapi.domain.book.services.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class BookServiceTest {
        @Autowired
        private BookService bookService;

        @MockBean
        private BookRepo bookRepo;

        private Book mockBook;
        private Book testBook01;
        private Book testBook02;

        @BeforeEach
        public void setUp() {
            mockBook = new Book("Mock Book", BookGenre.ACTION);

            testBook01 = mockBook;
            testBook02 = mockBook;
        }


        @Test
        @DisplayName("Create Book Test")
        public void createTest01() {
            BDDMockito.doReturn(mockBook).when(bookRepo).save(mockBook);
            Book createdBook = bookService.create(mockBook);

            Assertions.assertEquals(createdBook,mockBook);

        }



}
