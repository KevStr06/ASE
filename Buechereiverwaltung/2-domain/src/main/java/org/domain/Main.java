package org.domain;

import org.domain.entities.Book;
import org.domain.entities.LoanAgreement;
import org.domain.entities.User;
import org.domain.valueObjects.ReturnDate;
import java.util.Calendar;
import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        User user = new User("John", "Doe");
        Book book = new Book("978-3-7375-0553-6", "Test", "Tim", "Timson");

        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.MAY, 17);
        Date dateToCheck = calendar.getTime();
        LoanAgreement loanAgreement = new LoanAgreement(user.getId(), book.getId(), dateToCheck);

        System.out.println(loanAgreement.getReturnDate());
        System.out.println(loanAgreement.getDaysUntilReturnDate());
    }
}