package valueObjects;

import org.domain.valueObjects.UserId;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserIdUnitTest {

    @Test
    public void testGetId() {
        UserId userId = new UserId();
        assertNotNull(userId.getId());
    }

    @Test
    public void testEqualsAndHashCode() {
        UserId userId1 = new UserId();
        UserId userId2 = new UserId();
        UserId userId3 = new UserId();

        // Reflexive property
        assertTrue(userId1.equals(userId1));
        assertTrue(userId2.equals(userId2));
        assertTrue(userId3.equals(userId3));

        // Symmetric property
        assertEquals(userId1.equals(userId2), userId2.equals(userId1));

        // Transitive property
        if (userId1.equals(userId2) && userId2.equals(userId3)) {
            assertTrue(userId1.equals(userId3));
        }

        // Consistency property
        assertTrue(userId1.equals(userId1));
        assertTrue(userId1.hashCode() == userId1.hashCode());

        // Non-nullity property
        assertFalse(userId1.equals(null));

        // Unequal objects
        assertFalse(userId1.equals(new Object()));

        // Hash code consistency with equals
        assertTrue(userId1.equals(userId2) == (userId1.hashCode() == userId2.hashCode()));
    }

    @Test
    public void testToString() {
        UserId userId = new UserId();
        String expectedString = "UserId{id=" + userId.getId() + "}";
        assertEquals(expectedString, userId.toString());
    }
}
