package org.application.services;

import org.domain.entities.User;
import org.domain.repositories.UserRepository;
import org.domain.valueObjects.BookId;
import org.domain.valueObjects.Email;
import org.domain.valueObjects.UserId;

import java.util.ArrayList;
import java.util.List;

public class UserManagementService {
    private final UserRepository userRepository;

    public UserManagementService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserId createUser(String name, String surname, String email) {
        User user = new User(name, surname, new Email(email));
        userRepository.add(user);
        return user.getId();
    }

    public void loadUsers() {
        userRepository.load();
    }

    public void saveUsers() {
        userRepository.save();
    }

    public void clearAllUsers() {
        for (User user : userRepository.listAll()) {
            userRepository.remove(user);
        }
    }

    public List<UserId> getAllUserIds() {
        List<UserId> userIds = new ArrayList<>();
        for (User user : userRepository.listAll()) {
            userIds.add(user.getId());
        }
        return userIds;
    }

    public String getUserNameById(UserId userId) {
        return userRepository.findByUserId(userId).getName();
    }

    public String getUserSurnameById(UserId userId) {
        return userRepository.findByUserId(userId).getSurname();
    }

    public String getUsersFullNameById(UserId userId) {
        return userRepository.findByUserId(userId).getFullName();
    }

    public void registerBookmarkToUserById(BookId bookId, UserId userId) {
        userRepository.findByUserId(userId).registerBookmark(bookId);
    }

    public void removeBookmarkFromUserById(BookId bookId, UserId userId) {
        userRepository.findByUserId(userId).removeBookmark(bookId);
    }

    public List<BookId> getBookmarksFromUserById(UserId userId) {
        return userRepository.findByUserId(userId).getBookmarks();
    }

    public void userReceiveMessageById(UserId userId, String message) {
        userRepository.findByUserId(userId).receiveMessage(message);
    }

}
