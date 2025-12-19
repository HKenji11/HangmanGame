package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WordDatabase {

    private ArrayList<String> words;
    private Random random;

    public WordDatabase() {
        words = new ArrayList<>();
        random = new Random();
        loadWords();
    }

    private void loadWords() {
        try {
            File files = new File("resources/words.txt");
            Scanner scanner = new Scanner(files);

            while (scanner.hasNextLine()) {
                String word = scanner.nextLine().trim();

                if (!word.isEmpty()) {
                    words.add(word.toUpperCase());
                }
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Word file not found!");
            System.exit(1);
        }
    }

    public String drawWords() {
        int index = random.nextInt(words.size());
        return words.get(index);
    }
}
