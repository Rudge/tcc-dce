package com.unisa.tcc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unisa.tcc.form.ProfessorForm;
import com.unisa.tcc.negocio.ControladorChamadas;
import com.unisa.tcc.propriedades.DceException;

public class ConsultaChamadaAction implements InterfaceActionNegocio{
	
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response) throws DceException {
		try{
			ProfessorForm professor = (ProfessorForm) request.getSession().getAttribute("usuario");
			String data = (String) request.getAttribute("dataEscolhida");
			ControladorChamadas controladorChamadas = new ControladorChamadas();
			controladorChamadas.consultarChamadasPorData(professor.getId(), data);
			
		}catch(Exception e){
			throw new DceException("Erro na requisição ou resposta na consulta de chamadas!");
		}
	}

}
