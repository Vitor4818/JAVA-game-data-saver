package model.DAO;

import model.JdbcConfig;
import model.Jogo;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class JogoDAO {

    //metodo para adicionar Jogo ao BD
    public void addJogo(Jogo jogo) {
        String insertSQL = "INSERT INTO TB_JOGOS (nome_jogo, data_lancamento, nota_metacritic, descricao) VALUES (?, ?, ?, ?)";

        try (Connection conn = JdbcConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {

            pstmt.setString(1, jogo.getName());
            pstmt.setString(2, jogo.getReleased());
            pstmt.setDouble(3, jogo.getMetacritic());
            pstmt.setString(4, jogo.getDescription());
            pstmt.executeUpdate();
            System.out.println("Jogo inserido ao banco de dados com sucesso!");
            System.out.println("==========================================");

        } catch (Exception e) {
            System.out.println("Erro ao inserir jogo: " + e.getMessage());
        }
    }

    // Lista todos os jogos
    public List<Jogo> mostrarJogos() {
        List<Jogo> listaJogos = new ArrayList<>();
        String selectAllSQL = "SELECT * FROM TB_JOGOS";

        try (Connection conn = JdbcConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(selectAllSQL)) {

            ResultSet rs = pstmt.executeQuery();

            System.out.println("\n");
            System.out.println("===LISTA DE JOGOS CADASTRADOS===");

            while (rs.next()) {
                String nomeJogo = rs.getString("nome_jogo");
                String dataLancamento = rs.getString("data_lancamento");
                double notaMetacritic = rs.getDouble("nota_metacritic"); // Aqui obtemos o double corretamente
                String descricao = rs.getString("descricao");


                Jogo jogo = new Jogo(nomeJogo, notaMetacritic, descricao, dataLancamento);
                listaJogos.add(jogo);
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar Jogos: " + e.getMessage());
        }



        return listaJogos;
    }

}
