package util;

import exception.InvalidLetterException;
import java.util.Scanner;

public class InputUtils {
    private static final Scanner scanner = new Scanner(System.in);

    public static char readLetter() throws InvalidLetterException {
        System.out.print("Type a letter: ");
        String input = scanner.nextLine().toUpperCase();

        if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
            throw new InvalidLetterException("Invalid input! Please enter only one letter.");
        }
        return input.charAt(0);
    }
}
