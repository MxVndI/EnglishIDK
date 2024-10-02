package org.example.validators;

import org.example.model.User;

import java.util.Objects;

public class UserValidator {

    public static boolean isUserNotFound(User user) {
        return Objects.isNull(user);
    }

}
