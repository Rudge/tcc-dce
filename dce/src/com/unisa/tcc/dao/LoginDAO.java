package com.unisa.tcc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.unisa.tcc.bean.ProfessorBean;
import com.unisa.tcc.form.ProfessorForm;
import com.unisa.tcc.to.ProfessorTo;

public class LoginDAO extends TransactionManager {
	
	
	
	public ProfessorTo autenticarProfessor(ProfessorBean professorBean) throws SQLException{
		StringBuffer query = new StringBuffer();
		ProfessorTo professorTo = new ProfessorTo();
		try{
			conn = conectar();
			query.append("SELECT " +
							   "IDPROFESSOR, NOME, LOGIN, SENHA " +
						 "FROM PROFESSOR " +
						 "WHERE LOGIN = ? ");
			PreparedStatement stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, professorBean.getUsuario());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				professorTo.setIdProfessor(rs.getInt("IDPROFESSOR"));
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
		PreparedStatement stmt = conectar().prepareStatement(query.toString());
		stmt.setString(1, professorBean.getUsuario());
		ResultSet rs = stmt.executeQuery(query.toString());
		while(rs.next()){
			professorBean.setIdProfessor(rs.getInt("IDPROFESSOR"));
			professorBean.setNome(rs.getString("NOME"));
			professorBean.setSenha(rs.getString("SENHA"));
		}
		return professorBean;
	}
	public ProfessorTo preencherProfessor(){
		ProfessorTo professorTo = new ProfessorTo();
		professorTo.setUsuario("jose");
		professorTo.setSenha("1234");
		professorTo.setNome("José Antônio");
		return professorTo;		
	}
}
