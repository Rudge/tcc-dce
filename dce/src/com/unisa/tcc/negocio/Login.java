package com.unisa.tcc.negocio;

import java.sql.SQLException;

import com.unisa.tcc.dao.LoginDAO;




public class Login {
	
	public String getNome(){
		
		String str = "DEU ERRO";
		
		try {
			str = LoginDAO.getNome().toUpperCase();	
		} catch (SQLException e) {
			// TODO Tratar excessão e SQLException
			e.printStackTrace();
		}
		
		return str;
	}
	public boolean auntenticar() {
		return true;
	}
}
