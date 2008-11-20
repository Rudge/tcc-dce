package com.unisa.tcc.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unisa.tcc.propriedades.DceException;

public class RecuperaSenhaAction implements InterfaceActionNegocio {
	
	public void executar(HttpServletRequest request, HttpServletResponse response) throws DceException {
		// TODO Auto-generated method stub
		try{
			request.setAttribute("msgErro", "Funcionalidade não disponível!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
		}catch (Exception e) {
			throw new DceException("Erro na requisição ou resposta da página de login!");
		}
	}
}
