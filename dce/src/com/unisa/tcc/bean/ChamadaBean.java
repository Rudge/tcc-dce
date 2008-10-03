package com.unisa.tcc.bean;

import java.sql.Date;
import java.util.List;

public class ChamadaBean {
	private ProfessorBean professor;
	private List<AlunoBean> listaAlunos;
	private Date date;
	private DisciplinaBean disciplina;
	public ProfessorBean getProfessor() {
		return professor;
	}
	public void setProfessor(ProfessorBean professor) {
		this.professor = professor;
	}
	public List<AlunoBean> getListaAlunos() {
		return listaAlunos;
	}
	public void setListaAlunos(List<AlunoBean> listaAlunos) {
		this.listaAlunos = listaAlunos;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public DisciplinaBean getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(DisciplinaBean disciplina) {
		this.disciplina = disciplina;
	}
}
