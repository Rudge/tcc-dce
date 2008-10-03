package com.unisa.tcc.to;

import java.sql.Date;
import java.util.List;

public class ChamadaTo {
	private ProfessorTo professor;
	private List<AlunoTo> listaAlunos;
	private Date date;
	private DisciplinaTo disciplina;
	public ProfessorTo getProfessor() {
		return professor;
	}
	public void setProfessor(ProfessorTo professor) {
		this.professor = professor;
	}
	public List<AlunoTo> getListaAlunos() {
		return listaAlunos;
	}
	public void setListaAlunos(List<AlunoTo> listaAlunos) {
		this.listaAlunos = listaAlunos;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public DisciplinaTo getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(DisciplinaTo disciplina) {
		this.disciplina = disciplina;
	}
}
