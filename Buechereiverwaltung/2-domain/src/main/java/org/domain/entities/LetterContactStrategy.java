package org.domain.entities;

import com.fasterxml.jackson.annotation.JsonCreator;

public class LetterContactStrategy implements ContactMethodStrategy {

    @JsonCreator
    public LetterContactStrategy() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void contact(String message) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
