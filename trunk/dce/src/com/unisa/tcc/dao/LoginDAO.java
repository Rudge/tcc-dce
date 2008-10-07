package com.unisa.tcc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.unisa.tcc.bean.ProfessorBean;
import com.unisa.tcc.to.ProfessorTo;

public class LoginDAO extends TransactionManager {
	
	public ProfessorTo autenticarProfessor(ProfessorBean professorBean) throws SQLException{
		StringBuffer query = new StringBuffer();
		ProfessorTo professorTo = new ProfessorTo();
		try{
			conn = getConn();
			query.append("SELECT " +
							   "IDPROFESSOR, NOME, LOGIN, SENHA " +
						 "FROM PROFESSOR " +
						 "WHERE LOGIN = ? ");
			PreparedStatement stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, professorBean.getUsuario());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				professorTo.setId(rs.getInt("IDPROFESSOR"));
				professorTo.setNome(rs.getString("NOME"));
				professorTo.setUsuario(rs.getString("LOGIN"));
				professorTo.setSenha(rs.getString("SENHA"));
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e){
			professorTo = preencherProfessor();
		}
		return professorTo;
	}
	
	public ProfessorBean autenticarAdministrador(ProfessorBean professorBean) throws SQLException{
		StringBuffer query = new StringBuffer();
		query.append("SELECT " +
						   "IDPROFESSOR, NOME, LOGIN, SENHA " +
					 "FROM PROFESSOR " +
					 "WHERE LOGIN = ? ");
		PreparedStatement stmt = getConn().prepareStatement(query.toString());
		stmt.setString(1, professorBean.getUsuario());
		ResultSet rs = stmt.executeQuery(query.toString());
		while(rs.next()){
			professorBean.setId(rs.getInt("IDPROFESSOR"));
			professorBean.setNome(rs.getString("NOME"));
			professorBean.setSenha(rs.getString("SENHA"));
		}
		return professorBean;
	}
	public ProfessorTo preencherProfessor(){
		ProfessorTo professorTo = new ProfessorTo();
		professorTo.setUsuario("jose");
		professorTo.setSenha("1234");
		professorTo.setNome("Jos� Ant�nio Silva");
		return professorTo;		
	}
}
