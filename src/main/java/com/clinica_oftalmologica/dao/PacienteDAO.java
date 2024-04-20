package com.clinica_oftalmologica.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.clinica_oftalmologica.model.Paciente;

public class PacienteDAO extends DBConnection {

    private static final String INSERT_PACIENTES_SQL = "INSERT INTO pacientes (nome, cpf, data_nascimento) VALUES (?, ?, ?);";
    private static final String SELECT_ALL_PACIENTES_SQL = "SELECT * FROM pacientes;";
    private static final String SELECT_PACIENTES_SQL = "SELECT id, nome, cpf, data_nascimento FROM pacientes WHERE id = ?";
    private static final String UPDATE_PACIENTES_SQL = "UPDATE pacientes SET nome = ?, cpf = ?, data_nascimento = ? WHERE id = ?;";
    private static final String DELETE_PACIENTES_SQL = "DELETE FROM pacientes WHERE id = ?;";
    private static final String COUNT_PACIENTES_SQL = "SELECT count(1) FROM pacientes;";

    public void insert(Paciente entity) {
        try (PreparedStatement preparedStatement = prepareSQL(INSERT_PACIENTES_SQL)) {
            preparedStatement.setString(1, entity.getNome());
            preparedStatement.setString(2, entity.getCpf());
            preparedStatement.setDate(3, entity.getDataNascimento());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Paciente> selectAll() {
        List<Paciente> entities = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepareSQL(SELECT_ALL_PACIENTES_SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String cpf = resultSet.getString("cpf");
                Date dataNascimento = resultSet.getDate("data_nascimento");
                entities.add(new Paciente(id, nome, cpf, dataNascimento));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entities;
    }

    public Paciente select(int id) {
        Paciente entity = null;
        try (PreparedStatement preparedStatement = prepareSQL(SELECT_PACIENTES_SQL)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String cpf = resultSet.getString("cpf");
                Date dataNascimento = resultSet.getDate("data_nascimento");
                entity = new Paciente(id, nome, cpf, dataNascimento);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entity;
    }

    public boolean update(Paciente entity) {
        boolean updated = false;
        try (PreparedStatement statement = prepareSQL(UPDATE_PACIENTES_SQL)) {
            statement.setString(1, entity.getNome());
            statement.setString(2, entity.getCpf());
            statement.setDate(3, entity.getDataNascimento());
            statement.setInt(4, entity.getId());
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
        try (PreparedStatement statement = prepareSQL(DELETE_PACIENTES_SQL)) {
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
        try (PreparedStatement preparedStatement = prepareSQL(COUNT_PACIENTES_SQL)) {
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
