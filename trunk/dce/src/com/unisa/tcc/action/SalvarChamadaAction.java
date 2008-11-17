package com.unisa.tcc.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unisa.tcc.form.AlunoForm;
import com.unisa.tcc.propriedades.DceException;


 public class SalvarChamadaAction implements InterfaceActionNegocio {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response) throws DceException {
		// TODO Auto-generated method stub
		try{
			String idChamada = request.getParameter("idChamada");
			List<AlunoForm> listaAlunos= null;
			listaAlunos = (List<AlunoForm>)request.getSession().getAttribute("listaAlunos");
			listaAlunos = listarAlunosPresenca(listaAlunos, request);
			controladorChamada.salvarChamada(listaAlunos, idChamada, idChamada);
			
		}catch (Exception e) {
			throw new DceException("Erro na requisição ou resposta da página de login!");
		}
	}   
	
	private List<AlunoForm> listarAlunosPresenca(List<AlunoForm> listaAlunos, HttpServletRequest request) {
		List<AlunoForm> listaAlunosPresenca = new ArrayList<AlunoForm>();
			Iterator<AlunoForm> itrListaAlunos = listaAlunos.iterator();
            while(itrListaAlunos.hasNext()){
                AlunoForm aluno = (AlunoForm)itrListaAlunos.next();
	            String radioPresenca = request.getParameter("chamada" + aluno.getMatricula());
	            Boolean presente = new Boolean(radioPresenca);
            	if(presente.booleanValue() != aluno.isPresenca()){
            		aluno.setPresenca(presente.booleanValue());
            		listaAlunosPresenca.add(aluno);
            	}
            }
 		return listaAlunosPresenca;
	}
}