package View;

import model.Jogo;

public class JogoView {

    public JogoView() {
    }

    public void detalhesJogo(Jogo jogo) {
        System.out.println("Nome: " + jogo.getName());
        System.out.println("Data de lançamento: " + jogo.getReleased());
        System.out.println("Nota no metacritic: " + jogo.getMetacritic());
        System.out.println("Sinopse: " + jogo.getDescription());
        System.out.println("==========================================");
    }


    public  void jogosCadastrados(java.util.List<Jogo> listaJogos){
        for (Jogo jogo : listaJogos){
            detalhesJogo(jogo);
        }
    }
}


