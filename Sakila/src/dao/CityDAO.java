package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.City;
import model.Country;
import util.ConnectionJDBC;

public class CityDAO {

    Connection connection;

    public CityDAO() throws Exception {
        // Obtem uma conexão
        connection = ConnectionJDBC.getConnection();
    }

    public void save(City city) throws Exception {
        String SQL = "INSERT INTO CITY (CITY, COUNTRY_ID, LAST_UPDATE) VALUES (?, ?, ?)";
        try {
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setString(1, city.getCity());
            p.setInt(2, city.getCountry().getCountry_id());
            p.setTimestamp(3, city.getLast_update());
            p.execute();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }

    public void update(City city) throws Exception {
        String SQL = "UPDATE CITY SET CITY=?, COUNTRY_ID=?, LAST_UPDATE=? WHERE CITY_ID=?";
        try {
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setString(1, city.getCity());
            p.setInt(2, city.getCountry().getCountry_id());
            p.setTimestamp(3, city.getLast_update());
            p.setInt(4, city.getCity_id());
            p.execute();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }

    public void delete(City city) throws Exception {
        String SQL = "DELETE FROM CITY WHERE CITY_ID=?";
        try {
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setInt(1, city.getCity_id());
            p.execute();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }

    public City findById(int id) throws Exception {
        City city = new City();
        String SQL = "SELECT C.*, CC.* FROM CITY C "
                   + "INNER JOIN COUNTRY CC ON CC.COUNTRY_ID = C.COUNTRY_ID "
                   + "WHERE CITY_ID = ?";
        try {
            // Prepara a SQL
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setInt(1, id);
            // Executa a SQL e mantem os valores no ResultSet rs
            ResultSet rs = p.executeQuery();
            // Navega pelos registros no rs
            while (rs.next()) {
                // Instancia a classe e informa os valores do BD
                city.setCity_id(rs.getInt("city_id"));
                city.setCity(rs.getString("city"));
                city.setLast_update(rs.getTimestamp("last_update"));
                
                Country country = new Country();
                country.setCountry_id(rs.getInt("country_id"));
                country.setCountry(rs.getString("country"));
                country.setLast_update(rs.getTimestamp("last_update"));
                // Inclui na lista
                city.setCountry(country);
            }
            rs.close();
            p.close();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
        // Retorna a lista
        return city;
    }

    public List<City> findAll() throws Exception {
        // Lista para manter os valores do ResultSet
        List<City> list = new ArrayList<>();
        City city = new City();
        String SQL = "SELECT C.*, CC.* FROM CITY C "
                   + "INNER JOIN COUNTRY CC ON CC.COUNTRY_ID = C.COUNTRY_ID";
        try {
            // Prepara a SQL
            PreparedStatement p = connection.prepareStatement(SQL);
            // Executa a SQL e mantem os valores no ResultSet rs
            ResultSet rs = p.executeQuery();
            // Navega pelos registros no rs
            while (rs.next()) {
                // Instancia a classe e informa os valores do BD
                city = new City();
                city.setCity_id(rs.getInt("city_id"));
                city.setCity(rs.getString("city"));
                city.setLast_update(rs.getTimestamp("last_update"));
                
                Country country = new Country();
                country.setCountry_id(rs.getInt("country_id"));
                country.setCountry(rs.getString("country"));
                country.setLast_update(rs.getTimestamp("last_update"));
                
                city.setCountry(country);
                
                // Inclui na lista
                list.add(city);
            }
            rs.close();
            p.close();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
        // Retorna a lista
        return list;
    }
    
    public static void main(String[] args) {
        try {
            new CityDAO().findAll();
        } catch (Exception ex) {
            Logger.getLogger(CityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
