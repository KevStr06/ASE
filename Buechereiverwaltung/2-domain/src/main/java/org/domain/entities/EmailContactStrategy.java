package org.domain.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.domain.valueObjects.Email;

import java.net.URLEncoder;

public class EmailContactStrategy implements ContactMethodStrategy {

    @JsonProperty("contactEmail")
    private final Email contactEmail;
    @JsonCreator
    public EmailContactStrategy(
            @JsonProperty("contactEmail") Email contactEmail) {
        this.contactEmail = contactEmail;
    }

    @Override
    public void contact(String message) {
        System.out.println("Generiere Mailto Link...");
        message = URLEncoder.encode(message);
        System.out.println("mailto:" + contactEmail.getEmail() + "?subject=Ihre%20B%C3%BCcherei&body=" + message);
    }
}
