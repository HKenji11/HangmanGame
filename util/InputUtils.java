package util;

import exception.InvalidLetterException;
import java.util.Scanner;

public final class InputUtils {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputUtils() {
        // Utility class: prevent instantiation
    }

    public static char readLetter() throws InvalidLetterException {
        System.out.print("Type a letter: ");
        String input = SCANNER.nextLine().trim();

        if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
            throw new InvalidLetterException("Invalid input! Please enter exactly one letter (A-Z).");
        }

        return Character.toUpperCase(input.charAt(0));
    }

    public static String readWord() {
        System.out.print("Type the full word: ");
        return SCANNER.nextLine().trim().toUpperCase();
    }
}
