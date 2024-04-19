package org.application.services;

import org.domain.entities.Book;
import org.domain.repositories.BookRepository;
import org.domain.valueObjects.BookId;

import java.util.ArrayList;
import java.util.List;

public class BookManagementService {
    private final BookRepository bookRepository;

    public BookManagementService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookId createBook(String isbn, String title, String authorName, String authorSurname) {
        Book book = new Book(isbn, title, authorName, authorSurname);
        bookRepository.add(book);
        return book.getId();
    }

    public void loadBooks() {
        bookRepository.load();
    }

    public void clearAllBooks() {
        for (Book book : bookRepository.listAll()) {
            bookRepository.remove(book);
        }
    }

    public List<Book> getAllBooks() {
        return new ArrayList<Book>(bookRepository.listAll());
    }
}
