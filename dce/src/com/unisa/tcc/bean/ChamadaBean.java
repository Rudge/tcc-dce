package com.unisa.tcc.bean;

import java.util.GregorianCalendar;
import java.util.List;

public class ChamadaBean {
	
	private int id;
	private List<AlunoBean> listaAlunos;
	private GregorianCalendar data;
	private DisciplinaBean disciplina;
	private ClasseBean classe;
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
	public ClasseBean getClasse() {
		return classe;
	}
	public void setClasse(ClasseBean classe) {
		this.classe = classe;
	}
	public List<AlunoBean> getListaAlunos() {
		return listaAlunos;
	}
	public void setListaAlunos(List<AlunoBean> listaAlunos) {
		this.listaAlunos = listaAlunos;
	}
	public GregorianCalendar getData() {
		return data;
	}
	public void setData(GregorianCalendar data) {
		this.data = data;
	}
	public DisciplinaBean getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(DisciplinaBean disciplina) {
		this.disciplina = disciplina;
	}
}
