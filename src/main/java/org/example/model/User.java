package org.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.util.Set;
//import org.springframework.security.crypto.bcrypt.BCrypt;

@Getter
@Setter
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String login;
    private String password;

    @Email
    private String email;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Word> words;

    public User(String login, String password, String email) {
        this.login = login;
        this.password = password;
        //this.password = hashPassword(password);
        this.email = email;
    }

//    private String hashPassword(String password) {
//        String salt = BCrypt.gensalt();
//        String hashedPassword = BCrypt.hashpw(password, salt);
//        return hashedPassword;
//    }
}
