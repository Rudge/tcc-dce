package com.unisa.tcc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDAO {
	public static String getNome() throws SQLException{
		Statement stmt = ConnectionDAO.conectar().createStatement();
		ResultSet rs = stmt.executeQuery("SELECT nome FROM hello");
		rs.next();
		return rs.getString("nome");
	}
}
