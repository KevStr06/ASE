package org.persistence;

import org.domain.entities.User;
import org.domain.repositories.UserRepository;
import org.domain.valueObjects.UserId;

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
    public void save(User user) {

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

    }
}
