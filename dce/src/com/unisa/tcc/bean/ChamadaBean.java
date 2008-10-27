package com.unisa.tcc.bean;

import java.util.GregorianCalendar;
import java.util.List;

public class ChamadaBean {
	private List<AlunoBean> listaAlunos;
	private GregorianCalendar data;
	private DisciplinaBean disciplina;
	private ClasseBean classe;
	
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
