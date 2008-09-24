package com.unisa.tcc.negocio;

import com.unisa.tcc.bean.ProfessorBean;
import com.unisa.tcc.dao.LoginDAO;
import com.unisa.tcc.form.ProfessorForm;
import com.unisa.tcc.to.ProfessorTo;

public class Login{
	
	public boolean autenticarUsuario(Object objetoUsuario){
		ProfessorTo professorTo = new ProfessorTo();
		ProfessorBean professorBean = new ProfessorBean();
		LoginDAO loginDao = new LoginDAO();
		
		try{
			if(objetoUsuario instanceof ProfessorForm){
				ProfessorForm professorForm= (ProfessorForm) objetoUsuario;
				professorBean.setUsuario(professorForm.getUsuario());
				professorBean.setSenha(professorForm.getSenha());
				professorTo = loginDao.autenticarProfessor(professorBean);
				if(professorBean.getUsuario().equals(professorTo.getUsuario()) && 
				   professorBean.getSenha().equals(professorTo.getSenha())){
					return true;
				}else{
					return false;
				}
			}else{
				return false;
			}
		}catch (Exception e) {
			return false;
		}
	}
}
