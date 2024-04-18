package org.domain.repositories;

import org.domain.entities.Book;
import org.domain.valueObjects.BookId;

import java.util.List;

public interface BookRepository {
    List<Book> listAll();
    Book findByBookId(BookId bookId);
    void save(Book book);
    void remove(Book book);
    void add (Book book);
    void load ();
}
