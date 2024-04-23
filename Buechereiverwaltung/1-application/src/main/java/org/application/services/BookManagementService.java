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

    public List<BookId> getAllBookIds() {
        List<BookId> bookIds = new ArrayList<>();
        for (Book book : bookRepository.listAll()) {
            bookIds.add(book.getId());
        }
        return bookIds;
    }

    public String getBookTitleById(BookId bookId) {
        Book book = bookRepository.findByBookId(bookId);
        return book.getTitle();
    }

    public String getBookAuthorsNameById(BookId bookId) {
        Book book = bookRepository.findByBookId(bookId);
        return book.getAuthorName();
    }

    public String getBookAuthorsSurnameById(BookId bookId) {
        Book book = bookRepository.findByBookId(bookId);
        return book.getAuthorSurname();
    }

    public String getBookAuthorsFullNameById(BookId bookId) {
        Book book = bookRepository.findByBookId(bookId);
        return book.getAuthorFullName();
    }

    public List<BookId> getBookIdsByAuthorName(String authorName, String authorSurname) {
        List<BookId> bookIds = new ArrayList<>();
        for (Book book : bookRepository.findByAuthor(authorName, authorSurname)) {
            bookIds.add(book.getId());
        }
        return bookIds;
    }

    public void saveBooks() {
        bookRepository.save();
    }

}
