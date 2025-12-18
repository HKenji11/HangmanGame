package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WordBank implements WordProvider {

    private final List<String> words;
    private final Random random;

    public WordBank() {
        this.words = new ArrayList<>();
        this.random = new Random();
        loadWords();
    }

    private void loadWords() {
        File file = new File("resources/words.txt");

        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                String word = scanner.nextLine().trim();

                if (!word.isEmpty()) {
                    words.add(word.toUpperCase());
                }
            }

        } catch (FileNotFoundException e) {
            throw new IllegalStateException(
                "Word file not found: resources/words.txt", e
            );
        }

        if (words.isEmpty()) {
            throw new IllegalStateException("Word list is empty.");
        }
    }

    @Override
    public String getRandomWord() {
        int index = random.nextInt(words.size());
        return words.get(index);
    }
}
