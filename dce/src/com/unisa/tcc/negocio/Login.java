package com.unisa.tcc.negocio;

import java.sql.SQLException;

import com.unisa.tcc.bean.ProfessorBean;
import com.unisa.tcc.bo.ProfessorBo;
import com.unisa.tcc.dao.LoginDAO;
import com.unisa.tcc.form.ProfessorForm;

public class Login {
	
	public boolean autenticarUsuario(Object objetoUsuario){
		ProfessorBo professorBo = new ProfessorBo();
		ProfessorBean professorBean = new ProfessorBean();
		LoginDAO loginDao = new LoginDAO();
		ProfessorForm professorForm= (ProfessorForm) objetoUsuario;
		professorBean.setUsuario(professorForm.getUsuario());
		professorBean.setSenha(professorForm.getSenha());
		
		try{
		professorBo = loginDao.autenticarProfessor(professorBean);
		}catch (SQLException e) {
			return false;
		}
		if(professorBean.getUsuario().equals(professorBo.getUsuario()) && 
		   professorBean.getSenha().equals(professorBo.getSenha())){
			return true;
		}else{
			return false;
		}
	}
}
