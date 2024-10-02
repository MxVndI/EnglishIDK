package org.example;

import org.example.model.Word;
import org.example.service.WordService;

import java.util.*;

public class TestGenerator {
    private WordService wordService;

    public TestGenerator(WordService wordService) {
        this.wordService = wordService;
    }

    public Collection<String> generateTest(int userId, int countWords) throws Exception {
        List<Word> userWords = (List<Word>) wordService.getAllWords(userId);
        Collections.shuffle(userWords);
        if (userWords.size() > countWords) {
            userWords.subList(userWords.size() - countWords, userWords.size()).clear();
            return randomTranslationWord(userWords);
        }
        else {
            throw new Exception("Вы не изучили еще столько слов :3");
        }
    }

    private Collection<String> randomTranslationWord(List<Word> wordList) {
        ArrayList<String> randomTranslationWords = new ArrayList<>();
        Random random = new Random();
        for (Word word: wordList) {
            if (random.nextInt(1,2) == 1) {
                randomTranslationWords.add(word.getEnglishTranslate());
            } else {
                randomTranslationWords.add(word.getRussianTranslate());
            }
        }
        return randomTranslationWords;
    }
}
