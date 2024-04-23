package org.domain.repositories;

import org.domain.entities.Book;
import org.domain.valueObjects.BookId;

import java.util.List;

public interface BookRepository {
    List<Book> listAll();
    Book findByBookId(BookId bookId);
    List<Book> findByAuthor(String authorName, String authorSurname);
    void save();
    void remove(Book book);
    void add (Book book);
    void load ();
}
