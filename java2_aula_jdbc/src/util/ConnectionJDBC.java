package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionJDBC {

    private static Connection connection;

    public static Connection getConnection() throws Exception {

        if (connection == null) {
            try {
                // Testar o carregamento da classe (Driver)
                Class.forName("org.firebirdsql.jdbc.FBDriver");
            } catch (ClassNotFoundException ex) {
                throw new Exception(ex);
            }
            
            // Dados de conexão
                String servidor = "localhost";
                String database = "E:\\OneDrive\\Documentos\\AULA\\JAVA\\DB JAVA\\AULA06.FDB";
                String url = "jdbc:firebirdsql:" + servidor + "/3050:" + database + "?encoding=WIN1252";
                String user = "SYSDBA";
                String password = "masterkey";
                
            try {
                Connection con = DriverManager.getConnection(url, user, password);
            } catch (SQLException ex) {
                throw new Exception(ex);
            }
        }
        return connection;
    }

    public static void main(String[] args) {
        System.out.println("Teste!");
        try {
            ConnectionJDBC.getConnection();
        } catch (Exception ex) {
            System.out.println(""+ex.getMessage());
        }
    }
}
