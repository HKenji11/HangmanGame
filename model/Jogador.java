package model;

import java.util.HashMap;
import java.util.Map;

public class Jogador {
    private int tentativasRestantes;
    private Map<Character, Boolean> letrasTentadas;

    public Jogador(int tentativas) {
        this.tentativasRestantes = tentativas;
        this.letrasTentadas = new HashMap<>();
    }

    public boolean jaTentou(char letra) {
        return letrasTentadas.containsKey(letra);
    }

    public void registrarTentativa(char letra, boolean acertou) {
        letrasTentadas.put(letra, acertou);
        if (!acertou) {
            tentativasRestantes--;
        }
    }

    public int getTentativasRestantes() {
        return tentativasRestantes;
    }
}
