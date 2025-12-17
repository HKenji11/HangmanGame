package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BancoDePalavras {

    private ArrayList<String> palavras;
    private Random random;

    public BancoDePalavras() {
        palavras = new ArrayList<>();
        random = new Random();
        carregarPalavras();
    }

    private void carregarPalavras() {
        try {
            File arquivo = new File("resources/palavras.txt");
            Scanner scanner = new Scanner(arquivo);

            while (scanner.hasNextLine()) {
                String palavra = scanner.nextLine().trim();

                if (!palavra.isEmpty()) {
                    palavras.add(palavra.toUpperCase());
                }
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Word file not found!");
            System.exit(1);
        }
    }

    public String sortearPalavra() {
        int indice = random.nextInt(palavras.size());
        return palavras.get(indice);
    }
}
