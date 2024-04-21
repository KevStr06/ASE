package org.persistence;

import org.domain.entities.Book;
import org.domain.repositories.BookRepository;
import org.domain.valueObjects.BookId;

import java.util.ArrayList;
import java.util.List;


public class BookJacksonJsonRepository implements BookRepository {

    private final List<Book> books = new ArrayList<>();
    @Override
    public List<Book> listAll() {
        return new ArrayList<>(books);
    }

    @Override
    public Book findByBookId(BookId bookId) {
        return books.stream()
                .filter(book -> book.getId().equals(bookId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Book> findByAuthor(String authorName, String authorSurname) {
        return books.stream()
                .filter(book -> book.getAuthorFullName().equals(authorName+" "+authorSurname))
                .toList();
    }

    @Override
    public void save(Book book) {

    }

    @Override
    public void remove(Book book) {
        books.remove(book);
    }

    @Override
    public void add(Book book) {
        books.add(book);
    }

    @Override
    public void load() {

    }
}
