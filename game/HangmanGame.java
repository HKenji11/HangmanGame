package game;

import exception.InvalidLetterException;
import model.Player;
import model.Word;
import model.WordDatabase;
import util.InputUtils;

public class HangmanGame {

    private Word word;
    private Player player;
    private GameState state;
    private WordDatabase wordDatabase;

    public HangmanGame() {
        wordDatabase = new WordDatabase();

        String drawnWord = wordDatabase.drawWords();

        word = new Word(drawnWord);
        player = new Player(6);
        state = GameState.IN_PROGRESS;
    }

    public void startGame() {
        System.out.println("=== HANGMAN GAME ===");

        while (state == GameState.IN_PROGRESS) {
            System.out.println("\nWord: " + word.getProgress());
            System.out.println("Remaining attempts: " + player.getRemainingAttempts());

            try {
                char letter = InputUtils.readLetter();

                if (player.hasGuessed(letter)) {
                    System.out.println("You've tried this letter before!");
                    continue;
                }

                boolean correct = word.guessLetter(letter);
                player.registerGuess(letter, correct);

                if (word.isComplete()) {
                    state = GameState.WON;
                } else if (player.getRemainingAttempts() == 0) {
                    state = GameState.LOST;
                }

            } catch (InvalidLetterException e) {
                System.out.println(e.getMessage());
            }
        }

        if (state == GameState.WON) {
            System.out.println("\n🎉 You win! Word: " + word.getProgress());
        } else {
            System.out.println("\n💀 You lost! Word: " + word.returnWord());
        }
    }
}
