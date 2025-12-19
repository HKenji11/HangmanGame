package model;

import java.util.HashMap;
import java.util.Map;

public class Player {
    private int remainingAttempts;
    private Map<Character, Boolean> guessedLetters;

    public Player(int attempts) {
        this.remainingAttempts = attempts;
        this.guessedLetters = new HashMap<>();
    }

    public boolean hasGuessed(char letter) {
        return guessedLetters.containsKey(letter);
    }

    public void registerGuess(char letter, boolean correct) {
        guessedLetters.put(letter, correct);
        if (!correct) {
            remainingAttempts--;
        }
    }

    public int getRemainingAttempts() {
        return remainingAttempts;
    }
}
