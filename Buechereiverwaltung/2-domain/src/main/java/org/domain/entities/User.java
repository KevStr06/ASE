package org.domain.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.domain.valueObjects.*;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final UserId id;
    @JsonProperty("userName")
    private final Name userName;
    private List<LoanAgreementId> loanAgreementIdList;
    @JsonProperty("bookmark")
    private Bookmark bookmark;
    private final Email email;
    private final ContactMethodStrategy contactMethodStrategy;

    public User(String name, String surname, Email email) {
        this.id = new UserId();
        this.userName = new Name(name, surname);
        this.loanAgreementIdList = new ArrayList<>();
        this.bookmark = new Bookmark();
        this.email = email;
        this.contactMethodStrategy = new EmailContactStrategy(email);
    }

    @JsonCreator
    private User(
            @JsonProperty("id") UserId id,
            @JsonProperty("userName") Name name,
            @JsonProperty("email") Email email,
            @JsonProperty("contactMethodStrategy") ContactMethodStrategy contactMethodStrategy,
            @JsonProperty("loanAgreementIdList") List<LoanAgreementId> loanAgreementIdList,
            @JsonProperty("bookmark") Bookmark bookmark) {
        this.id = id;
        this.userName = name;
        this.loanAgreementIdList = loanAgreementIdList;
        this.bookmark = bookmark;
        this.email = email;
        this.contactMethodStrategy = contactMethodStrategy;
    }

    @JsonIgnore
    public String getName() {
        return userName.getName();
    }

    @JsonIgnore
    public String getSurname() {
        return userName.getSurname();
    }

    @JsonIgnore
    public String getFullName() {
        return userName.getFullName();
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

    @JsonIgnore
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
