package org.domain.valueObjects;

public class Email {
    private final String email;

    public Email(String email) {
        this.email = validateEmail(email);
    }

    public String getEmail() {
        return email;
    }

    private String validateEmail(String email) {
        if (email == null || email.isEmpty())
            throw new IllegalArgumentException("Email must not be null or empty");

        // Validate with Regex
        if (!email.matches("^[a-zA-Z0-9]+([a-zA-Z0-9._+-]*[a-zA-Z0-9]+)*@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"))
            throw new IllegalArgumentException("Email must be in the correct format");

        email = email.trim();
        return email;
    }

    public String toString() {
        return getEmail();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Email email1 = (Email) o;
        return email.equals(email1.email);
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }
}
