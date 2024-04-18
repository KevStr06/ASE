package org.domain.valueObjects;

import java.util.Objects;
import java.util.UUID;

public class LoanAgreementId {
    private final UUID id;

    public LoanAgreementId() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoanAgreementId loanAgreementId = (LoanAgreementId) o;
        return Objects.equals(id, loanAgreementId.id);
    }
}
