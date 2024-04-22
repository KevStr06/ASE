package entites;

import org.domain.entities.Bookmark;
import org.domain.valueObjects.BookId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BookmarkUnitTest {

    private Bookmark bookmark;

    @BeforeEach
    public void setUp() {
        bookmark = new Bookmark();
    }

    @Test
    public void testRegisterBookmark() {
        BookId bookId = new BookId();
        bookmark.registerBookmark(bookId);
        List<BookId> bookmarks = bookmark.getBookmarks();
        assertTrue(bookmarks.contains(bookId));
    }

    @Test
    public void testRemoveBookmark() {
        BookId bookId = new BookId();
        bookmark.registerBookmark(bookId);
        bookmark.removeBookmark(bookId);
        List<BookId> bookmarks = bookmark.getBookmarks();
        assertFalse(bookmarks.contains(bookId));
    }

    @Test
    public void testGetBookmarks() {
        BookId bookId1 = new BookId();
        BookId bookId2 = new BookId();
        bookmark.registerBookmark(bookId1);
        bookmark.registerBookmark(bookId2);
        List<BookId> bookmarks = bookmark.getBookmarks();
        assertTrue(bookmarks.contains(bookId1));
        assertTrue(bookmarks.contains(bookId2));
    }

    @Test
    public void testGetBookmarksReturnsCopy() {
        BookId bookId = new BookId();
        bookmark.registerBookmark(bookId);
        List<BookId> bookmarks1 = bookmark.getBookmarks();
        bookmarks1.clear();
        List<BookId> bookmarks2 = bookmark.getBookmarks();
        assertTrue(bookmarks2.contains(bookId));
    }
}
