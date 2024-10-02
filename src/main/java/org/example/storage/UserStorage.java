package org.example.storage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.model.User;
import org.example.model.Word;
import org.example.repository.UserRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Scope
@Slf4j
@Component
@RequiredArgsConstructor
public class UserStorage {
    private final UserRepository userRepository;

    public User getUserById(int userId) {
        return userRepository.findById(userId).get();
    }

    public User addUser(User user) {
        userRepository.save(user);
        return user;
    }

    public Collection<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    public void deleteUserById(Integer userId) {
        userRepository.deleteById(userId);
    }

    public void addUserWord(Integer userId, Word word) {
        User user = userRepository.findById(userId).get();
        Set<Word> userWords = user.getWords();
        user.setWords(userWords);
        userRepository.save(user);
    }
}
