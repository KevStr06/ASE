package org.domain.entities;

import org.domain.valueObjects.LoanAgreementId;
import org.domain.valueObjects.Name;
import org.domain.valueObjects.UserId;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private final UserId id;
    private final Name name;
    private List<LoanAgreementId> loanAgreementIdList;

    public User(String name, String surname) {
        this.id = new UserId();
        this.name = new Name(name, surname);
        this.loanAgreementIdList = new ArrayList<>();
    }

    public String getName() {
        return name.getName();
    }
    public String getSurname() {
        return name.getSurname();
    }
    public String getFullName() {
        return name.getFullName();
    }
    public UserId getId() {
        return id;
    }
    public List<LoanAgreementId> getLoanAgreementIdList() {
        List<LoanAgreementId> loanAgreementIdList = new ArrayList<>(this.loanAgreementIdList);
        return loanAgreementIdList;
    }
    public void registerLoanAgreementId(LoanAgreementId loanAgreementId) {
        this.loanAgreementIdList.add(loanAgreementId);
    }
    public void returnBookByLoanAgreementId(LoanAgreementId loanAgreementId) {
        if (!this.loanAgreementIdList.contains(loanAgreementId)) {
            throw new IllegalArgumentException("User has no Loan Agreement with the Id " + loanAgreementId.getId());
        }
        this.loanAgreementIdList.remove(loanAgreementId);
    }

}
