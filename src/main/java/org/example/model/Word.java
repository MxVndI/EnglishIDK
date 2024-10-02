package org.example.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "words")
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    private String englishTranslate;
    @NonNull
    private String russianTranslate;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
