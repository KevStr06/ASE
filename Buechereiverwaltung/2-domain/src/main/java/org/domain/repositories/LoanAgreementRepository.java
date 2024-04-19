package org.domain.repositories;

import org.domain.entities.LoanAgreement;
import org.domain.valueObjects.BookId;
import org.domain.valueObjects.LoanAgreementId;
import org.domain.valueObjects.UserId;

import java.util.List;

public interface LoanAgreementRepository {
    List<LoanAgreement> listAll();
    LoanAgreement findByLoanAgreementId(LoanAgreementId loanAgreementId);
    List<LoanAgreement> findByUserId (UserId userId);
    List<LoanAgreement> findByBookId (BookId bookId);
    void save(LoanAgreement loanAgreement);
    void remove(LoanAgreement loanAgreement);
    void add (LoanAgreement loanAgreement);
    void load ();
}
