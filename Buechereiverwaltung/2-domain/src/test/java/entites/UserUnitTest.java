package entites;

import org.domain.entities.User;
import org.domain.valueObjects.BookId;
import org.domain.valueObjects.Email;
import org.domain.valueObjects.LoanAgreementId;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserUnitTest {

    private User user;

    @Test
    public void testGetName() {
        user = new User("John", "Doe", new Email("john@doemail.com"));
        assertEquals("John", user.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidEmail() {
        user = new User("John", "Doe", new Email("john@doemail"));
    }

    @Test
    public void testGetSurname() {
        user = new User("John", "Doe", new Email("john@doemail.com"));
        assertEquals("Doe", user.getSurname());
    }

    @Test
    public void testGetFullName() {
        user = new User("John", "Doe", new Email("john@doemail.com"));
        assertEquals("John Doe", user.getFullName());
    }

    @Test
    public void testGetIdNotNull() {
        user = new User("John", "Doe", new Email("john@doemail.com"));
        assertNotNull(user.getId());
    }

    @Test
    public void testRegisterLoanAgreementId() {
        user = new User("John", "Doe", new Email("john@doemail.com"));
        LoanAgreementId loanAgreementId = new LoanAgreementId();
        user.registerLoanAgreementId(loanAgreementId);
        List<LoanAgreementId> loanAgreementIdList = user.getLoanAgreementIdList();
        assertTrue(loanAgreementIdList.contains(loanAgreementId));
    }

    @Test
    public void testReturnBookByLoanAgreementId() {
        user = new User("John", "Doe", new Email("john@doemail.com"));
        LoanAgreementId loanAgreementId = new LoanAgreementId();
        user.registerLoanAgreementId(loanAgreementId);
        user.returnBookByLoanAgreementId(loanAgreementId);
        List<LoanAgreementId> loanAgreementIdList = user.getLoanAgreementIdList();
        assertFalse(loanAgreementIdList.contains(loanAgreementId));
    }

    @Test
    public void testRegisterBookmark() {
        user = new User("John", "Doe", new Email("john@doemail.com"));
        BookId bookId = new BookId();
        user.registerBookmark(bookId);
        List<BookId> bookmarks = user.getBookmarks();
        assertTrue(bookmarks.contains(bookId));
    }

    @Test
    public void testRemoveBookmark() {
        user = new User("John", "Doe", new Email("john@doemail.com"));
        BookId bookId = new BookId();
        user.registerBookmark(bookId);
        user.removeBookmark(bookId);
        List<BookId> bookmarks = user.getBookmarks();
        assertFalse(bookmarks.contains(bookId));
    }

    @Test
    public void testGetBookmarks() {
        user = new User("John", "Doe", new Email("john@doemail.com"));
        BookId bookId1 = new BookId();
        BookId bookId2 = new BookId();
        user.registerBookmark(bookId1);
        user.registerBookmark(bookId2);
        List<BookId> bookmarks = user.getBookmarks();
        assertTrue(bookmarks.contains(bookId1));
        assertTrue(bookmarks.contains(bookId2));
    }
}
