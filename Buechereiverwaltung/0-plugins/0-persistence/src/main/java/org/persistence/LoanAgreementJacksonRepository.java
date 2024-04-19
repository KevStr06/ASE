package org.persistence;

import org.domain.entities.LoanAgreement;
import org.domain.entities.User;
import org.domain.repositories.LoanAgreementRepository;
import org.domain.valueObjects.BookId;
import org.domain.valueObjects.LoanAgreementId;
import org.domain.valueObjects.UserId;

import java.util.ArrayList;
import java.util.List;

public class LoanAgreementJacksonRepository implements LoanAgreementRepository {

    private final List<LoanAgreement> loanAgreements = new ArrayList<LoanAgreement>();
    @Override
    public List<LoanAgreement> listAll() {
        return new ArrayList<>(loanAgreements);
    }

    @Override
    public LoanAgreement findByLoanAgreementId(LoanAgreementId loanAgreementId) {
        return loanAgreements.stream()
                .filter(loanAgreement -> loanAgreement.getLoanAgreementId().equals(loanAgreementId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<LoanAgreement> findByUserId(UserId userId) {
        return loanAgreements.stream()
                .filter(loanAgreement -> loanAgreement.getUserId().equals(userId))
                .toList();
    }

    @Override
    public List<LoanAgreement> findByBookId(BookId bookId) {
        return loanAgreements.stream()
                .filter(loanAgreement -> loanAgreement.getBookId().equals(bookId))
                .toList();
    }

    @Override
    public void save(LoanAgreement loanAgreement) {

    }

    @Override
    public void remove(LoanAgreement loanAgreement) {
        loanAgreements.remove(loanAgreement);
    }

    @Override
    public void add(LoanAgreement loanAgreement) {
        loanAgreements.add(loanAgreement);
    }

    @Override
    public void load() {

    }
}
