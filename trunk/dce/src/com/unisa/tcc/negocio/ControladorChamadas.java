package com.unisa.tcc.negocio;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import com.unisa.tcc.bean.ChamadaBean;
import com.unisa.tcc.dao.ControladorChamadasDAO;
import com.unisa.tcc.propriedades.DceException;
import com.unisa.tcc.to.ChamadaTo;
import com.unisa.tcc.to.ClasseTo;
import com.unisa.tcc.to.DisciplinaTo;

public class ControladorChamadas {
	
	public List<ChamadaTo> consultarChamadasPorData(int idProfessor, String data) throws DceException{
		ControladorChamadasDAO controladorDAO = new ControladorChamadasDAO();
		List<ChamadaTo> listaChamadasTo = new ArrayList<ChamadaTo>(); 
		String[] arrData = data.split("/");
		int ano = Integer.parseInt(arrData[2]);
		int mes = Integer.parseInt(arrData[1]);
		int dia = Integer.parseInt(arrData[0]);
		List<ChamadaBean> listaChamadasBean = controladorDAO.consultarChamadasPorData(idProfessor, new GregorianCalendar(ano,mes,dia));
		
		for (ChamadaBean chamadaBean : listaChamadasBean) {
			ChamadaTo chamadaTo = new ChamadaTo(); 
			ClasseTo classe = new ClasseTo();
			DisciplinaTo disciplina = new DisciplinaTo();
			disciplina.setNome(chamadaBean.getDisciplina().getNome());
			classe.setSerie(chamadaBean.getClasse().getSerie());
			classe.setTurma(chamadaBean.getClasse().getTurma());
			classe.setDescricaoSala(chamadaBean.getClasse().getDescricaoSala());
			chamadaTo.setClasse(classe);
			chamadaTo.setDisciplina(disciplina);
			listaChamadasTo.add(chamadaTo);
		}
		return listaChamadasTo;
	}

}
