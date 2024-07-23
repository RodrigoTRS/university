package resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db {

    private static Db instance;
    public Connection connection = null;
    private Env env;


    private Db() {
        this.connection = null;
        this.env = Env.getInstance();
    }

    public void connect() {
        try {
            // Chama o JDBC
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Cria a conexão
            connection = DriverManager.getConnection(env.getUrl(), env.getUser(), env.getPassword());

            // Lidando com erros e falhas
            if (connection != null) {
                System.out.println("Conectado ao banco de dados!");
            } else {
                System.out.println("Falha ao se conectar ao banco de dados.");
            }
        }
        catch (ClassNotFoundException e) {
            System.out.println("JDBC driver não encontrado.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Conexão falhou.");
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Banco de dados não encontrado.");
            throw new RuntimeException(e);
        }
    }

    public static Db getInstance() {
        if (instance == null) {
            instance = new Db();
        }
        return instance;
    }
}
