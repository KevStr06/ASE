package org.domain.entities;

import org.domain.valueObjects.BookId;
import org.domain.valueObjects.LoanAgreementId;
import org.domain.valueObjects.ReturnDate;
import org.domain.valueObjects.UserId;

import java.util.Date;
import java.util.UUID;

public class LoanAgreement {
    private final LoanAgreementId loanAgreementId;
    private final ReturnDate returnDate;
    private final UserId userId;
    private final BookId bookId;

    public LoanAgreement(UserId userId, BookId bookIdq, Date returnDate) {
        this.userId = userId;
        this.bookId = bookIdq;
        this.loanAgreementId = new LoanAgreementId();
        this.returnDate = new ReturnDate(returnDate);
    }

    public UserId getUserId() {
        return userId;
    }

    public BookId getBookId() {
        return bookId;
    }

    public LoanAgreementId getLoanAgreementId() {
        return loanAgreementId;
    }

    public Date getReturnDate() {
        return returnDate.getReturnDate();
    }

    public long getDaysUntilReturnDate() {
        return returnDate.getDaysUntilReturnDate();
    }
}
