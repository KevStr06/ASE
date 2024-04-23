package org.domain.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.domain.valueObjects.BookId;
import org.domain.valueObjects.LoanAgreementId;
import org.domain.valueObjects.ReturnDate;
import org.domain.valueObjects.UserId;

import java.util.Date;

public class LoanAgreement {
    private final LoanAgreementId loanAgreementId;
    @JsonProperty ("loanAgreementReturnDate")
    private final ReturnDate loanAgreementReturnDate;
    private final UserId userId;
    private final BookId bookId;


    public LoanAgreement(UserId userId, BookId bookId, Date loanAgreementReturnDate) {
        this.userId = userId;
        this.bookId = bookId;
        this.loanAgreementId = new LoanAgreementId();
        this.loanAgreementReturnDate = new ReturnDate(loanAgreementReturnDate);
    }

    @JsonCreator
    private LoanAgreement(
            @JsonProperty ("userId") UserId userId,
            @JsonProperty ("bookId") BookId bookId,
            @JsonProperty ("loanAgreementReturnDate") ReturnDate loanAgreementReturnDate,
            @JsonProperty ("loanAgreementId") LoanAgreementId loanAgreementId
    ){
        this.userId = userId;
        this.bookId = bookId;
        this.loanAgreementId = loanAgreementId;
        this.loanAgreementReturnDate = loanAgreementReturnDate;
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
    @JsonIgnore
    public Date getReturnDate() {
        return loanAgreementReturnDate.getReturnDate();
    }

    @JsonIgnore
    public long getDaysUntilReturnDate() {
        return loanAgreementReturnDate.getDaysUntilReturnDate();
    }
}
