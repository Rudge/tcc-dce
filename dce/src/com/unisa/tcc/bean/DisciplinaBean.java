package com.unisa.tcc.bean;

public class DisciplinaBean {
	
	private int id;
	private String Nome;
	private ProfessorBean professor;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public ProfessorBean getProfessor() {
		return professor;
	}
	public void setProfessor(ProfessorBean professor) {
		this.professor = professor;
	}

}
