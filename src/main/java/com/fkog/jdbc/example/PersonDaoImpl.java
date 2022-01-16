package com.fkog.jdbc.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonDaoImpl {
	private final Connection connection;

    private PersonDaoImpl(Connection connection) {
        this.connection = connection;
    }

    public static PersonDaoImpl getInstance(Connection connection) {
        return new PersonDaoImpl(connection);
    }
    
    public Optional<PersonImpl> getById(int id) throws SQLException {
        String query = "SELECT id, name FROM persons WHERE id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.first()) {

            PersonImpl result = new PersonImpl(resultSet.getInt("id"),
                resultSet.getString("name"));

            return Optional.of(result);
        } else {
            return Optional.empty();
        }

    }

    public void insert(Person PersonImpl) throws SQLException {

        String query = "INSERT INTO persons(id, name) VALUES( ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, PersonImpl.getId());
        preparedStatement.setString(2, PersonImpl.getName());
        preparedStatement.executeUpdate();

    }

    public void insert(List<PersonImpl> personEntities) throws SQLException {
        String query = "INSERT INTO persons(id, name) VALUES( ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        for (Person PersonImpl : personEntities) {
            preparedStatement.setInt(1, PersonImpl.getId());
            preparedStatement.setString(2, PersonImpl.getName());
            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();

    }

    public void update(Person PersonImpl) throws SQLException {
        String query = "UPDATE persons SET name = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, PersonImpl.getName());
        preparedStatement.setInt(2, PersonImpl.getId());
        preparedStatement.executeUpdate();
    }

    public void deleteById(int id) throws SQLException {
        String query = "DELETE FROM persons WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

    public List<PersonImpl> getAll() throws SQLException {
        String query = "SELECT id, name FROM persons";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<PersonImpl> result = new ArrayList<>();
        while (resultSet.next()) {
            result.add(new PersonImpl(resultSet.getInt("id"), resultSet.getString("name")));
        }
        return result;
    }
}
