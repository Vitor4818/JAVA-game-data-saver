package model;

import java.sql.Connection;
import java.sql.SQLException;
import oracle.jdbc.pool.OracleDataSource; // Importar o OracleDataSource

public class JdbcConfig {

    private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    private static final String USER = "usuario do banco de dados";
    private static final String PASS = "senha do banco de dados";

    // Método para obter a conexão com o banco de dados
    public static Connection getConnection() throws SQLException {
        OracleDataSource ods = new OracleDataSource(); // Cria uma instância de OracleDataSource

        // Configura a URL, usuário e senha
        ods.setURL(URL);
        ods.setUser(USER);
        ods.setPassword(PASS);


        Connection conn = ods.getConnection();


        return conn;
    }
}
