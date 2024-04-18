package org.domain.valueObjects;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ReturnDate {
    private final Date returnDate;

    public ReturnDate(Date returnDate) {
        this.returnDate = validateDate(returnDate);
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

    public long getDaysUntilReturnDate() {
        Date currentDate = new Date();
        long diffInMillies = returnDate.getTime() - currentDate.getTime();
        return TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }
}
