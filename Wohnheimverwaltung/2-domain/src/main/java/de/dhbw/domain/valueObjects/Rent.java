package de.dhbw.domain.valueObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Rent {
    // Rent should be a value object because it is a specialised form currency amounts.
    private final int amount;
    private static final char cachedCommaSeparator;

    // Cache the comma separator safely once
    static {
        Locale jvmLocale = Locale.getDefault();
        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(jvmLocale);
        cachedCommaSeparator = symbols.getDecimalSeparator();
    }

    @JsonCreator
    public Rent(
            @JsonProperty("amount") int amount
    ) {
        if (amount <= 0)
            throw new IllegalArgumentException("Rent must be greater than 0");

        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rent that = (Rent) o;

        return amount == that.amount;
    }

    @Override
    public String toString() {
        return String.format(Locale.getDefault(), "%,2d%s00 €", amount, cachedCommaSeparator);
    }
}