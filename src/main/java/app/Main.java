package app;


import controller.JogoController;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        JogoController controller = new JogoController();
        controller.buscaJogo("final-fantasy-viii");
        controller.ListarJogos();
    }

}
