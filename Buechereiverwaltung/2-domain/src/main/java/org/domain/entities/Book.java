package org.domain.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.domain.valueObjects.BookId;
import org.domain.valueObjects.ISBN;
import org.domain.valueObjects.LoanAgreementId;
import org.domain.valueObjects.Name;

public class Book {
    private final BookId id;
    private final ISBN isbn;
    private final String title;
    @JsonProperty("author")
    private final Name author;
    private LoanAgreementId loanAgreementId;

    public Book(String isbn, String title, Name author) {
        this.id = new BookId();
        this.isbn = new ISBN(isbn);
        this.title = validateTitle(title);
        this.author = author;
    }

    @JsonCreator
    private Book(
            @JsonProperty("id") BookId id,
            @JsonProperty("isbn") ISBN isbn,
            @JsonProperty("title") String title,
            @JsonProperty("author") Name author,
            @JsonProperty("loanAgreementId") LoanAgreementId loanAgreementId
    ) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.loanAgreementId = loanAgreementId;
    }

    private String validateTitle(String title) {
        if (title == null || title.isEmpty()) {
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

    @JsonIgnore
    public String getAuthorFullName() {
        return this.author.getFullName();
    }

    @JsonIgnore
    public String getAuthorSurname() {
        return this.author.getSurname();
    }

    @JsonIgnore
    public String getAuthorName() {
        return this.author.getName();
    }

    public BookId getId() {
        return this.id;
    }

    public LoanAgreementId getLoanAgreementId() {
        return this.loanAgreementId;
    }

    public void registerLoanAgreementId(LoanAgreementId loanAgreementId) {
        this.loanAgreementId = loanAgreementId;
    }

    public void returnBook() {
        this.loanAgreementId = null;
    }
}
