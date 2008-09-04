package com.unisa.tcc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.unisa.tcc.bean.ProfessorBean;
import com.unisa.tcc.bo.ProfessorBo;

public class LoginDAO extends ConnectionDAO {
	public ProfessorBo autenticarProfessor(ProfessorBean professorBean) throws SQLException{
		StringBuffer query = new StringBuffer();
		ProfessorBo professorBo = new ProfessorBo();
		query.append("SELECT " +
						   "IDPROFESSOR, NOME, LOGIN, SENHA " +
					 "FROM PROFESSOR " +
					 "WHERE LOGIN = ? ");
		PreparedStatement stmt = conectar().prepareStatement(query.toString());
		stmt.setString(1, professorBean.getUsuario());
		ResultSet rs = stmt.executeQuery();
		while(rs.next()){
			professorBo.setIdProfessor(rs.getInt("IDPROFESSOR"));
			professorBo.setNome(rs.getString("NOME"));
			professorBo.setUsuario(rs.getString("LOGIN"));
			professorBo.setSenha(rs.getString("SENHA"));
		}
		return professorBo;
	}
	public ProfessorBean autenticarAdministrador(ProfessorBean professorBean) throws SQLException{
		StringBuffer query = new StringBuffer();
		query.append("SELECT " +
						   "IDPROFESSOR, NOME, USUARIO, SENHA " +
					 "FROM PROFESSOR " +
					 "WHERE USUARIO = ? ");
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
}
