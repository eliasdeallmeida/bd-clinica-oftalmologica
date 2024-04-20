package com.clinica_oftalmologica.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.clinica_oftalmologica.model.Especialidade;

public class EspecialidadeDAO extends DBConnection {

    private static final String INSERT_ESPECIALIDADES_SQL = "INSERT INTO especialidades (descricao, conselho) VALUES (?, ?);";
    private static final String SELECT_ALL_ESPECIALIDADES_SQL = "SELECT * FROM especialidades;";
    private static final String SELECT_ESPECIALIDADES_SQL = "SELECT id, descricao, conselho FROM especialidades WHERE id = ?";
    private static final String UPDATE_ESPECIALIDADES_SQL = "UPDATE especialidades SET descricao = ?, conselho = ? WHERE id = ?;";
    private static final String DELETE_ESPECIALIDADES_SQL = "DELETE FROM especialidades WHERE id = ?;";
    private static final String COUNT_ESPECIALIDADES_SQL = "SELECT count(1) FROM especialidades;";

    public void insert(Especialidade entity) {
        try (PreparedStatement preparedStatement = prepareSQL(INSERT_ESPECIALIDADES_SQL)) {
            preparedStatement.setString(1, entity.getDescricao());
            preparedStatement.setString(2, entity.getConselho());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Especialidade> selectAll() {
        List<Especialidade> entities = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepareSQL(SELECT_ALL_ESPECIALIDADES_SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String descricao = resultSet.getString("descricao");
                String conselho = resultSet.getString("conselho");
                entities.add(new Especialidade(id, descricao, conselho));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entities;
    }

    public Especialidade select(int id) {
        Especialidade entity = null;
        try (PreparedStatement preparedStatement = prepareSQL(SELECT_ESPECIALIDADES_SQL)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String descricao = resultSet.getString("descricao");
                String conselho = resultSet.getString("conselho");
                entity = new Especialidade(id, descricao, conselho);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entity;
    }

    public boolean update(Especialidade entity) {
        boolean updated = false;
        try (PreparedStatement statement = prepareSQL(UPDATE_ESPECIALIDADES_SQL)) {
            statement.setString(1, entity.getDescricao());
            statement.setString(2, entity.getConselho());
            statement.setInt(3, entity.getId());
            updated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return updated;
    }

    public boolean delete(int id) {
        boolean deleted = false;
        try (PreparedStatement statement = prepareSQL(DELETE_ESPECIALIDADES_SQL)) {
            statement.setInt(1, id);
            deleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return deleted;
    }

    public Integer count() {
        Integer count = 0;
        try (PreparedStatement preparedStatement = prepareSQL(COUNT_ESPECIALIDADES_SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                count = resultSet.getInt("count");
            }
        } catch (SQLException exception) {
            printSQLException(exception);
        } catch (ClassNotFoundException exception) {
            throw new RuntimeException(exception);
        }
        return count;
    }
}
