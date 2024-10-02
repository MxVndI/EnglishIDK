package org.example.storage;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.model.User;
import org.example.model.Word;
import org.example.repository.WordRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Scope
@Component
@RequiredArgsConstructor
public class WordsStorage {
    private final WordRepository wordRepository;
    private final UserStorage userStorage;

    public void addWord(Word word, Integer userId) {
        word.setUser(userStorage.getUserById(userId));
        wordRepository.save(word);
    }

    public Collection<Word> getAllWords(Integer userId) {
        //wordRepository.findBy(userId);
        return null;
    }
}
