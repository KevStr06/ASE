package org.persistence;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.domain.entities.User;
import org.domain.repositories.UserRepository;
import org.domain.valueObjects.UserId;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserJacksonJsonRepository implements UserRepository {
    private final List<User> users = new ArrayList<User>();

    @Override
    public List<User> listAll() {
        return new ArrayList<>(users);
    }

    @Override
    public User findByUserId(UserId userId) {
        return users.stream()
                .filter(user -> user.getId().equals(userId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        try (var writer = new FileWriter("users.save", true)) {
            String jsonString = mapper.writeValueAsString(users);

            writer.write(jsonString);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(User user) {
        users.remove(user);
    }

    @Override
    public void add(User user) {
        users.add(user);
    }

    @Override
    public void load() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        try (var reader = new FileReader("users.save")) {
            List<User> loadedUsers = mapper.readValue(reader, new TypeReference<List<User>>() {});
            users.clear();
            users.addAll(loadedUsers);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
