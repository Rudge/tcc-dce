package com.unisa.tcc.negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.unisa.tcc.bean.AlunoBean;
import com.unisa.tcc.bean.ChamadaBean;
import com.unisa.tcc.dao.ControladorChamadasDAO;
import com.unisa.tcc.form.ChamadaForm;
import com.unisa.tcc.form.ClasseForm;
import com.unisa.tcc.form.DisciplinaForm;
import com.unisa.tcc.propriedades.DceException;
import com.unisa.tcc.to.AlunoTo;
import com.unisa.tcc.to.ChamadaTo;
import com.unisa.tcc.to.ClasseTo;
import com.unisa.tcc.to.DisciplinaTo;

public class ControladorChamadas {
	
	private ControladorChamadasDAO controladorChamadasDAO = new ControladorChamadasDAO();	
	
	public List<ChamadaTo> consultarChamadasPorData(int idProfessor, String data) throws DceException{
		
		List<ChamadaTo> listaChamadasTo = new ArrayList<ChamadaTo>();
		try{ 
			int ano = 0;
			int mes = 0;
			int dia = 0;
			if(data != null && !"".equals(data)){
				String[] arrData = data.split("/");
				ano = Integer.parseInt(arrData[2]);
				mes = Integer.parseInt(arrData[1]) - 1;
				dia = Integer.parseInt(arrData[0]);
			}
			List<ChamadaBean> listaChamadasBean = controladorChamadasDAO.consultarChamadasPorData(idProfessor, ano, mes, dia);
			
			for (ChamadaBean chamadaBean : listaChamadasBean) {
				ChamadaTo chamadaTo = new ChamadaTo(); 
				ClasseTo classe = new ClasseTo();
				DisciplinaTo disciplina = new DisciplinaTo();
				disciplina.setNome(chamadaBean.getDisciplina().getNome());
				classe.setSerie(chamadaBean.getClasse().getSerie());
				classe.setTurma(chamadaBean.getClasse().getTurma());
				classe.setDescricaoSala(chamadaBean.getClasse().getDescricaoSala());
				chamadaTo.setId(chamadaBean.getId());
				chamadaTo.setClasse(classe);
				chamadaTo.setDisciplina(disciplina);
				listaChamadasTo.add(chamadaTo);
			}
		}catch(SQLException e){
			throw new DceException("Erro na consulta da Chamada por data!");
		}
		return listaChamadasTo;
	}
	
	public List<AlunoTo> consultarAlunosChamada(String idChamada) throws DceException{
		
		List<AlunoTo> listaAlunosTo = new ArrayList<AlunoTo>();
		try{
			List<AlunoBean> listaAlunosBean = controladorChamadasDAO.consultarAlunosChamada(new Integer(idChamada));
			
			for (AlunoBean alunoBean : listaAlunosBean) {
				AlunoTo alunoTo = new AlunoTo();
				alunoTo.setMatricula(alunoBean.getMatricula());
				alunoTo.setNome(alunoBean.getNome());
				alunoTo.setPresenca(alunoBean.isPresenca());
				listaAlunosTo.add(alunoTo);
			}
			
		}catch (SQLException e) {
			throw new DceException("Erro na consulta de Alunos por chamada!");
		}	
		
		return listaAlunosTo;
	}
	
	public List<ChamadaForm> tranfListaChamadaTo(List<ChamadaTo> listaChamadasTo){
		List<ChamadaForm> listaChamadasForm = new ArrayList<ChamadaForm>();
		
		for (ChamadaTo chamadaTo : listaChamadasTo) {
			ChamadaForm chamadaForm = new ChamadaForm(); 
			ClasseForm classe = new ClasseForm();
			DisciplinaForm disciplina = new DisciplinaForm();
			disciplina.setNome(chamadaTo.getDisciplina().getNome());
			classe.setSerie(chamadaTo.getClasse().getSerie());
			classe.setTurma(chamadaTo.getClasse().getTurma());
			classe.setDescricaoSala(chamadaTo.getClasse().getDescricaoSala());
			chamadaForm.setId(chamadaTo.getId());
			chamadaForm.setClasse(classe);
			chamadaForm.setDisciplina(disciplina);
			listaChamadasForm.add(chamadaForm);
		}
		
		return listaChamadasForm;
	}
}
