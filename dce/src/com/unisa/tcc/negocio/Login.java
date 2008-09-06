package com.unisa.tcc.negocio;

import java.sql.SQLException;

import com.unisa.tcc.bean.ProfessorBean;
import com.unisa.tcc.dao.LoginDAO;
import com.unisa.tcc.form.ProfessorForm;
import com.unisa.tcc.to.ProfessorTo;

public class Login {
	
	public boolean autenticarUsuario(Object objetoUsuario){
		ProfessorTo professorBo = new ProfessorTo();
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
