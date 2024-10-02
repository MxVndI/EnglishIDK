package org.example.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.model.User;
import org.example.model.Word;
import org.example.service.UserService;
import org.example.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final WordService wordService;

    @PostMapping
    public User addUser(@Valid @RequestBody User user) {
        userService.createUser(user);
        return user;
    }

    @GetMapping
    public Collection<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Integer id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable("id") Integer id) {
        userService.deleteUserById(id);
    }

    //@RequestMapping("/users/{id}/words")
    @PostMapping("/{id}/words/")
    public Word addUserWord(@PathVariable("id") Integer userId, @Valid @RequestBody Word word) {
        wordService.addWord(word);
        userService.addUserWord(userId, word);
        return word;
    }

    @GetMapping("/{id}/words")
    public Collection<Word> getAllWords(@PathVariable("id") Integer userId) {
        wordService.getAllWords(userId);
        return null;
    }
}
