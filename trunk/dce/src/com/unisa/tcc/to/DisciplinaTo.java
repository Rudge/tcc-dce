package com.unisa.tcc.to;

public class DisciplinaTo {
	
	private int id;
	private String Nome;
	private ProfessorTo professor;
	
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
	public ProfessorTo getProfessor() {
		return professor;
	}
	public void setProfessor(ProfessorTo professor) {
		this.professor = professor;
	}

}
