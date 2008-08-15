package com.unisa.tcc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDAO {
	
	public static Connection conectar(){
		Connection conn = null;
		
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			conn = 
				DriverManager.getConnection("jdbc:mysql://localhost:3306/tcc", "root", "root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
