package org.domain.entities;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.CLASS,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = EmailContactStrategy.class),
        @JsonSubTypes.Type(value = LetterContactStrategy.class)
})

public interface ContactMethodStrategy {
    void contact(String message);
}
