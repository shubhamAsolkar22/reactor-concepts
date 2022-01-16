package com.fkog.jdbc.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonDaoImpl implements PersonDao {
	private final Connection connection;

	private PersonDaoImpl(Connection connection) {
		this.connection = connection;
	}

	public static PersonDao getInstance(Connection connection) {
		return new PersonDaoImpl(connection);
	}

	@Override
	public Optional<Person> getById(int id) throws SQLException {
		String query = "SELECT id, name FROM persons WHERE id = ?";

		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.first()) {

			PersonImpl result = new PersonImpl(resultSet.getInt("id"), resultSet.getString("name"));

			return Optional.of(result);
		} else {
			return Optional.empty();
		}

	}

	@Override
	public void insert(Person PersonImpl) throws SQLException {

		String query = "INSERT INTO persons(id, name) VALUES( ?, ?)";

		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, PersonImpl.getId());
		preparedStatement.setString(2, PersonImpl.getName());
		boolean autoCommit = connection.getAutoCommit();
		try {
			connection.setAutoCommit(false);
			preparedStatement.executeUpdate();
		} catch (SQLException exc) {
			connection.rollback();
			throw exc;
		} finally {
			connection.setAutoCommit(autoCommit);
		}
	}

	@Override
	public void insert(List<Person> personEntities) throws SQLException {
		String query = "INSERT INTO persons(id, name) VALUES( ?, ?)";

		PreparedStatement preparedStatement = connection.prepareStatement(query);
		for (Person PersonImpl : personEntities) {
			preparedStatement.setInt(1, PersonImpl.getId());
			preparedStatement.setString(2, PersonImpl.getName());
			preparedStatement.addBatch();
		}
		boolean autoCommit = connection.getAutoCommit();
		try {
			preparedStatement.executeBatch();
		} catch (SQLException exc) {
			connection.rollback();
			throw exc;
		} finally {
			connection.setAutoCommit(autoCommit);
		}
	}

	@Override
	public void update(Person person) throws SQLException {
		String query = "UPDATE persons SET name = ? WHERE id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, person.getName());
		preparedStatement.setInt(2, person.getId());
		boolean autoCommit = connection.getAutoCommit();
		try {
		preparedStatement.executeUpdate();
		} catch (SQLException exc) {
			connection.rollback();
			throw exc;
		} finally {
			connection.setAutoCommit(autoCommit);
		}
	}

	@Override
	public void deleteById(int id) throws SQLException {
		String query = "DELETE FROM persons WHERE id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		boolean autoCommit = connection.getAutoCommit();
		try {
		preparedStatement.executeUpdate();
		} catch (SQLException exc) {
			connection.rollback();
			throw exc;
		} finally {
			connection.setAutoCommit(autoCommit);
		}
	}

	@Override
	public List<Person> getAll() throws SQLException {
		String query = "SELECT id, name FROM persons";

		PreparedStatement preparedStatement = connection.prepareStatement(query);
		ResultSet resultSet = preparedStatement.executeQuery();
		List<Person> result = new ArrayList<>();
		while (resultSet.next()) {
			result.add(new PersonImpl(resultSet.getInt("id"), resultSet.getString("name")));
		}
		return result;
	}
}
