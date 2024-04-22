package org.domain.valueObjects;

import java.util.Objects;

public class Name {
    private final String name;
    private final String surname;

    public Name(String name, String surname) {
        this.name = validateName(name);
        this.surname = validateName(surname);
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getFullName() {
        return name + " " + surname;
    }

    private String validateName(String name) {
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Name must not be null or empty");{}
        name = name.trim();
        return name;
    }

    public String toString() {
        return getFullName();
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name nameNew = (Name) o;
        return Objects.equals(name, nameNew.name) && Objects.equals(surname, nameNew.surname);
    }


}
