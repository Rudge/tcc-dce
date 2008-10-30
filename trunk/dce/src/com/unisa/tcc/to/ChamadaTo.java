package com.unisa.tcc.to;

import java.util.GregorianCalendar;
import java.util.List;

public class ChamadaTo {
	
	private int id;
	private List<AlunoTo> listaAlunos;
	private GregorianCalendar data;
	private DisciplinaTo disciplina;
	private ClasseTo classe;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ClasseTo getClasse() {
		return classe;
	}
	public void setClasse(ClasseTo classe) {
		this.classe = classe;
	}
	public List<AlunoTo> getListaAlunos() {
		return listaAlunos;
	}
	public void setListaAlunos(List<AlunoTo> listaAlunos) {
		this.listaAlunos = listaAlunos;
	}
	public GregorianCalendar getData() {
		return data;
	}
	public void setData(GregorianCalendar data) {
		this.data = data;
	}
	public DisciplinaTo getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(DisciplinaTo disciplina) {
		this.disciplina = disciplina;
	}
}
