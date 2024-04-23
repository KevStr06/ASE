package org.domain.valueObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class ISBN {
    private String isbn;

    @JsonCreator
    public ISBN(
            @JsonProperty ("isbn") String isbn) {
        this.isbn = validateIsbn(isbn);
    }

    private String validateIsbn(String isbn) {
        if (isbn.length() != 17 || !isValidISBNStructure(isbn)) {
            throw new IllegalArgumentException("ISBN length must be 17 and must include four -");
        }
        return isbn;
    }
    private boolean isValidISBNStructure(String isbn) {
        int count = 0;
        for (int i = 0; i < isbn.length(); i++) {
            if (isbn.charAt(i) == '-') {
                count++;
            }
        }
        if (count == 4) return true;
        return false;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ISBN isbn1 = (ISBN) o;
        return Objects.equals(isbn, isbn1.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(isbn);
    }

    @Override
    public String toString() {
        return "ISBN{" +
                "isbn='" + isbn + '\'' +
                '}';
    }
}

