package game;

import model.Palavra;
import model.BancoDePalavras;
import model.Jogador;
import util.EntradaUtils;
import exception.LetraInvalidaException;

public class ForcaGame {

    private Palavra palavra;
    private Jogador jogador;
    private GameState estado;
    private BancoDePalavras bancoDePalavras;

    public ForcaGame() {
        bancoDePalavras = new BancoDePalavras();

        String palavraSorteada = bancoDePalavras.sortearPalavra();

        palavra = new Palavra(palavraSorteada);
        jogador = new Jogador(6);
        estado = GameState.EM_ANDAMENTO;
    }

    public void iniciar() {
        System.out.println("=== HANGMAN GAME ===");

        while (estado == GameState.EM_ANDAMENTO) {
            System.out.println("\nWord: " + palavra.getProgresso());
            System.out.println("Remaining attempts: " + jogador.getTentativasRestantes());

            try {
                char letra = EntradaUtils.lerLetra();

                if (jogador.jaTentou(letra)) {
                    System.out.println("You've tried this letter before!");
                    continue;
                }

                boolean acertou = palavra.tentarLetra(letra);
                jogador.registrarTentativa(letra, acertou);

                if (palavra.estaCompleta()) {
                    estado = GameState.VENCEU;
                } else if (jogador.getTentativasRestantes() == 0) {
                    estado = GameState.PERDEU;
                }

            } catch (LetraInvalidaException e) {
                System.out.println(e.getMessage());
            }
        }

        if (estado == GameState.VENCEU) {
            System.out.println("\n🎉 You win! Word: " + palavra.getProgresso());
        } else {
            System.out.println("\n💀 You lost! Word: " + palavra.returnPalavra());
        }
    }
}
