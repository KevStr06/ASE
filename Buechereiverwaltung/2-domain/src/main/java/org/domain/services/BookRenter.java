package org.domain.services;

import org.domain.entities.Book;
import org.domain.entities.LoanAgreement;
import org.domain.entities.User;
import org.domain.valueObjects.LoanAgreementId;

import java.util.Date;

public class BookRenter {

    public static LoanAgreement rentBookToUser(Book book, User user, Date returnDate) {
        if (book.getLoanAgreementId() != null) {
            throw new IllegalArgumentException("Book is already rent");
        }
        LoanAgreement loanAgreement = new LoanAgreement(user.getId(), book.getId(), returnDate);
        user.registerLoanAgreementId(loanAgreement.getLoanAgreementId());
        book.registerLoanAgreementId(loanAgreement.getLoanAgreementId());
        return loanAgreement;
    }

    public static void returnBook(LoanAgreementId loanAgreementId, User user, Book book) {
        if (book.getLoanAgreementId() == null || !book.getLoanAgreementId().equals(loanAgreementId)) {
            throw new IllegalArgumentException("Not the right book");
        }
        book.returnBook();
        user.registerLoanAgreementId(loanAgreementId);
    }
}
