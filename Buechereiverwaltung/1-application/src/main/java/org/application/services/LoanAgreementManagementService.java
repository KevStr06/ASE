package org.application.services;

import org.domain.entities.Book;
import org.domain.entities.LoanAgreement;
import org.domain.entities.User;
import org.domain.repositories.BookRepository;
import org.domain.repositories.LoanAgreementRepository;
import org.domain.repositories.UserRepository;
import org.domain.services.BookRenter;
import org.domain.valueObjects.BookId;
import org.domain.valueObjects.LoanAgreementId;
import org.domain.valueObjects.UserId;

import java.util.Date;

public class LoanAgreementManagementService {
    private final LoanAgreementRepository loanAgreementRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public LoanAgreementManagementService(LoanAgreementRepository loanAgreementRepository, UserRepository userRepository, BookRepository bookRepository) {
        this.loanAgreementRepository = loanAgreementRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    public LoanAgreementId createLoanAgreement(UserId userId, BookId bookId, Date returnDate) {
        User user = userRepository.findByUserId(userId);
        Book book = bookRepository.findByBookId(bookId);
        LoanAgreement loanAgreement = BookRenter.rentBookToUser(book, user, returnDate);
        loanAgreementRepository.add(loanAgreement);
        return loanAgreement.getLoanAgreementId();
    }

    public void returnBook(LoanAgreementId loanAgreementId, UserId userId, BookId bookId) {
        User user = userRepository.findByUserId(userId);
        Book book = bookRepository.findByBookId(bookId);
        LoanAgreement loanAgreement = loanAgreementRepository.findByLoanAgreementId(loanAgreementId);
        BookRenter.returnBook(loanAgreementId, user, book);
        loanAgreementRepository.remove(loanAgreement);
    }

    public void loadLoanAgreement() {
        loanAgreementRepository.load();
    }

    public void clearAllLoanAgreements() {
        for (LoanAgreement loanAgreement : loanAgreementRepository.listAll()) {
            loanAgreementRepository.remove(loanAgreement);
        }
    }

    public long getDaysUntilReturnDateByLoanAgreementId(LoanAgreementId loanAgreementId) {
        LoanAgreement loanAgreement = loanAgreementRepository.findByLoanAgreementId(loanAgreementId);
        return loanAgreement.getDaysUntilReturnDate();
    }

}
