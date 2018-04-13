package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Country;
import util.ConnectionJDBC;

public class CountryDAO {

    Connection connection;

    public CountryDAO() throws Exception {
        // Obtem uma conexão
        connection = ConnectionJDBC.getConnection();
    }

    public void save(Country country) throws Exception {
        String SQL = "INSERT INTO COUNTRY (COUNTRY, LAST_UPDATE) VALUES (?, ?)";
        try {
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setString(1, country.getCountry());
            p.setTimestamp(2, country.getLast_update());
            p.execute();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }

    public void update(Country country) throws Exception {
        String SQL = "UPDATE COUNTRY SET COUNTRY=?, LAST_UPDATE=? WHERE COUNTRY_ID=?";
        try {
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setString(1, country.getCountry());
            p.setTimestamp(2, country.getLast_update());
            p.setInt(3, country.getCountry_id());
            p.execute();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }

    public void delete(Country country) throws Exception {
        String SQL = "DELETE FROM COUNTRY WHERE COUNTRY_ID=?";
        try {
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setInt(1, country.getCountry_id());
            p.execute();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }

    public Country findById(int id) {
        return new Country();
    }

    public List<Country> findAll() throws Exception {
        // Lista para manter os valores do ResultSet
        List<Country> list = new ArrayList<>();
        Country objeto;
        String SQL = "SELECT * FROM COUNTRY";
        try {
            // Prepara a SQL
            PreparedStatement p = connection.prepareStatement(SQL);
            // Executa a SQL e mantem os valores no ResultSet rs
            ResultSet rs = p.executeQuery();
            // Navega pelos registros no rs
            while (rs.next()) {
                // Instancia a classe e informa os valores do BD
                objeto = new Country();
                objeto.setCountry_id(rs.getInt("country_id"));
                objeto.setCountry(rs.getString("country"));
                objeto.setLast_update(rs.getTimestamp("last_update"));
                // Inclui na lista
                list.add(objeto);
            }
            rs.close();
            p.close();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
        // Retorna a lista
        return list;
    }
}
