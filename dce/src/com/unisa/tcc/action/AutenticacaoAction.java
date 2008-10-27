package com.unisa.tcc.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unisa.tcc.form.ProfessorForm;
import com.unisa.tcc.negocio.Login;
import com.unisa.tcc.propriedades.Constantes;
import com.unisa.tcc.propriedades.DceException;


 public class AutenticacaoAction implements InterfaceActionNegocio {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response) throws DceException {
		// TODO Auto-generated method stub
		try{
			Login login = new Login();
			if(request.getParameter("ok") != null && request.getParameter("ok").equals(Constantes.OK)){
				boolean autenticado = false;
				ProfessorForm professorForm = new ProfessorForm();
				if(request.getParameter("tipoUsuario").equals("professor")){
					professorForm.setUsuario(request.getParameter("usuario"));
					professorForm.setSenha(request.getParameter("senha"));
					autenticado = login.autenticarProfessor(professorForm);
				}else{
					
				}
				if(autenticado){
					request.getSession().setAttribute("usuario", professorForm);
					RequestDispatcher dispatcher = request.getRequestDispatcher("/webpages/principal.jsp");
					dispatcher.forward(request, response);
				}else{
					request.setAttribute("erro", "Usuário ou senha inválidos!");
					RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
					dispatcher.forward(request, response);
				}
			}else{
				if(login.lembrarSenha()){
					
				}
	
			}
		}catch (Exception e) {
			throw new DceException("Erro na requisição ou resposta da página de login!");
		}
	}   
}