package com.unisa.tcc.servlets;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unisa.tcc.negocio.LembraSenha;
import com.unisa.tcc.negocio.Login;
import com.unisa.tcc.propriedades.Constantes;


/**
 * Servlet implementation class for Servlet: Controller
 *
 */
 public class ServletAutenticacao extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 265016196022427241L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if(request.getParameter("ok").equals(Constantes.OK)){
			Login login = new Login();
			if(login.auntenticar()){
				RequestDispatcher dispatcher = request.getRequestDispatcher("/webpages/principal.jsp");
				dispatcher.forward(request, response);
			}
			
		}else{
			LembraSenha lembra = new LembraSenha();
			if(lembra.lembrarSenha()){
				
			}
		}
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}   	  	    
}