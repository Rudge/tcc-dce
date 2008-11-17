package com.unisa.tcc.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unisa.tcc.form.AlunoForm;
import com.unisa.tcc.form.ChamadaForm;
import com.unisa.tcc.propriedades.DceException;
import com.unisa.tcc.to.AlunoTo;

public class RealizarChamadaAction implements InterfaceActionNegocio{
	
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response) throws DceException {
		
		try{
			String idChamada = request.getParameter("idChamada");
			String idClasse = request.getParameter("idClasse");
			List<AlunoTo> listaAlunosTo = controladorChamada.consultarAlunosChamada(idChamada, idClasse);
			List<AlunoForm> listaAlunosForm = new ArrayList<AlunoForm>();
	
			for (AlunoTo alunoTo : listaAlunosTo) {
				AlunoForm alunoForm = new AlunoForm();
				alunoForm.setMatricula(alunoTo.getMatricula());
				alunoForm.setNome(alunoTo.getNome());
				alunoForm.setPresenca(alunoTo.isPresenca());
				listaAlunosForm.add(alunoForm);
			}
			HashMap<Integer,ChamadaForm> mapChamadas = (HashMap<Integer,ChamadaForm>)request.getSession().getAttribute("mapChamadas");
			if(mapChamadas != null){
				ChamadaForm chamada = mapChamadas.get(new Integer(idChamada));
				request.setAttribute("chamada", chamada);
			}
			request.getSession().setAttribute("listaAlunos", listaAlunosForm);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/webpages/realizarChamada.jsp");
			dispatcher.forward(request, response);
			
		}catch(Exception e){
			throw new DceException("Erro na requisição ou resposta da consulta de Alunos por chamada!");
		}
	}

}
