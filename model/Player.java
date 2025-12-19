package model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Player extends AbstractPlayer {

    private final Set<Character> guessedLetters;

    public Player(int maxAttempts) {
        super(maxAttempts);
        this.guessedLetters = new HashSet<>();
    }

    public boolean hasGuessed(char letter) {
        letter = Character.toUpperCase(letter);
        return guessedLetters.contains(letter);
    }

    public void registerGuess(char letter, boolean correct) {
        letter = Character.toUpperCase(letter);
        guessedLetters.add(letter);

        if (!correct) {
            loseAttempt();
        }
    }

    public Set<Character> getGuessedLetters() {
        return Collections.unmodifiableSet(guessedLetters);
    }
}
