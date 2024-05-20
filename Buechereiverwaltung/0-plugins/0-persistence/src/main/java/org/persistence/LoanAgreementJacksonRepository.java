package org.persistence;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.domain.entities.LoanAgreement;
import org.domain.repositories.LoanAgreementRepository;
import org.domain.valueObjects.BookId;
import org.domain.valueObjects.LoanAgreementId;
import org.domain.valueObjects.UserId;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoanAgreementJacksonRepository implements LoanAgreementRepository {

    private final List<LoanAgreement> loanAgreements = new ArrayList<LoanAgreement>();

    @Override
    public List<LoanAgreement> listAll() {
        return new ArrayList<>(loanAgreements);
    }

    @Override
    public LoanAgreement findByLoanAgreementId(LoanAgreementId loanAgreementId) {
        return loanAgreements.stream()
                .filter(loanAgreement -> loanAgreement.getLoanAgreementId().equals(loanAgreementId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<LoanAgreement> findByUserId(UserId userId) {
        return loanAgreements.stream()
                .filter(loanAgreement -> loanAgreement.getUserId().equals(userId))
                .toList();
    }

    @Override
    public List<LoanAgreement> findByBookId(BookId bookId) {
        return loanAgreements.stream()
                .filter(loanAgreement -> loanAgreement.getBookId().equals(bookId))
                .toList();
    }

    @Override
    public void save() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        try (var writer = new FileWriter("loanAgreements.save", true)) {
            String jsonString = mapper.writeValueAsString(loanAgreements);

            writer.write(jsonString);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(LoanAgreement loanAgreement) {
        loanAgreements.remove(loanAgreement);
    }

    @Override
    public void add(LoanAgreement loanAgreement) {
        loanAgreements.add(loanAgreement);
    }

    @Override
    public void load() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        try (var reader = new FileReader("loanAgreements.save")) {
            List<LoanAgreement> loadedLoanAgreements = mapper.readValue(reader, new TypeReference<List<LoanAgreement>>() {
            });
            loanAgreements.clear();
            loanAgreements.addAll(loadedLoanAgreements);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
