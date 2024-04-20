package com.clinica_oftalmologica.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.clinica_oftalmologica.model.EspecificacaoLente;

public class EspecificacaoLenteDAO extends DBConnection {

    private static final String INSERT_ESPECIFICACOES_LENTE_SQL = "INSERT INTO especificacoes_lente (valor, id_estrutura_lente, id_atributo_estrutura_lente) VALUES (?, ?, ?);";
    private static final String SELECT_ALL_ESPECIFICACOES_LENTE_SQL = "SELECT * FROM especificacoes_lente;";
    private static final String SELECT_ESPECIFICACOES_LENTE_SQL = "SELECT id, valor, id_estrutura_lente, id_atributo_estrutura_lente FROM especificacoes_lente WHERE id = ?";
    private static final String UPDATE_ESPECIFICACOES_LENTE_SQL = "UPDATE especificacoes_lente SET valor = ?, id_estrutura_lente = ?, id_atributo_estrutura_lente = ? WHERE id = ?;";
    private static final String DELETE_ESPECIFICACOES_LENTE_SQL = "DELETE FROM especificacoes_lente WHERE id = ?;";
    private static final String COUNT_ESPECIFICACOES_LENTE_SQL = "SELECT count(1) FROM especificacoes_lente;";

    public void insert(EspecificacaoLente entity) {
        try (PreparedStatement preparedStatement = prepareSQL(INSERT_ESPECIFICACOES_LENTE_SQL)) {
            preparedStatement.setFloat(1, entity.getValor());
            preparedStatement.setInt(2, entity.getIdEstruturaLente());
            preparedStatement.setInt(3, entity.getIdAtributoEstruturaLente());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<EspecificacaoLente> selectAll() {
        List<EspecificacaoLente> entities = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepareSQL(SELECT_ALL_ESPECIFICACOES_LENTE_SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                Float valor = resultSet.getFloat("valor");
                Integer idEstruturaLente = resultSet.getInt("id_estrutura_lente");
                Integer idAtributoEstruturaLente = resultSet.getInt("id_atributo_estrutura_lente");
                entities.add(new EspecificacaoLente(id, valor, idEstruturaLente, idAtributoEstruturaLente));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entities;
    }

    public EspecificacaoLente select(int id) {
        EspecificacaoLente entity = null;
        try (PreparedStatement preparedStatement = prepareSQL(SELECT_ESPECIFICACOES_LENTE_SQL)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Float valor = resultSet.getFloat("valor");
                Integer idEstruturaLente = resultSet.getInt("id_estrutura_lente");
                Integer idAtributoEstruturaLente = resultSet.getInt("id_atributo_estrutura_lente");
                entity = new EspecificacaoLente(id, valor, idEstruturaLente, idAtributoEstruturaLente);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entity;
    }

    public boolean update(EspecificacaoLente entity) {
        boolean updated = false;
        try (PreparedStatement statement = prepareSQL(UPDATE_ESPECIFICACOES_LENTE_SQL)) {
            statement.setFloat(1, entity.getId());
            statement.setInt(2, entity.getIdEstruturaLente());
            statement.setInt(3, entity.getIdAtributoEstruturaLente());
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
        try (PreparedStatement statement = prepareSQL(DELETE_ESPECIFICACOES_LENTE_SQL)) {
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
        try (PreparedStatement preparedStatement = prepareSQL(COUNT_ESPECIFICACOES_LENTE_SQL)) {
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
