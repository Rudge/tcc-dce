package com.unisa.tcc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface InterfaceActionNegocio {

	void executar(HttpServletRequest request, HttpServletResponse response) throws Exception;

}
