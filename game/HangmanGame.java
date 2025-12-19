package game;

import exception.InvalidLetterException;
import model.Player;
import model.Word;
import model.WordBank;
import model.WordProvider;
import util.InputUtils;

public class HangmanGame {

    private final Word word;
    private final Player player;
    private GameState state;
    private final WordProvider wordProvider;

    public HangmanGame() {
        this.wordProvider = new WordBank();
        this.word = new Word(wordProvider.getRandomWord());
        this.player = new Player(8);
        this.state = GameState.IN_PROGRESS;
    }

    public void start() {
        System.out.println("=== HANGMAN GAME ===");

        while (state == GameState.IN_PROGRESS) {
            System.out.println("\nWord: " + word.getProgress());
            System.out.println("Remaining attempts: " + player.getRemainingAttempts());

            try {
                char letter = InputUtils.readLetter();

                if (player.hasGuessed(letter)) {
                    System.out.println("You've already guessed this letter.");
                    continue;
                }

                boolean correct = word.guessLetter(letter);
                player.registerGuess(letter, correct);

                if (word.isComplete()) {
                    state = GameState.WON;
                    break;
                }

                if (player.getRemainingAttempts() == 0) {
                    System.out.println("\nNo attempts left!");
                    String fullGuess = InputUtils.readWord();

                    if (word.guessWord(fullGuess)) {
                        state = GameState.WON;
                    } else {
                        state = GameState.LOST;
                    }
                }

            } catch (InvalidLetterException e) {
                System.out.println(e.getMessage());
            }
        }

        if (state == GameState.WON) {
            System.out.println("\nYou win! The word was: " + word.getSecretWord());
        } else {
            System.out.println("\nYou lost! The word was: " + word.getSecretWord());
        }
    }
}
