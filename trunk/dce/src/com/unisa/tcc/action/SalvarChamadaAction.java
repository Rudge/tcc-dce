package com.unisa.tcc.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unisa.tcc.form.AlunoForm;
import com.unisa.tcc.form.ChamadaForm;
import com.unisa.tcc.form.ProfessorForm;
import com.unisa.tcc.propriedades.DceException;
import com.unisa.tcc.to.ChamadaTo;


 public class SalvarChamadaAction implements InterfaceActionNegocio {

	@SuppressWarnings("unchecked")
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response) throws DceException {
		// TODO Auto-generated method stub
		try{
			String idChamada = request.getParameter("idChamada");
			String idClasse = request.getParameter("idClasse");
			ProfessorForm professor = (ProfessorForm) request.getSession().getAttribute("usuario");
			List<AlunoForm> listaAlunos= null;
			listaAlunos = (List<AlunoForm>) request.getSession().getAttribute("listaAlunos");
			listaAlunos = listarAlunosPresenca(listaAlunos, request);
			boolean retorno = controladorChamada.salvarChamada(listaAlunos, idChamada, idClasse);
			if(retorno){
				List<ChamadaTo> listaChamadasTo = controladorChamada.consultarChamadasPorData(professor.getId(), null);
				List<ChamadaForm> listaChamadasForm = controladorChamada.tranfListaChamadaTo(listaChamadasTo);
				request.setAttribute("listaChamadas", listaChamadasForm);
				request.setAttribute("msgSucesso", "Foi atualizada a chamada com sucesso!");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/webpages/calendarioConsultaChamada.jsp");
				dispatcher.forward(request, response);
			}
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