package com.unisa.tcc.action;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unisa.tcc.form.ChamadaForm;
import com.unisa.tcc.form.ProfessorForm;
import com.unisa.tcc.negocio.ControladorChamadas;
import com.unisa.tcc.propriedades.DceException;
import com.unisa.tcc.to.ChamadaTo;

public class ConsultaCalendarioChamadasAction implements InterfaceActionNegocio{
	
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response) throws DceException {
		try{
			ProfessorForm professor = (ProfessorForm) request.getSession().getAttribute("usuario");
			String data = (String) request.getParameter("dataEscolhida");
			ControladorChamadas controladorChamadas = new ControladorChamadas();
			List<ChamadaTo> listaChamadasTo = controladorChamadas.consultarChamadasPorData(professor.getId(), data);
			List<ChamadaForm> listaChamadasForm = controladorChamadas.tranfListaChamadaTo(listaChamadasTo);
			request.setAttribute("listaChamadas", listaChamadasForm);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/webpages/calendarioConsultaChamada.jsp");
			dispatcher.forward(request, response);
			
		}catch(Exception e){
			throw new DceException("Erro na requisição ou resposta da consulta de chamadas!");
		}
	}
}
