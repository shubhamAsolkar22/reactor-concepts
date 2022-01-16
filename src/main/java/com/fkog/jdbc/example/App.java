package com.fkog.jdbc.example;

import java.sql.Connection;
import java.sql.SQLException;

import com.fkog.jdbc.BasicConnectionPool;
import com.fkog.jdbc.ConnectionPool;

public class App {
	public static void main(String[] args) throws Exception {
		ConnectionPool pool = BasicConnectionPool.create(
				"jdbc:mysql://127.0.0.1:3306/yourvallet?createDatabaseIfNotExist=true&autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true",
				"root", "Terna@1209");
		
		PersonDao dao = PersonDaoImpl.getInstance(pool.getConnection());
		Person p = new PersonImpl(1,"shubham8");
//		dao.insert(p);
		dao.update(p);
		pool.shutdown();
	}
}
