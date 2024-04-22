package valueObjects;

import org.domain.valueObjects.ReturnDate;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class ReturnDateUnitTest {

    @Test
    public void testGetReturnDate() {
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DAY_OF_MONTH, 7);
        Date returnDate = calendar.getTime();

        ReturnDate returnDateObj = new ReturnDate(returnDate);
        assertEquals(returnDate, returnDateObj.getReturnDate());
    }

    @Test
    public void testGetDaysUntilReturnDate() {
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DAY_OF_MONTH, 7);
        Date returnDate = calendar.getTime();

        ReturnDate returnDateObj = new ReturnDate(returnDate);
        long expectedDays = 7;
        assertEquals(expectedDays, returnDateObj.getDaysUntilReturnDate());
    }

    @Test
    public void testValidateDate() {
        Date pastDate = new Date(System.currentTimeMillis() - 100000); // past date
        assertThrows(IllegalArgumentException.class, () -> new ReturnDate(pastDate));
    }

    @Test
    public void testEqualsAndHashCode() {
        Date currentDate = new Date();
        ReturnDate returnDate1 = new ReturnDate(currentDate);
        ReturnDate returnDate2 = new ReturnDate(currentDate);

        assertTrue(returnDate1.equals(returnDate2));
        assertEquals(returnDate1.hashCode(), returnDate2.hashCode());
    }

    @Test
    public void testToString() {
        Date currentDate = new Date();
        ReturnDate returnDate = new ReturnDate(currentDate);
        String expectedString = "ReturnDate{returnDate=" + currentDate + '}';
        assertEquals(expectedString, returnDate.toString());
    }
}
