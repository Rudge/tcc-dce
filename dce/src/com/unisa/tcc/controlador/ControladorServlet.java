package com.unisa.tcc.controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unisa.tcc.action.InterfaceActionNegocio;
import com.unisa.tcc.propriedades.Constantes;

public class ControladorServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2443729024091269603L;

	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		String acaoClasseNome = Constantes.URL_ACTION + request.getParameter("acao");
		Class<?> acaoClasse = null;
		InterfaceActionNegocio actionNegocioObject = null;
		
		try {
			acaoClasse = Class.forName(acaoClasseNome);
			
			if (!InterfaceActionNegocio.class.isAssignableFrom(acaoClasse)) {
				throw new ServletException("classe não implementa a interface: " + acaoClasse);
			}
			actionNegocioObject = (InterfaceActionNegocio) acaoClasse.newInstance();
			
			actionNegocioObject.executar(request, response);
			
		} catch (ClassNotFoundException e) {
			throw new ServletException("Não encontro a classe " + acaoClasse);
		}catch (InstantiationException e) {
			throw new ServletException(e);
		}catch (IllegalAccessException e) {
			throw new ServletException(e);
		}catch (Exception e) {
			throw new ServletException("A lógica de negócios causou uma exceção", e);
		}
	}
}