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
        LoanAgreementId that = (LoanAgreementId) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "LoanAgreementId{" +
                "id=" + id +
                '}';
    }
}
