package model;

public class Palavra {
    private String palavraSecreta;
    private char[] letrasDescobertas;

    public Palavra(String palavraSecreta) {
        this.palavraSecreta = palavraSecreta.toUpperCase();
        this.letrasDescobertas = new char[palavraSecreta.length()];

        for (int i = 0; i < letrasDescobertas.length; i++) {
            letrasDescobertas[i] = '_';
        }
    }

    public boolean tentarLetra(char letra) {
        boolean acertou = false;

        for (int i = 0; i < palavraSecreta.length(); i++) {
            if (palavraSecreta.charAt(i) == letra) {
                letrasDescobertas[i] = letra;
                acertou = true;
            }
        }
        return acertou;
    }

    public boolean estaCompleta() {
        for (char c : letrasDescobertas) {
            if (c == '_')
                return false;
        }
        return true;
    }

    public String getProgresso() {
        return new String(letrasDescobertas);
    }

    public String returnPalavra() {
        return palavraSecreta;
    }
}
