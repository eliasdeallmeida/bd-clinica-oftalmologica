package com.clinica_oftalmologica.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.clinica_oftalmologica.model.ObservacaoLaudo;

public class ObservacaoLaudoDAO extends DBConnection {

    private static final String INSERT_OBSERVACOES_LAUDOS_SQL = "INSERT INTO observacoes_laudos (descricao, id_receita_oculos) VALUES (?, ?);";
    private static final String SELECT_ALL_OBSERVACOES_LAUDOS_SQL = "SELECT * FROM observacoes_laudos;";
    private static final String SELECT_OBSERVACOES_LAUDOS_SQL = "SELECT id, descricao, id_receita_oculos FROM observacoes_laudos WHERE id = ?";
    private static final String UPDATE_OBSERVACOES_LAUDOS_SQL = "UPDATE observacoes_laudos SET descricao = ?, id_receita_oculos = ? WHERE id = ?;";
    private static final String DELETE_OBSERVACOES_LAUDOS_SQL = "DELETE FROM observacoes_laudos WHERE id = ?;";
    private static final String COUNT_OBSERVACOES_LAUDOS_SQL = "SELECT count(1) FROM observacoes_laudos;";

    public void insert(ObservacaoLaudo entity) {
        try (PreparedStatement preparedStatement = prepareSQL(INSERT_OBSERVACOES_LAUDOS_SQL)) {
            preparedStatement.setString(1, entity.getDescricao());
            preparedStatement.setInt(2, entity.getIdReceitaOculos());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ObservacaoLaudo> selectAll() {
        List<ObservacaoLaudo> entities = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepareSQL(SELECT_ALL_OBSERVACOES_LAUDOS_SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String descricao = resultSet.getString("descricao");
                Integer idReceitaOculos = resultSet.getInt("id_receita_oculos");
                entities.add(new ObservacaoLaudo(id, descricao, idReceitaOculos));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entities;
    }

    public ObservacaoLaudo select(int id) {
        ObservacaoLaudo entity = null;
        try (PreparedStatement preparedStatement = prepareSQL(SELECT_OBSERVACOES_LAUDOS_SQL)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String descricao = resultSet.getString("descricao");
                Integer idReceitaOculos = resultSet.getInt("id_receita_oculos");
                entity = new ObservacaoLaudo(id, descricao, idReceitaOculos);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entity;
    }

    public boolean update(ObservacaoLaudo entity) {
        boolean updated = false;
        try (PreparedStatement statement = prepareSQL(UPDATE_OBSERVACOES_LAUDOS_SQL)) {
            statement.setString(1, entity.getDescricao());
            statement.setInt(2, entity.getIdReceitaOculos());
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
        try (PreparedStatement statement = prepareSQL(DELETE_OBSERVACOES_LAUDOS_SQL)) {
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
        try (PreparedStatement preparedStatement = prepareSQL(COUNT_OBSERVACOES_LAUDOS_SQL)) {
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
