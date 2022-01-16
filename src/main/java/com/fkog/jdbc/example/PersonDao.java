package com.fkog.jdbc.example;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface PersonDao {

	Optional<Person> getById(int id) throws SQLException;

	void insert(Person person) throws SQLException;

	void insert(List<Person> personList) throws SQLException;

	void update(Person person) throws SQLException;

	void deleteById(int id) throws SQLException;

	List<Person> getAll() throws SQLException;

}