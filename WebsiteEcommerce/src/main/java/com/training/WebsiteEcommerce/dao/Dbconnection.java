package com.training.WebsiteEcommerce.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;





public class Dbconnection {

	private static Dbconnection db;
	private Connection connection;

	private Dbconnection() {

	}

	public static Dbconnection getDb() {
		if(db==null) {
			synchronized(Dbconnection.class){
				if(db==null) {
					db=new Dbconnection();
				}
			}
		}
		return db;
	}

	public Connection getConnection() throws SQLException  {
		final String url="jdbc:postgresql://localhost:5432/Dbtest";
		final String userName="postgres";
		final String password="root"; 
		connection=DriverManager.getConnection(url,userName,password);
		return connection;
	}
}
