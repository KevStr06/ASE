package valueObjects;

import org.domain.valueObjects.LoanAgreementId;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoanAgreementIdUnitTest {

    @Test
    public void testGetId() {
        LoanAgreementId loanAgreementId = new LoanAgreementId();
        assertNotNull(loanAgreementId.getId());
    }

    @Test
    public void testEqualsAndHashCode() {
        LoanAgreementId loanAgreementId1 = new LoanAgreementId();
        LoanAgreementId loanAgreementId2 = new LoanAgreementId();
        LoanAgreementId loanAgreementId3 = new LoanAgreementId();

        // Reflexive property
        assertTrue(loanAgreementId1.equals(loanAgreementId1));
        assertTrue(loanAgreementId2.equals(loanAgreementId2));
        assertTrue(loanAgreementId3.equals(loanAgreementId3));

        // Symmetric property
        assertEquals(loanAgreementId1.equals(loanAgreementId2), loanAgreementId2.equals(loanAgreementId1));

        // Transitive property
        if (loanAgreementId1.equals(loanAgreementId2) && loanAgreementId2.equals(loanAgreementId3)) {
            assertTrue(loanAgreementId1.equals(loanAgreementId3));
        }

        // Consistency property
        assertTrue(loanAgreementId1.equals(loanAgreementId1));
        assertTrue(loanAgreementId1.hashCode() == loanAgreementId1.hashCode());

        // Non-nullity property
        assertFalse(loanAgreementId1.equals(null));

        // Unequal objects
        assertFalse(loanAgreementId1.equals(new Object()));

        // Hash code consistency with equals
        assertTrue(loanAgreementId1.equals(loanAgreementId2) == (loanAgreementId1.hashCode() == loanAgreementId2.hashCode()));
    }

    @Test
    public void testToString() {
        LoanAgreementId loanAgreementId = new LoanAgreementId();
        String expectedString = "LoanAgreementId{id=" + loanAgreementId.getId() + "}";
        assertEquals(expectedString, loanAgreementId.toString());
    }
}
