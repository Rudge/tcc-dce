package com.unisa.tcc.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unisa.tcc.propriedades.DceException;

public class SairAction implements InterfaceActionNegocio {
	
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response) throws DceException {
		
		try{
			request.getSession().invalidate();
			request.getSession(false);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
		}catch (Exception e) {
			throw new DceException("Erro ao efetuar logoff!");
		}
	}
}
