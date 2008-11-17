package com.unisa.tcc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unisa.tcc.negocio.ControladorChamadas;
import com.unisa.tcc.propriedades.DceException;

public interface InterfaceActionNegocio {

	ControladorChamadas controladorChamada = new ControladorChamadas();
	void executar(HttpServletRequest request, HttpServletResponse response) throws DceException;

}
