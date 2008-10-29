package com.unisa.tcc.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unisa.tcc.action.InterfaceActionNegocio;
import com.unisa.tcc.propriedades.Constantes;
import com.unisa.tcc.propriedades.DceException;

public class ControladorServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2443729024091269603L;

	public void service(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		
		String acaoNomeClasse = Constantes.URL_ACTION + request.getParameter("acao");
		Class<?> acaoClasse = null;
		InterfaceActionNegocio actionNegocioObjeto = null;

		try {
			acaoClasse = Class.forName(acaoNomeClasse);
			
			if (!InterfaceActionNegocio.class.isAssignableFrom(acaoClasse)) {
				throw new ServletException("classe não implementa a interface: " + acaoClasse);
			}
			actionNegocioObjeto = (InterfaceActionNegocio) acaoClasse.newInstance();
			
			actionNegocioObjeto.executar(request, response);
			
		} catch (ClassNotFoundException e) {
			request.setAttribute("mensagemErro", "Não encontro a classe " + acaoClasse);
			throw new ServletException("Não encontro a classe " + acaoClasse);
		}catch (DceException e){
			request.setAttribute("mensagemErro", e.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/webpages/erro.jsp");
			dispatcher.forward(request, response);
		}catch (Exception e) {
			request.setAttribute("mensagemErro", "A lógica de negócios causou uma exceção");
			throw new ServletException("A lógica de negócios causou uma exceção");
		}
	}
}