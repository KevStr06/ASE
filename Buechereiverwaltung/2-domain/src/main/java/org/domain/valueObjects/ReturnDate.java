package org.domain.valueObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class ReturnDate {
    private final Date returnDate;

    public ReturnDate(Date returnDate) {
        this.returnDate = validateDate(returnDate);
    }

    ;

    private ReturnDate(Date returnDate, boolean workaround) {
        this.returnDate = returnDate;
    }

    @JsonCreator
    private static ReturnDate createInstance(
            @JsonProperty("returnDate") Date returnDate
    ) {
        //Factory method to force a different constructor signature (workaround)
        ReturnDate temp = new ReturnDate(returnDate, true);
        return temp;
    }

    private Date validateDate(Date returnDate) {
        Date currentDate = new Date();
        if (returnDate.before(currentDate)) {
            throw new IllegalArgumentException("Return date must be in the future");
        }
        return returnDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    @JsonIgnore
    public long getDaysUntilReturnDate() {
        Date currentDate = new Date();
        long diffInMillies = returnDate.getTime() - currentDate.getTime();
        return TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReturnDate that = (ReturnDate) o;
        return Objects.equals(returnDate, that.returnDate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(returnDate);
    }

    @Override
    public String toString() {
        return "ReturnDate{" +
                "returnDate=" + returnDate +
                '}';
    }
}
