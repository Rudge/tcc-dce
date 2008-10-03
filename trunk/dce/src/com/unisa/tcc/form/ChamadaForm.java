package com.unisa.tcc.form;

import java.sql.Date;
import java.util.List;

public class ChamadaForm {
	private ProfessorForm professor;
	private List<AlunoForm> listaAlunos;
	private Date date;
	private DisciplinaForm disciplina;
	public ProfessorForm getProfessor() {
		return professor;
	}
	public void setProfessor(ProfessorForm professor) {
		this.professor = professor;
	}
	public List<AlunoForm> getListaAlunos() {
		return listaAlunos;
	}
	public void setListaAlunos(List<AlunoForm> listaAlunos) {
		this.listaAlunos = listaAlunos;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public DisciplinaForm getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(DisciplinaForm disciplina) {
		this.disciplina = disciplina;
	}
}
