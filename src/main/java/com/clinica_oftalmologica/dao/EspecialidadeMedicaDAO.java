package com.clinica_oftalmologica.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.clinica_oftalmologica.model.EspecialidadeMedica;

public class EspecialidadeMedicaDAO extends DBConnection {

    private static final String INSERT_ESPECIALIDADES_MEDICAS_SQL = "INSERT INTO especialidades_medicas (observacao, data_conclusao, id_medico, id_especialidade) VALUES (?, ?, ?, ?);";
    private static final String SELECT_ALL_ESPECIALIDADES_MEDICAS_SQL = "SELECT * FROM especialidades_medicas;";
    private static final String SELECT_ESPECIALIDADES_MEDICAS_SQL = "SELECT id, observacao, data_conclusao, id_medico, id_especialidade FROM especialidades_medicas WHERE id = ?";
    private static final String UPDATE_ESPECIALIDADES_MEDICAS_SQL = "UPDATE especialidades_medicas SET observacao = ?, data_conclusao = ?, id_medico = ?, id_especialidade = ? WHERE id = ?;";
    private static final String DELETE_ESPECIALIDADES_MEDICAS_SQL = "DELETE FROM especialidades_medicas WHERE id = ?;";
    private static final String COUNT_ESPECIALIDADES_MEDICAS_SQL = "SELECT count(1) FROM especialidades_medicas;";

    public void insert(EspecialidadeMedica entity) {
        try (PreparedStatement preparedStatement = prepareSQL(INSERT_ESPECIALIDADES_MEDICAS_SQL)) {
            preparedStatement.setString(1, entity.getObservacao());
            preparedStatement.setDate(2, entity.getDataConclusao());
            preparedStatement.setInt(3, entity.getIdMedico());
            preparedStatement.setInt(4, entity.getIdEspecialidade());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<EspecialidadeMedica> selectAll() {
        List<EspecialidadeMedica> entities = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepareSQL(SELECT_ALL_ESPECIALIDADES_MEDICAS_SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String observacao = resultSet.getString("observacao");
                Date dataConclusao = resultSet.getDate("data_conclusao");
                Integer idMedico = resultSet.getInt("id_medico");
                Integer idEspecialidade = resultSet.getInt("id_especialidade");
                entities.add(new EspecialidadeMedica(id, observacao, dataConclusao, idMedico, idEspecialidade));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entities;
    }

    public EspecialidadeMedica select(int id) {
        EspecialidadeMedica entity = null;
        try (PreparedStatement preparedStatement = prepareSQL(SELECT_ESPECIALIDADES_MEDICAS_SQL)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String observacao = resultSet.getString("observacao");
                Date dataConclusao = resultSet.getDate("data_conclusao");
                Integer idMedico = resultSet.getInt("id_medico");
                Integer idEspecialidade = resultSet.getInt("id_especialidade");
                entity = new EspecialidadeMedica(id, observacao, dataConclusao, idMedico, idEspecialidade);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entity;
    }

    public boolean update(EspecialidadeMedica entity) {
        boolean updated = false;
        try (PreparedStatement statement = prepareSQL(UPDATE_ESPECIALIDADES_MEDICAS_SQL)) {
            statement.setString(1, entity.getObservacao());
            statement.setDate(2, entity.getDataConclusao());
            statement.setInt(3, entity.getIdMedico());
            statement.setInt(4, entity.getIdEspecialidade());
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
        try (PreparedStatement statement = prepareSQL(DELETE_ESPECIALIDADES_MEDICAS_SQL)) {
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
        try (PreparedStatement preparedStatement = prepareSQL(COUNT_ESPECIALIDADES_MEDICAS_SQL)) {
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
