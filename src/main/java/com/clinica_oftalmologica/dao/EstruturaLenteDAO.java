package com.clinica_oftalmologica.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.clinica_oftalmologica.model.EstruturaLente;

public class EstruturaLenteDAO extends DBConnection {

    private static final String INSERT_ESTRUTURAS_LENTES_SQL = "INSERT INTO estruturas_lentes (tipo_correcao, distancia_pupilar, id_receita_oculos) VALUES (?, ?, ?);";
    private static final String SELECT_ALL_ESTRUTURAS_LENTES_SQL = "SELECT * FROM estruturas_lentes;";
    private static final String SELECT_ESTRUTURAS_LENTES_SQL = "SELECT id, tipo_correcao, distancia_pupilar, id_receita_oculos FROM estruturas_lentes WHERE id = ?";
    private static final String UPDATE_ESTRUTURAS_LENTES_SQL = "UPDATE estruturas_lentes SET tipo_correcao = ?, distancia_pupilar = ?, id_receita_oculos = ? WHERE id = ?;";
    private static final String DELETE_ESTRUTURAS_LENTES_SQL = "DELETE FROM estruturas_lentes WHERE id = ?;";
    private static final String COUNT_ESTRUTURAS_LENTES_SQL = "SELECT count(1) FROM estruturas_lentes;";

    public void insert(EstruturaLente entity) {
        try (PreparedStatement preparedStatement = prepareSQL(INSERT_ESTRUTURAS_LENTES_SQL)) {
            preparedStatement.setString(1, entity.getTipoCorrecao());
            preparedStatement.setInt(2, entity.getDistanciaPupilar());
            preparedStatement.setInt(3, entity.getIdReceitaOculos());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<EstruturaLente> selectAll() {
        List<EstruturaLente> entities = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepareSQL(SELECT_ALL_ESTRUTURAS_LENTES_SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String tipoCorrecao = resultSet.getString("tipo_correcao");
                Integer distanciaPupilar = resultSet.getInt("distancia_pupilar");
                Integer idReceitaOculos = resultSet.getInt("id_receita_oculos");
                entities.add(new EstruturaLente(id, tipoCorrecao, distanciaPupilar, idReceitaOculos));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entities;
    }

    public EstruturaLente select(int id) {
        EstruturaLente entity = null;
        try (PreparedStatement preparedStatement = prepareSQL(SELECT_ESTRUTURAS_LENTES_SQL)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String tipoCorrecao = resultSet.getString("tipo_correcao");
                Integer distanciaPupilar = resultSet.getInt("distancia_pupilar");
                Integer idReceitaOculos = resultSet.getInt("id_receita_oculos");
                entity = new EstruturaLente(id, tipoCorrecao, distanciaPupilar, idReceitaOculos);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entity;
    }

    public boolean update(EstruturaLente entity) {
        boolean updated = false;
        try (PreparedStatement statement = prepareSQL(UPDATE_ESTRUTURAS_LENTES_SQL)) {
            statement.setString(1, entity.getTipoCorrecao());
            statement.setInt(2, entity.getDistanciaPupilar());
            statement.setInt(3, entity.getIdReceitaOculos());
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
        try (PreparedStatement statement = prepareSQL(DELETE_ESTRUTURAS_LENTES_SQL)) {
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
        try (PreparedStatement preparedStatement = prepareSQL(COUNT_ESTRUTURAS_LENTES_SQL)) {
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
