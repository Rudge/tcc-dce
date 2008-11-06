package com.unisa.tcc.negocio;

import com.unisa.tcc.bean.ProfessorBean;
import com.unisa.tcc.dao.LoginDAO;
import com.unisa.tcc.form.ProfessorForm;
import com.unisa.tcc.propriedades.DceException;
import com.unisa.tcc.to.ProfessorTo;

public class Login{
	
	private LoginDAO loginDao = new LoginDAO();
	
	public boolean autenticarProfessor(ProfessorForm professorForm) throws DceException{
		ProfessorTo professorTo = new ProfessorTo();
		ProfessorBean professorBean = new ProfessorBean();
		try{
			professorBean.setUsuario(professorForm.getUsuario());
			professorBean.setSenha(professorForm.getSenha());
			professorTo = loginDao.autenticarProfessor(professorBean);
			if(professorBean.getUsuario().equals(professorTo.getUsuario()) && 
			   professorBean.getSenha().equals(professorTo.getSenha())){
					professorForm.setId(professorTo.getId());
					professorForm.setNome(professorTo.getNome());
					return true;
			}else{
				return false;
			}
		}catch (Exception e) {
			return false;
		}
	}
	
	public boolean lembrarSenha() throws DceException {
		return true;
	}
}
