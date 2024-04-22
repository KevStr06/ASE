package valueObjects;

import org.domain.valueObjects.Name;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NameUnitTest {

    @Test
    public void testGetName() {
        String name = "John";
        String surname = "Doe";
        Name nameObj = new Name(name, surname);
        assertEquals(name, nameObj.getName());
    }

    @Test
    public void testGetSurname() {
        String name = "John";
        String surname = "Doe";
        Name nameObj = new Name(name, surname);
        assertEquals(surname, nameObj.getSurname());
    }

    @Test
    public void testGetFullName() {
        String name = "John";
        String surname = "Doe";
        Name nameObj = new Name(name, surname);
        assertEquals("John Doe", nameObj.getFullName());
    }

    @Test
    public void testValidateName() {
        assertThrows(IllegalArgumentException.class, () -> new Name(null, "Doe"));
        assertThrows(IllegalArgumentException.class, () -> new Name("", "Doe"));
        assertThrows(IllegalArgumentException.class, () -> new Name("John", null));
        assertThrows(IllegalArgumentException.class, () -> new Name("John", ""));
    }

    @Test
    public void testToString() {
        String name = "John";
        String surname = "Doe";
        Name nameObj = new Name(name, surname);
        assertEquals("John Doe", nameObj.toString());
    }

    @Test
    public void testEquals() {
        Name name1 = new Name("John", "Doe");
        Name name2 = new Name("John", "Doe");
        Name name3 = new Name("Jane", "Doe");

        assertTrue(name1.equals(name2));
        assertFalse(name1.equals(name3));
    }
}
