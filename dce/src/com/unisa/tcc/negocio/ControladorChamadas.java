package com.unisa.tcc.negocio;

import java.util.GregorianCalendar;
import java.util.List;

import com.unisa.tcc.dao.ControladorChamadasDAO;

public class ControladorChamadas {
	
	public List<?> consultarChamadas(int idProfessor, GregorianCalendar data){
		ControladorChamadasDAO controladorDAO = new ControladorChamadasDAO();
		
		
		controladorDAO.consultarChamada(idProfessor, data);
		
		return null;
	}

}
