package entites;

import org.domain.entities.LoanAgreement;
import org.domain.valueObjects.BookId;
import org.domain.valueObjects.LoanAgreementId;
import org.domain.valueObjects.UserId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LoanAgreementUnitTest {

    private LoanAgreement loanAgreement;
    private UserId userId;
    private BookId bookId;
    private Date returnDate;

    @BeforeEach
    public void setUp() {
        userId = new UserId();
        bookId = new BookId();
        returnDate = new Date(System.currentTimeMillis() + 100000); // Return date in the future
        loanAgreement = new LoanAgreement(userId, bookId, returnDate);
    }

    @Test
    public void testGetUserId() {
        assertEquals(userId, loanAgreement.getUserId());
    }

    @Test
    public void testGetBookId() {
        assertEquals(bookId, loanAgreement.getBookId());
    }

    @Test
    public void testGetLoanAgreementIdNotNull() {
        LoanAgreementId loanAgreementId = loanAgreement.getLoanAgreementId();
        assertNotNull(loanAgreementId);
    }

    @Test
    public void testGetReturnDate() {
        assertEquals(returnDate, loanAgreement.getReturnDate());
    }

    @Test
    public void testGetDaysUntilReturnDate() {
        long expectedDays = (returnDate.getTime() - System.currentTimeMillis()) / (1000 * 60 * 60 * 24);
        assertEquals(expectedDays, loanAgreement.getDaysUntilReturnDate());
    }
}

