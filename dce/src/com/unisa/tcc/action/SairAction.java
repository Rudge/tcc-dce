package com.unisa.tcc.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unisa.tcc.propriedades.Constantes;
import com.unisa.tcc.propriedades.DceException;

public class SairAction implements InterfaceActionNegocio {
	
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response) throws DceException {
		
		try{
			request.getSession().invalidate();
			request.getSession(false);
			request.setAttribute("msgErro", "Logoff efetuado com sucesso!");
			RequestDispatcher dispatcher = request.getRequestDispatcher(Constantes.PAGINA_INDEX);
			dispatcher.forward(request, response);
		}catch (Exception e) {
			throw new DceException("Erro ao efetuar logoff!");
		}
	}
}
