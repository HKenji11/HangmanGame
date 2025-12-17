package util;

import exception.LetraInvalidaException;
import java.util.Scanner;

public class EntradaUtils {
    private static final Scanner scanner = new Scanner(System.in);

    public static char lerLetra() throws LetraInvalidaException {
        System.out.print("Type a letter: ");
        String entrada = scanner.nextLine().toUpperCase();

        if (entrada.length() != 1 || !Character.isLetter(entrada.charAt(0))) {
            throw new LetraInvalidaException("Invalid input! Please enter only one letter.");
        }
        return entrada.charAt(0);
    }
}
