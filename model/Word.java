package model;

public class Word {

    private final String secretWord;
    private final char[] discoveredLetters;

    public Word(String secretWord) {
        this.secretWord = secretWord.toUpperCase();
        this.discoveredLetters = new char[this.secretWord.length()];

        for (int i = 0; i < discoveredLetters.length; i++) {
            discoveredLetters[i] = '_';
        }
    }

    public boolean guessLetter(char letter) {
        boolean correct = false;
        letter = Character.toUpperCase(letter);

        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == letter) {
                discoveredLetters[i] = letter;
                correct = true;
            }
        }

        return correct;
    }

    public boolean guessWord(String guess) {
    if (guess == null) return false;

    boolean correct = secretWord.equals(guess.trim().toUpperCase());
    if (correct) {
        for (int i = 0; i < secretWord.length(); i++) {
            discoveredLetters[i] = secretWord.charAt(i);
        }
    }
    return correct;
    }


    public boolean isComplete() {
        for (char c : discoveredLetters) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }

    public String getProgress() {
        return new String(discoveredLetters);
    }

    public String getSecretWord() {
        return secretWord;
    }
}
