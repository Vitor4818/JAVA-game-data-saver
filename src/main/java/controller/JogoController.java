package controller;

import View.JogoView;
import model.DAO.JogoDAO;
import model.Jogo;
import service.RawgService;

import java.io.IOException;

public class JogoController {
    private RawgService rawgService;
    private JogoDAO jogoDAO;
    private JogoView jogoView;

    public JogoController() {
        this.rawgService = new RawgService();
        this.jogoDAO = new JogoDAO();
        this.jogoView = new JogoView();
    }

    public void buscaJogo(String nomeJogo) throws IOException {
        try{
            Jogo jogo = rawgService.getJogo(nomeJogo);

            if(jogo!=null){
                System.out.println("===DADOS DO JOGO===");
                jogoView.detalhesJogo(jogo);

                jogoDAO.addJogo(jogo);
            }else{
                System.out.println("Jogo não encontrado!");
            }

        }catch (IOException e){
            System.out.println("Erro ao buscar jogo: "+ e.getMessage());
            e.printStackTrace();
        }

    }



    public void ListarJogos(){
        try{
            jogoView.jogosCadastrados(jogoDAO.mostrarJogos());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
