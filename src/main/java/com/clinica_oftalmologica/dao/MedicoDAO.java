package com.clinica_oftalmologica.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.clinica_oftalmologica.model.Medico;

public class MedicoDAO extends DBConnection {

    private static final String INSERT_MEDICOS_SQL = "INSERT INTO medicos (nome, crm) VALUES (?, ?);";
    private static final String SELECT_ALL_MEDICOS_SQL = "SELECT * FROM medicos;";
    private static final String SELECT_MEDICOS_SQL = "SELECT id, nome, crm FROM medicos WHERE id = ?";
    private static final String UPDATE_MEDICOS_SQL = "UPDATE medicos SET nome = ?, crm = ? WHERE id = ?;";
    private static final String DELETE_MEDICOS_SQL = "DELETE FROM medicos WHERE id = ?;";
    private static final String COUNT_MEDICOS_SQL = "SELECT count(1) FROM medicos;";

    public void insert(Medico entity) {
        try (PreparedStatement preparedStatement = prepareSQL(INSERT_MEDICOS_SQL)) {
            preparedStatement.setString(1, entity.getNome());
            preparedStatement.setString(2, entity.getCrm());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Medico> selectAll() {
        List<Medico> entities = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepareSQL(SELECT_ALL_MEDICOS_SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String crm = resultSet.getString("crm");
                entities.add(new Medico(id, nome, crm));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entities;
    }

    public Medico select(int id) {
        Medico entity = null;
        try (PreparedStatement preparedStatement = prepareSQL(SELECT_MEDICOS_SQL)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String crm = resultSet.getString("crm");
                entity = new Medico(id, nome, crm);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entity;
    }

    public boolean update(Medico entity) {
        boolean updated = false;
        try (PreparedStatement statement = prepareSQL(UPDATE_MEDICOS_SQL)) {
            statement.setString(1, entity.getNome());
            statement.setString(2, entity.getCrm());
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
        try (PreparedStatement statement = prepareSQL(DELETE_MEDICOS_SQL)) {
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
        try (PreparedStatement preparedStatement = prepareSQL(COUNT_MEDICOS_SQL)) {
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
