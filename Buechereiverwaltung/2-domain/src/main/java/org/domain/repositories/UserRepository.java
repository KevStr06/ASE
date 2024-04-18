package org.domain.repositories;

import org.domain.entities.User;
import org.domain.valueObjects.UserId;

import java.util.List;

public interface UserRepository {
    List<User> listAll();
    User findByUserId(UserId userId);
    void save(User user);
    void remove(User user);
    void add (User user);
    void load ();
}
