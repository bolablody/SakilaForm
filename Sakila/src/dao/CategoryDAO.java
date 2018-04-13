package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;
import util.ConnectionJDBC;

public class CategoryDAO {

    Connection connection;

    public CategoryDAO() throws Exception {
        // Obtem uma conexão
        connection = ConnectionJDBC.getConnection();
    }

    public void save(Category category) throws Exception {
        String SQL = "INSERT INTO CATEGORY (NAME, LAST_UPDATE) VALUES (?, ?)";
        try {
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setString(1, category.getName());
            p.setTimestamp(2, category.getLast_update());
            p.execute();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }

    public void update(Category category) throws Exception {
        String SQL = "UPDATE CATEGORY SET NAME=?, LAST_UPDATE=? WHERE CATEGORY_ID=?";
        try {
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setString(1, category.getName());
            p.setTimestamp(2, category.getLast_update());
            p.setInt(3, category.getCategory_id());
            p.execute();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }

    public void delete(Category category) throws Exception {
        String SQL = "DELETE FROM CATEGORY WHERE CATEGORY_ID=?";
        try {
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setInt(1, category.getCategory_id());
            p.execute();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }

    public Category findById(int id) {
        return new Category();
    }

    public List<Category> findAll() throws Exception {
        // Lista para manter os valores do ResultSet
        List<Category> list = new ArrayList<>();
        Category objeto;
        String SQL = "SELECT * FROM CATEGORY";
        try {
            // Prepara a SQL
            PreparedStatement p = connection.prepareStatement(SQL);
            // Executa a SQL e mantem os valores no ResultSet rs
            ResultSet rs = p.executeQuery();
            // Navega pelos registros no rs
            while (rs.next()) {
                // Instancia a classe e informa os valores do BD
                objeto = new Category();
                objeto.setCategory_id(rs.getInt("category_id"));
                objeto.setName(rs.getString("name"));
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
