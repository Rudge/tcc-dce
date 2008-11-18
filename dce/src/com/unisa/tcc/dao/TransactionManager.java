package com.unisa.tcc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.unisa.tcc.propriedades.DceException;

public class TransactionManager {
	
	protected static Connection conn = null;
	
	protected static Connection getConn() throws DceException{
		try {
			carregarDriver();
			conn = obtemConexao();
			conn.setAutoCommit(false);
		} catch (ClassNotFoundException e) {
			throw new DceException("Erro ao carregar o driver do Mysql!");
		} catch (SQLException e) {
			throw new DceException("Erro na obtenção da conexão com o banco!");
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
		//return DriverManager.getConnection("jdbc:mysql://localhost:3307/rudge", "rudge", "My$&rverjava2008");
		//return DriverManager.getConnection("jdbc:mysql://localhost:3307/dce", "dce", "dce2008");
		return DriverManager.getConnection("jdbc:mysql://localhost:3308/tcc", "root", "root");
	}
	
}
