package entites;

import org.domain.entities.Book;
import org.domain.valueObjects.ISBN;
import org.domain.valueObjects.LoanAgreementId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookUnitTest {

    private Book book;
    private String isbn = "978-3-16-148410-0";
    private String title = "Test Book";
    private String authorName = "John";
    private String authorSurname = "Doe";

    @BeforeEach
    public void setUp() {
        book = new Book(isbn, title, authorName, authorSurname);
    }

    @Test
    public void testGetISBN() {
        assertEquals(new ISBN(isbn), book.getISBN());
    }

    @Test
    public void testGetTitle() {
        assertEquals(title, book.getTitle());
    }

    @Test
    public void testGetAuthorFullName() {
        assertEquals("John Doe", book.getAuthorFullName());
    }

    @Test
    public void testGetAuthorName() {
        assertEquals(authorName, book.getAuthorName());
    }

    @Test
    public void testGetAuthorSurname() {
        assertEquals(authorSurname, book.getAuthorSurname());
    }

    @Test
    public void testGetIdNotNull() {
        assertNotNull(book.getId());
    }

    @Test
    public void testRegisterLoanAgreementId() {
        LoanAgreementId loanAgreementId = new LoanAgreementId();
        book.registerLoanAgreementId(loanAgreementId);
        assertEquals(loanAgreementId, book.getLoanAgreementId());
    }

    @Test
    public void testReturnBook() {
        LoanAgreementId loanAgreementId = new LoanAgreementId();
        book.registerLoanAgreementId(loanAgreementId);
        book.returnBook();
        assertNull(book.getLoanAgreementId());
    }

    @Test
    public void testTitleNotNullOrEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new Book(isbn, null, authorName, authorSurname));
        assertThrows(IllegalArgumentException.class, () -> new Book(isbn, "", authorName, authorSurname));
    }
}
