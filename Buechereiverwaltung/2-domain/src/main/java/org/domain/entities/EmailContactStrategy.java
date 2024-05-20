package org.domain.entities;

import org.domain.valueObjects.Email;

import java.net.URLEncoder;

public class EmailContactStrategy implements ContactMethodStrategy {
    private final Email email;

    public EmailContactStrategy(Email email) {
        this.email = email;
    }

    @Override
    public void contact(String message) {
        System.out.println("Generiere Mailto Link...");
        message = URLEncoder.encode(message);
        System.out.println("mailto:" + email.getEmail() + "?subject=Ihre%20B%C3%BCcherei&body=" + message);
    }
}
