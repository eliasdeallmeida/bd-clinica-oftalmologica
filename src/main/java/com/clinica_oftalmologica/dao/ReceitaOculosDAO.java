package com.clinica_oftalmologica.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.clinica_oftalmologica.model.ReceitaOculos;

public class ReceitaOculosDAO extends DBConnection {

    private static final String INSERT_RECEITAS_OCULOS_SQL = "INSERT INTO receitas_oculos (detalhamento, id_consulta_medica) VALUES (?, ?);";
    private static final String SELECT_ALL_RECEITAS_OCULOS_SQL = "SELECT * FROM receitas_oculos;";
    private static final String SELECT_RECEITAS_OCULOS_SQL = "SELECT id, detalhamento, id_consulta_medica FROM receitas_oculos WHERE id = ?";
    private static final String UPDATE_RECEITAS_OCULOS_SQL = "UPDATE receitas_oculos SET detalhamento = ?, id_consulta_medica = ? WHERE id = ?;";
    private static final String DELETE_RECEITAS_OCULOS_SQL = "DELETE FROM receitas_oculos WHERE id = ?;";
    private static final String COUNT_RECEITAS_OCULOS_SQL = "SELECT count(1) FROM receitas_oculos;";

    public void insert(ReceitaOculos entity) {
        try (PreparedStatement preparedStatement = prepareSQL(INSERT_RECEITAS_OCULOS_SQL)) {
            preparedStatement.setString(1, entity.getDetalhamento());
            preparedStatement.setInt(2, entity.getIdConsultaMedica());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ReceitaOculos> selectAll() {
        List<ReceitaOculos> entities = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepareSQL(SELECT_ALL_RECEITAS_OCULOS_SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String observacao = resultSet.getString("detalhamento");
                Integer idConsultaMedica = resultSet.getInt("id_consulta_medica");
                entities.add(new ReceitaOculos(id, observacao, idConsultaMedica));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entities;
    }

    public ReceitaOculos select(int id) {
        ReceitaOculos entity = null;
        try (PreparedStatement preparedStatement = prepareSQL(SELECT_RECEITAS_OCULOS_SQL)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String observacao = resultSet.getString("detalhamento");
                Integer idConsultaMedica = resultSet.getInt("id_consulta_medica");
                entity = new ReceitaOculos(id, observacao, idConsultaMedica);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entity;
    }

    public boolean update(ReceitaOculos entity) {
        boolean updated = false;
        try (PreparedStatement statement = prepareSQL(UPDATE_RECEITAS_OCULOS_SQL)) {
            statement.setString(1, entity.getDetalhamento());
            statement.setInt(2, entity.getIdConsultaMedica());
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
        try (PreparedStatement statement = prepareSQL(DELETE_RECEITAS_OCULOS_SQL)) {
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
        try (PreparedStatement preparedStatement = prepareSQL(COUNT_RECEITAS_OCULOS_SQL)) {
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
