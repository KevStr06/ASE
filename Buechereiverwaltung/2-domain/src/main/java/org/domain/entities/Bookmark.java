package org.domain.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.domain.valueObjects.BookId;

import java.util.ArrayList;
import java.util.List;

public class Bookmark {
    private List<BookId> bookmarks;

    public Bookmark() {
        bookmarks = new ArrayList<>();
    }

    @JsonCreator
    private Bookmark(
            @JsonProperty("bookmarks") List<BookId> bookmarks
    ) {
        this.bookmarks = new ArrayList<>(bookmarks);
    }

    public void registerBookmark(BookId bookmark) {

        if (bookmarks == null) {
            throw new IllegalArgumentException("Bookmarks cannot be null");
        }
        this.bookmarks.add(bookmark);
    }

    public void removeBookmark(BookId bookmark) {
        if (bookmarks == null) {
            throw new IllegalArgumentException("Bookmarks cannot be null");
        }
        this.bookmarks.remove(bookmark);
    }

    public List<BookId> getBookmarks() {
        List<BookId> bookmarks = new ArrayList<>(this.bookmarks);
        return bookmarks;
    }
}
