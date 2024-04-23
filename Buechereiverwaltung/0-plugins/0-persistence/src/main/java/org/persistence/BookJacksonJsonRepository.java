package org.persistence;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.domain.entities.Book;
import org.domain.repositories.BookRepository;
import org.domain.valueObjects.BookId;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    public void save() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        try (var writer = new FileWriter("books.save", true)) {
            String jsonString = mapper.writeValueAsString(books);

            writer.write(jsonString);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        try (var reader = new FileReader("books.save")) {
            List<Book> loadedBooks = mapper.readValue(reader, new TypeReference<List<Book>>() {});
            books.clear();
            books.addAll(loadedBooks);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
