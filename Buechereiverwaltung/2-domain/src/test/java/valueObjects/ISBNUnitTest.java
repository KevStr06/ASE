package valueObjects;

import org.domain.valueObjects.ISBN;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ISBNUnitTest {

    @Test
    public void testGetIsbn() {
        String isbn = "978-3-16-148410-0";
        ISBN isbnObj = new ISBN(isbn);
        assertEquals(isbn, isbnObj.getIsbn());
    }

    @Test
    public void testValidIsbn() {
        String validIsbn = "978-3-16-148410-0";
        assertDoesNotThrow(() -> new ISBN(validIsbn));
    }

    @Test
    public void testInvalidIsbnLength() {
        String invalidIsbn = "978-3-16-148410";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new ISBN(invalidIsbn));
        assertEquals("ISBN length must be 17 and must include four -", exception.getMessage());
    }

    @Test
    public void testInvalidIsbnStructure() {
        String invalidIsbn = "978316148410-0";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new ISBN(invalidIsbn));
        assertEquals("ISBN length must be 17 and must include four -", exception.getMessage());
    }

    @Test
    public void testEqualsAndHashCode() {
        String isbn1 = "978-3-16-148410-0";
        String isbn2 = "978-3-16-148410-0";
        String isbn3 = "978-3-16-148410-1";

        ISBN isbnObj1 = new ISBN(isbn1);
        ISBN isbnObj2 = new ISBN(isbn2);
        ISBN isbnObj3 = new ISBN(isbn3);

        assertTrue(isbnObj1.equals(isbnObj2));
        assertFalse(isbnObj1.equals(isbnObj3));
        assertEquals(isbnObj1.hashCode(), isbnObj2.hashCode());
        assertNotEquals(isbnObj1.hashCode(), isbnObj3.hashCode());
    }

    @Test
    public void testToString() {
        String isbn = "978-3-16-148410-0";
        ISBN isbnObj = new ISBN(isbn);
        String expectedString = "ISBN{isbn='" + isbn + "'}";
        assertEquals(expectedString, isbnObj.toString());
    }
}
