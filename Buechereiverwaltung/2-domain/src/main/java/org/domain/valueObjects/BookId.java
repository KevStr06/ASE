package org.domain.valueObjects;

import java.util.Objects;
import java.util.UUID;

public class BookId {
    private final UUID id;

    public BookId() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookId bookId = (BookId) o;
        return Objects.equals(id, bookId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "BookId{" +
                "id=" + id +
                '}';
    }
}
