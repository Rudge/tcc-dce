package com.unisa.tcc.form;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.List;

public class ChamadaForm implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4160115739998396954L;
	private int id;
	private List<AlunoForm> listaAlunos;
	private GregorianCalendar data;
	private DisciplinaForm disciplina;
	private ClasseForm classe;
	private String horaAula;
	
	public String getHoraAula() {
		return horaAula;
	}
	public void setHoraAula(String horaAula) {
		this.horaAula = horaAula;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
