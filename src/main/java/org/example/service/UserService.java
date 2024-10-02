package org.example.service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.model.User;
import org.example.exceptions.NotFoundException;
import org.example.model.Word;
import org.example.storage.UserStorage;
import org.example.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class UserService {
    private static final String NOT_FOUND_MESSAGE = "пользователя с id %s нет";
    private final UserStorage userStorage;

    public User createUser(User user) {
        return userStorage.addUser(user);
    }

    public Collection<User> getAllUsers() {
        return userStorage.getAllUsers();
    }

    public User getUserById(Integer id) {
        User user = userStorage.getUserById(id);
        checkUserIsNotFound(user, id);
        return user;
    }

    public void deleteUserById(Integer id) {
        if (userStorage.getUserById(id) == null) {
            throw new NotFoundException(String.format(NOT_FOUND_MESSAGE, id));
        }
    }

    private void checkUserIsNotFound(User user, Integer id) {
        if (UserValidator.isUserNotFound(user)) {
            throw new NotFoundException(String.format(NOT_FOUND_MESSAGE, id));
        }
    }

    public void addUserWord(Integer userId, Word word) {
        userStorage.addUserWord(userId, word);
    }
}