package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Actor;
import util.ConnectionJDBC;

public class ActorDAO {

    Connection connection;

    public ActorDAO() throws Exception {
        // Obtem uma conexão
        connection = ConnectionJDBC.getConnection();
    }

    public void save(Actor actor) throws Exception {
        String SQL = "INSERT INTO ACTOR (FIRST_NAME, LAST_NAME, LAST_UPDATE) VALUES (?, ?, ?)";
        try {
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setString(1, actor.getFirst_name());
            p.setString(2, actor.getLast_name());
            p.setTimestamp(3, actor.getLast_update());
            p.execute();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }

    public void update(Actor actor) throws Exception {
        String SQL = "UPDATE ACTOR SET FIRST_NAME=?, LAST_NAME=?, LAST_UPDATE=? WHERE ACTOR_ID=?";
        try {
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setString(1, actor.getFirst_name());
            p.setString(2, actor.getLast_name());
            p.setTimestamp(3, actor.getLast_update());
            p.setInt(4, actor.getActor_id());
            p.execute();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }

    public void delete(Actor actor) throws Exception {
        String SQL = "DELETE FROM ACTOR WHERE ACTOR_ID=?";
        try {
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setInt(1, actor.getActor_id());
            p.execute();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }

    public Actor findById(int id) {
        return new Actor();
    }

    public List<Actor> findAll() throws Exception {
        // Lista para manter os valores do ResultSet
        List<Actor> list = new ArrayList<>();
        Actor objeto;
        String SQL = "SELECT * FROM ACTOR";
        try {
            // Prepara a SQL
            PreparedStatement p = connection.prepareStatement(SQL);
            // Executa a SQL e mantem os valores no ResultSet rs
            ResultSet rs = p.executeQuery();
            // Navega pelos registros no rs
            while (rs.next()) {
                // Instancia a classe e informa os valores do BD
                objeto = new Actor();
                objeto.setActor_id(rs.getInt("actor_id"));
                objeto.setFirst_name(rs.getString("first_name"));
                objeto.setLast_name(rs.getString("last_name"));
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
