package com.unisa.tcc.form;

import java.io.Serializable;

public class DisciplinaForm implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6334793254202066971L;
	private int id;
	private String Nome;
	private ProfessorForm professor;
	
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
	public ProfessorForm getProfessor() {
		return professor;
	}
	public void setProfessor(ProfessorForm professor) {
		this.professor = professor;
	}

}
