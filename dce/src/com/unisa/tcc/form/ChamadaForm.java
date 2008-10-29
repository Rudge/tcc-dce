package com.unisa.tcc.form;

import java.util.GregorianCalendar;
import java.util.List;

public class ChamadaForm {
	private List<AlunoForm> listaAlunos;
	private GregorianCalendar data;
	private DisciplinaForm disciplina;
	private ClasseForm classe;
	
	public ClasseForm getClasse() {
		return classe;
	}
	public void setClasse(ClasseForm classe) {
		this.classe = classe;
	}
	public List<AlunoForm> getListaAlunos() {
		return listaAlunos;
	}
	public void setListaAlunos(List<AlunoForm> listaAlunos) {
		this.listaAlunos = listaAlunos;
	}
	public GregorianCalendar getData() {
		return data;
	}
	public void setData(GregorianCalendar data) {
		this.data = data;
	}
	public DisciplinaForm getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(DisciplinaForm disciplina) {
		this.disciplina = disciplina;
	}
}
