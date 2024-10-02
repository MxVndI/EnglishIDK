package org.example.storage;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.model.Word;
import org.example.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Scope
@Component
@RequiredArgsConstructor
public class WordsStorage {
    private final WordRepository wordRepository;


    public void addWord(Word word) {
        wordRepository.save(word);
    }

    public Collection<Word> getAllWords(Integer userId) {
        //wordRepository.findBy(userId);
        return null;
    }
}
