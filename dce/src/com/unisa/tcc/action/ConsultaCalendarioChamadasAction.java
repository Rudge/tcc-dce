package com.unisa.tcc.action;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unisa.tcc.form.ChamadaForm;
import com.unisa.tcc.form.ProfessorForm;
import com.unisa.tcc.propriedades.Constantes;
import com.unisa.tcc.propriedades.DceException;
import com.unisa.tcc.to.ChamadaTo;

public class ConsultaCalendarioChamadasAction implements InterfaceActionNegocio{
	
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response) throws DceException {
		try{
			ProfessorForm professor = (ProfessorForm) request.getSession().getAttribute("usuario");
			String data = null;
			if(request.getParameter("dataEscolhida") != null){
				data = (String) request.getParameter("dataEscolhida");
			}else{
				data = (String) request.getSession().getAttribute("dataEscolhida");
			}
			List<ChamadaTo> listaChamadasTo = controladorChamada.consultarChamadasPorData(professor.getId(), data);
			List<ChamadaForm> listaChamadasForm = controladorChamada.tranfListaChamadaTo(listaChamadasTo);
			request.setAttribute("listaChamadas", listaChamadasForm);
			request.getSession().setAttribute("dataEscolhida", data);
			RequestDispatcher dispatcher = request.getRequestDispatcher(Constantes.PAGINA_CALENDARIO_CHAMADA);
			dispatcher.forward(request, response);
			
		}catch(Exception e){
			throw new DceException("Erro na requisição ou resposta da consulta de chamadas!");
		}
	}
}
