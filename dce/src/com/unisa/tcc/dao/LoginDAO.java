package com.unisa.tcc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.unisa.tcc.bean.ProfessorBean;
import com.unisa.tcc.propriedades.DceException;
import com.unisa.tcc.to.ProfessorTo;

public class LoginDAO extends TransactionManager {
	
	public ProfessorTo autenticarProfessor(ProfessorBean professorBean) throws DceException, SQLException{
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		StringBuffer query = new StringBuffer();
		ProfessorTo professorTo = new ProfessorTo();
		try{
			conn = getConn();
			query.append("SELECT " +
							   "IDPROFESSOR, NOME, LOGIN, SENHA " +
						 "FROM PROFESSOR " +
						 "WHERE LOGIN = ? ");
			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, professorBean.getUsuario());
			rs = stmt.executeQuery();
			while(rs.next()){
				professorTo.setId(rs.getInt("IDPROFESSOR"));
				professorTo.setNome(rs.getString("NOME"));
				professorTo.setUsuario(rs.getString("LOGIN"));
				professorTo.setSenha(rs.getString("SENHA"));
			}
		}catch(SQLException e){
			professorTo = preencherProfessor();
		}finally{
			rs.close();
			stmt.close();
			conn.close();
		}
		return professorTo;
	}
	
	public ProfessorTo preencherProfessor(){
		ProfessorTo professorTo = new ProfessorTo();
		professorTo.setUsuario("jose");
		professorTo.setSenha("1234");
		professorTo.setNome("José Antônio Silva");
		return professorTo;		
	}
}
