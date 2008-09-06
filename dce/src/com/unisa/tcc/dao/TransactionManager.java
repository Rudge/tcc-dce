package com.unisa.tcc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TransactionManager {
	
	public static Connection conectar(){
		Connection conn = null;
		
		try {
			carregarDriver();
			conn = obtemConexao();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	private static void carregarDriver() throws ClassNotFoundException {
		//Class.forName("net.sourceforge.jtds.jdbc.Driver");
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		Class.forName("org.gjt.mm.mysql.Driver");
	}
	private static Connection obtemConexao() throws SQLException {
		//return DriverManager.getConnection("jdbc:jtds:sqlserver://CHICOBENTO/ra1262009","aluno","aluno");
		//return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/tcc", "root", "root");
	}
}
