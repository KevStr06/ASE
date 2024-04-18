package org.domain.repositories;

import org.domain.entities.LoanAgreement;
import org.domain.entities.User;
import org.domain.valueObjects.BookId;
import org.domain.valueObjects.LoanAgreementId;

import java.util.List;

public interface LoanAgreementRepository {
    List<LoanAgreement> listAll();
    LoanAgreement findByLoanAgreementId(LoanAgreementId loanAgreementId);
    List<LoanAgreement> findByUserId (User user);
    List<LoanAgreement> findByBookId (BookId bookId);
    void save(LoanAgreement loanAgreement);
    void remove(LoanAgreement loanAgreement);
    void add (LoanAgreement loanAgreement);
    void load ();
}
