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
		
		Class<?> acaoClasse = null;
		
		try {
			String acao = request.getParameter("acao");
			
			String acaoNomeClasse = Constantes.URL_ACTION + acao;
			
			if((acao == null || acao.equals(""))  || 
			   (request.getSession().getAttribute("usuario") == null && !"AutenticacaoAction".equals(acao))){
				throw new DceException("Usu�rio n�o autenticado!");
			} 
			
			InterfaceActionNegocio actionNegocioObjeto = null;
		
			acaoClasse = Class.forName(acaoNomeClasse);
			
			if (!InterfaceActionNegocio.class.isAssignableFrom(acaoClasse)) {
				throw new ServletException("classe n�o implementa a interface: " + acaoClasse);
			}
			actionNegocioObjeto = (InterfaceActionNegocio) acaoClasse.newInstance();
			
			actionNegocioObjeto.executar(request, response);
			
		} catch (ClassNotFoundException e) {
			request.setAttribute("msgErro", "A implementa��o causou uma exce��o");
			throw new ServletException("N�o encontro a classe " + acaoClasse);
		}catch (DceException e){
			request.setAttribute("msgErro", e.getMessage());
			if(request.getSession().getAttribute("usuario") != null){
				RequestDispatcher dispatcher = request.getRequestDispatcher("/webpages/erro.jsp");
				dispatcher.forward(request, response);
			}else{
				RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
				dispatcher.forward(request, response);
			}
		}catch (Exception e) {
			request.setAttribute("msgErro", "A l�gica de neg�cios causou uma exce��o");
			throw new ServletException("A l�gica de neg�cios causou uma exce��o");
		}
	}
}