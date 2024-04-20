package com.clinica_oftalmologica.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.clinica_oftalmologica.model.ConsultaMedica;

public class ConsultaMedicaDAO extends DBConnection {

    private static final String INSERT_CONSULTAS_MEDICAS_SQL = "INSERT INTO consultas_medicas (assinatura, data_consulta, id_medico, id_paciente) VALUES (?, ?, ?, ?);";
    private static final String SELECT_ALL_CONSULTAS_MEDICAS_SQL = "SELECT * FROM consultas_medicas;";
    private static final String SELECT_CONSULTAS_MEDICAS_SQL = "SELECT id, assinatura, data_consulta, id_medico, id_paciente FROM consultas_medicas WHERE id = ?";
    private static final String UPDATE_CONSULTAS_MEDICAS_SQL = "UPDATE consultas_medicas SET assinatura = ?, data_consulta = ?, id_medico = ?, id_paciente = ? WHERE id = ?;";
    private static final String DELETE_CONSULTAS_MEDICAS_SQL = "DELETE FROM consultas_medicas WHERE id = ?;";
    private static final String COUNT_CONSULTAS_MEDICAS_SQL = "SELECT count(1) FROM consultas_medicas;";

    public void insert(ConsultaMedica entity) {
        try (PreparedStatement preparedStatement = prepareSQL(INSERT_CONSULTAS_MEDICAS_SQL)) {
            preparedStatement.setString(1, entity.getAssinatura());
            preparedStatement.setDate(2, entity.getDataConsulta());
            preparedStatement.setInt(3, entity.getIdMedico());
            preparedStatement.setInt(4, entity.getIdPaciente());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ConsultaMedica> selectAll() {
        List<ConsultaMedica> entities = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepareSQL(SELECT_ALL_CONSULTAS_MEDICAS_SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String assinatura = resultSet.getString("assinatura");
                Date dataConsulta = resultSet.getDate("data_consulta");
                Integer idMedico = resultSet.getInt("id_medico");
                Integer idPaciente = resultSet.getInt("id_paciente");
                entities.add(new ConsultaMedica(id, assinatura, dataConsulta, idMedico, idPaciente));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entities;
    }

    public ConsultaMedica select(int id) {
        ConsultaMedica entity = null;
        try (PreparedStatement preparedStatement = prepareSQL(SELECT_CONSULTAS_MEDICAS_SQL)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String assinatura = resultSet.getString("assinatura");
                Date dataConsulta = resultSet.getDate("data_consulta");
                Integer idMedico = resultSet.getInt("id_medico");
                Integer idPaciente = resultSet.getInt("id_paciente");
                entity = new ConsultaMedica(id, assinatura, dataConsulta, idMedico, idPaciente);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entity;
    }

    public boolean update(ConsultaMedica entity) {
        boolean updated = false;
        try (PreparedStatement statement = prepareSQL(UPDATE_CONSULTAS_MEDICAS_SQL)) {
            statement.setString(1, entity.getAssinatura());
            statement.setDate(2, entity.getDataConsulta());
            statement.setInt(3, entity.getIdMedico());
            statement.setInt(4, entity.getIdPaciente());
            statement.setInt(5, entity.getId());
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
        try (PreparedStatement statement = prepareSQL(DELETE_CONSULTAS_MEDICAS_SQL)) {
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
        try (PreparedStatement preparedStatement = prepareSQL(COUNT_CONSULTAS_MEDICAS_SQL)) {
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
