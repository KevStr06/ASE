package org.presentation;

import org.application.services.BookManagementService;
import org.application.services.LoanAgreementManagementService;
import org.application.services.UserManagementService;
import org.domain.valueObjects.BookId;
import org.domain.valueObjects.LoanAgreementId;
import org.domain.valueObjects.UserId;
import org.persistence.BookJacksonJsonRepository;
import org.persistence.LoanAgreementJacksonRepository;
import org.persistence.UserJacksonJsonRepository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class Test {
    public static void main(String[] args) {

        BookJacksonJsonRepository bookJacksonJsonRepository = new BookJacksonJsonRepository();
        LoanAgreementJacksonRepository loanAgreementJacksonRepository = new LoanAgreementJacksonRepository();
        UserJacksonJsonRepository userJacksonJsonRepository = new UserJacksonJsonRepository();
        BookManagementService bookManagementService = new BookManagementService(bookJacksonJsonRepository);
        UserManagementService userManagementService = new UserManagementService(userJacksonJsonRepository);
        LoanAgreementManagementService loanAgreementManagementService = new LoanAgreementManagementService(loanAgreementJacksonRepository, userJacksonJsonRepository, bookJacksonJsonRepository);

        userManagementService.loadUsers();
        bookManagementService.loadBooks();
        loanAgreementManagementService.loadLoanAgreements();

        List<UserId> userIds = userManagementService.getAllUserIds();

        for (UserId userId : userIds) {
            System.out.println(userManagementService.getUsersFullNameById(userId));
            List<LoanAgreementId> loanAgreementIdList = loanAgreementManagementService.getLoanAgreementIdsByUserId(userId);
            for (LoanAgreementId loanAgreementId : loanAgreementIdList) {
                BookId bookid = loanAgreementManagementService.getBookIdByLoanAgreementId(loanAgreementId);
                System.out.println(bookManagementService.getBookTitleById(bookid));
                System.out.println("Tage bis das Buch zurückgegeben werden muss "+loanAgreementManagementService.getDaysUntilReturnDateByLoanAgreementId(loanAgreementId));
            }
        }




    }
}