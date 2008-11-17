package com.unisa.tcc.action;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unisa.tcc.form.ChamadaForm;
import com.unisa.tcc.form.ProfessorForm;
import com.unisa.tcc.negocio.Login;
import com.unisa.tcc.propriedades.DceException;
import com.unisa.tcc.to.ChamadaTo;


 public class AutenticacaoAction implements InterfaceActionNegocio {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response) throws DceException {
		// TODO Auto-generated method stub
		try{
			Login login = new Login();
			boolean autenticado = false;
			ProfessorForm professorForm = new ProfessorForm();
			if(request.getParameter("tipoUsuario").equals("professor")){
				professorForm.setUsuario(request.getParameter("usuario"));
				professorForm.setSenha(request.getParameter("senha"));
				autenticado = login.autenticarProfessor(professorForm);
				if(autenticado){
					List<ChamadaTo> listaChamadasTo = controladorChamada.consultarChamadasPorData(professorForm.getId(), null);
					List<ChamadaForm>listaChamadasForm = controladorChamada.tranfListaChamadaTo(listaChamadasTo);
					request.setAttribute("listaChamadas", listaChamadasForm);
					request.getSession().setAttribute("usuario", professorForm);
					RequestDispatcher dispatcher = request.getRequestDispatcher("/webpages/calendarioConsultaChamada.jsp");
					dispatcher.forward(request, response);
				}else{
					request.setAttribute("msgErro", "Usu�rio ou senha inv�lidos!");
					RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
					dispatcher.forward(request, response);
				}
			}else{
				if(autenticado){
					request.getSession().setAttribute("usuario", professorForm);
					RequestDispatcher dispatcher = request.getRequestDispatcher("/webpages/calendarioConsultaChamada.jsp");
					dispatcher.forward(request, response);
				}else{
					request.setAttribute("msgErro", "Usu�rio ou senha inv�lidos!");
					RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
					dispatcher.forward(request, response);
				}
			}
		}catch (Exception e) {
			throw new DceException("Erro na requisi��o ou resposta da p�gina de login!");
		}
	}   
}