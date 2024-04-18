package org.domain.entities;

import org.domain.valueObjects.BookId;
import org.domain.valueObjects.ISBN;
import org.domain.valueObjects.Name;

public class Book {
    private final BookId id;
    private final ISBN isbn;
    private final String title;
    private final Name author;

    public Book(String isbn, String title, String authorName, String authorSurname) {
        this.id = new BookId();
        this.isbn = new ISBN(isbn);
        this.title = title;
        this.author = new Name(authorName, authorSurname);
    }

    private String validateTitle(String title){
        if(title == null || title.isEmpty()){
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        title = title.trim();
        return title;
    }

    public ISBN getISBN() {
        return this.isbn;
    }
    public String getTitle() {
        return this.title;
    }
    public String getAuthorFullName() {
        return this.author.getFullName();
    }
    public String getAuthorSurname() {
        return this.author.getSurname();
    }
    public String getAuthorName(){
        return this.author.getName();
    }
    public BookId getId() {
        return this.id;
    }
}
