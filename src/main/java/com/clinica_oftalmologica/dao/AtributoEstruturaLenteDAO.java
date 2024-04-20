package com.clinica_oftalmologica.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.clinica_oftalmologica.model.AtributoEstruturaLente;

public class AtributoEstruturaLenteDAO extends DBConnection {

    private static final String INSERT_ATRIBUTOS_ESTRUTURA_LENTE_SQL = "INSERT INTO atributos_estrutura_lente (descricao, lado_olho) VALUES (?, ?);";
    private static final String SELECT_ALL_ATRIBUTOS_ESTRUTURA_LENTE_SQL = "SELECT * FROM atributos_estrutura_lente;";
    private static final String SELECT_ATRIBUTOS_ESTRUTURA_LENTE_SQL = "SELECT id, descricao, lado_olho FROM atributos_estrutura_lente WHERE id = ?";
    private static final String UPDATE_ATRIBUTOS_ESTRUTURA_LENTE_SQL = "UPDATE atributos_estrutura_lente SET descricao = ?, lado_olho = ? WHERE id = ?;";
    private static final String DELETE_ATRIBUTOS_ESTRUTURA_LENTE_SQL = "DELETE FROM atributos_estrutura_lente WHERE id = ?;";
    private static final String COUNT_ATRIBUTOS_ESTRUTURA_LENTE_SQL = "SELECT count(1) FROM atributos_estrutura_lente;";

    public void insert(AtributoEstruturaLente entity) {
        try (PreparedStatement preparedStatement = prepareSQL(INSERT_ATRIBUTOS_ESTRUTURA_LENTE_SQL)) {
            preparedStatement.setString(1, entity.getDescricao());
            preparedStatement.setString(2, entity.getLadoOlho());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<AtributoEstruturaLente> selectAll() {
        List<AtributoEstruturaLente> entities = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepareSQL(SELECT_ALL_ATRIBUTOS_ESTRUTURA_LENTE_SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String descricao = resultSet.getString("descricao");
                String ladoOlho = resultSet.getString("lado_olho");
                entities.add(new AtributoEstruturaLente(id, descricao, ladoOlho));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entities;
    }

    public AtributoEstruturaLente select(int id) {
        AtributoEstruturaLente entity = null;
        try (PreparedStatement preparedStatement = prepareSQL(SELECT_ATRIBUTOS_ESTRUTURA_LENTE_SQL)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String descricao = resultSet.getString("descricao");
                String ladoOlho = resultSet.getString("lado_olho");
                entity = new AtributoEstruturaLente(id, descricao, ladoOlho);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entity;
    }

    public boolean update(AtributoEstruturaLente entity) {
        boolean updated = false;
        try (PreparedStatement statement = prepareSQL(UPDATE_ATRIBUTOS_ESTRUTURA_LENTE_SQL)) {
            statement.setString(1, entity.getDescricao());
            statement.setString(2, entity.getLadoOlho());
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
        try (PreparedStatement statement = prepareSQL(DELETE_ATRIBUTOS_ESTRUTURA_LENTE_SQL)) {
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
        try (PreparedStatement preparedStatement = prepareSQL(COUNT_ATRIBUTOS_ESTRUTURA_LENTE_SQL)) {
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
