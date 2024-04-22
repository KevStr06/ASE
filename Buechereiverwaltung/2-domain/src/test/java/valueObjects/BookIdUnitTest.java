package valueObjects;

import org.domain.valueObjects.BookId;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookIdUnitTest {

    @Test
    public void testGetId() {
        BookId bookId = new BookId();
        assertNotNull(bookId.getId());
    }

    @Test
    public void testEqualsAndHashCode() {
        BookId bookId1 = new BookId();
        BookId bookId2 = new BookId();
        BookId bookId3 = new BookId();

        // Reflexive property
        assertTrue(bookId1.equals(bookId1));
        assertTrue(bookId2.equals(bookId2));
        assertTrue(bookId3.equals(bookId3));

        // Symmetric property
        assertEquals(bookId1.equals(bookId2), bookId2.equals(bookId1));

        // Transitive property
        if (bookId1.equals(bookId2) && bookId2.equals(bookId3)) {
            assertTrue(bookId1.equals(bookId3));
        }

        // Consistency property
        assertTrue(bookId1.equals(bookId1));
        assertTrue(bookId1.hashCode() == bookId1.hashCode());

        // Non-nullity property
        assertFalse(bookId1.equals(null));

        // Unequal objects
        assertFalse(bookId1.equals(new Object()));

        // Hash code consistency with equals
        assertTrue(bookId1.equals(bookId2) == (bookId1.hashCode() == bookId2.hashCode()));
    }

    @Test
    public void testToString() {
        BookId bookId = new BookId();
        String expectedString = "BookId{id=" + bookId.getId() + "}";
        assertEquals(expectedString, bookId.toString());
    }
}
