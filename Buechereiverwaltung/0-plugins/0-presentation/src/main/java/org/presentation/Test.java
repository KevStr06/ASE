package org.presentation;

import org.application.services.BookManagementService;
import org.application.services.LoanAgreementManagementService;
import org.application.services.UserManagementService;
import org.domain.entities.Book;
import org.domain.entities.LoanAgreement;
import org.domain.entities.User;
import org.domain.repositories.BookRepository;
import org.domain.valueObjects.BookId;
import org.domain.valueObjects.LoanAgreementId;
import org.domain.valueObjects.UserId;
import org.persistence.BookJacksonJsonRepository;
import org.persistence.LoanAgreementJacksonRepository;
import org.persistence.UserJacksonJsonRepository;

import java.util.Calendar;
import java.util.Date;


public class Test {
    public static void main(String[] args) {
        BookJacksonJsonRepository bookJacksonJsonRepository = new BookJacksonJsonRepository();
        LoanAgreementJacksonRepository loanAgreementJacksonRepository = new LoanAgreementJacksonRepository();
        UserJacksonJsonRepository userJacksonJsonRepository = new UserJacksonJsonRepository();
        BookManagementService bookManagementService = new BookManagementService(bookJacksonJsonRepository);
        UserManagementService userManagementService = new UserManagementService(userJacksonJsonRepository);
        LoanAgreementManagementService loanAgreementManagementService = new LoanAgreementManagementService(loanAgreementJacksonRepository,userJacksonJsonRepository,bookJacksonJsonRepository);
        UserId userId1 = userManagementService.createUser("Tim","Lol");
        UserId userId2 = userManagementService.createUser("Daniel","Von");
        BookId bookId1 = bookManagementService.createBook("978-3-7375-0553-6","Test","Kevin","Ich");
        BookId bookId2 = bookManagementService.createBook("978-3-7375-0553-8", "Testen","Simon","Lapp");
        BookId bookId3 = bookManagementService.createBook("978-3-7375-0553-9", "Schreiben","Simon","Lapp");

        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.MAY, 17);
        Date dateToCheck = calendar.getTime();
        LoanAgreementId loanAgreementId1 = loanAgreementManagementService.createLoanAgreement(userId1,bookId1,dateToCheck);
        LoanAgreementId loanAgreementId2 = loanAgreementManagementService.createLoanAgreement(userId1,bookId2,dateToCheck);
        loanAgreementManagementService.returnBook(loanAgreementId2, userId1, bookId2);
        LoanAgreementId loanAgreementId3 = loanAgreementManagementService.createLoanAgreement(userId2,bookId2,dateToCheck);



    }
}