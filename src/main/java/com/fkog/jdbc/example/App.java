package com.fkog.jdbc.example;

import java.sql.SQLException;

import com.fkog.jdbc.BasicConnectionPool;

public class App {
	public static void main(String[] args) throws SQLException {
		BasicConnectionPool.create(
				"jdbc:mysql://127.0.0.1:3306/yourvallet?createDatabaseIfNotExist=true&autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true",
				"root", "Terna@1209");
		
		
	}
}
