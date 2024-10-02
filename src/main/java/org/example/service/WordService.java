package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.model.Word;
import org.example.storage.UserStorage;
import org.example.storage.WordsStorage;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class WordService {
    private final WordsStorage wordsStorage;

    public void addWord(Word word, Integer userId) {
        wordsStorage.addWord(word, userId);
    }

    public Collection<Word> getAllWords(Integer userId) {
        return wordsStorage.getAllWords(userId);
    }
}
