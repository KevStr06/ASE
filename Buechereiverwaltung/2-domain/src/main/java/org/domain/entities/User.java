package org.domain.entities;

import org.domain.valueObjects.BookId;
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
    private Bookmark bookmark;

    public User(String name, String surname) {
        this.id = new UserId();
        this.name = new Name(name, surname);
        this.loanAgreementIdList = new ArrayList<>();
        this.bookmark = new Bookmark();
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


    public void registerBookmark(BookId bookId) {
        bookmark.registerBookmark(bookId);
    }

    public void removeBookmark(BookId bookId) {
        bookmark.removeBookmark(bookId);
    }

    public List<BookId> getBookmarks() {
        List<BookId> bookmarks = bookmark.getBookmarks();
        return bookmarks;
    }

    public void returnBookByLoanAgreementId(LoanAgreementId loanAgreementId) {
        if (!this.loanAgreementIdList.contains(loanAgreementId)) {
            throw new IllegalArgumentException("User has no Loan Agreement with the Id " + loanAgreementId.getId());
        }
        this.loanAgreementIdList.remove(loanAgreementId);
    }

}
