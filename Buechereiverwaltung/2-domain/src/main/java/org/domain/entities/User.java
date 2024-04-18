package org.domain.entities;

import org.domain.valueObjects.Name;
import org.domain.valueObjects.UserId;

import java.util.UUID;

public class User {
    private final UserId id;
    private final Name name;

    public User(String name, String surname) {
        this.id = new UserId();
        this.name = new Name(name, surname);
    }

    public String getName() {
        return name.getName();
    }
    public String getSurname() {
        return name.getSurname();
    }
    public String getFullName() {
        return name.getFullName();
    }
    public UserId getId() {
        return id;
    }
}
