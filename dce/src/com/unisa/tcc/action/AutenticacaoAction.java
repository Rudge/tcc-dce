package com.unisa.tcc.action;

import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unisa.tcc.form.ChamadaForm;
import com.unisa.tcc.form.ProfessorForm;
import com.unisa.tcc.negocio.Login;
import com.unisa.tcc.propriedades.Constantes;
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
			if(request.getParameter("tipoUsuario").equals(Constantes.TIPO_PROFESSOR)){
				professorForm.setUsuario(request.getParameter("usuario"));
				professorForm.setSenha(request.getParameter("senha"));
				autenticado = login.autenticarProfessor(professorForm);
				if(autenticado){
					List<ChamadaTo> listaChamadasTo = controladorChamada.consultarChamadasPorData(professorForm.getId(), null);
					List<ChamadaForm>listaChamadasForm = controladorChamada.tranfListaChamadaTo(listaChamadasTo);
					request.setAttribute("listaChamadas", listaChamadasForm);
					request.getSession().setAttribute("usuario", professorForm);
					request.getSession().setAttribute("dataEscolhida", new Date(new java.util.Date().getTime()).toString());
					RequestDispatcher dispatcher = request.getRequestDispatcher(Constantes.PAGINA_CALENDARIO_CHAMADA);
					dispatcher.forward(request, response);
				}else{
					request.setAttribute("msgErro", Constantes.ERRO_USUARIO_SENHA);
					RequestDispatcher dispatcher = request.getRequestDispatcher(Constantes.PAGINA_INDEX);
					dispatcher.forward(request, response);
				}
			}else{
				if(autenticado){
					request.getSession().setAttribute("usuario", professorForm);
					RequestDispatcher dispatcher = request.getRequestDispatcher(Constantes.PAGINA_CALENDARIO_CHAMADA);
					dispatcher.forward(request, response);
				}else{
					request.setAttribute("msgErro", Constantes.ERRO_USUARIO_SENHA);
					RequestDispatcher dispatcher = request.getRequestDispatcher(Constantes.PAGINA_INDEX);
					dispatcher.forward(request, response);
				}
			}
		}catch (Exception e) {
			throw new DceException("Erro na requisi��o ou resposta da p�gina de login!");
		}
	}   
}