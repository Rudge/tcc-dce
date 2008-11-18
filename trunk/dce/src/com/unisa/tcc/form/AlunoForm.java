package com.unisa.tcc.form;

import java.io.Serializable;

public class AlunoForm implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4376678328193775925L;
	private int matricula;
	private String Nome;
	private boolean presenca;
	
	public boolean isPresenca() {
		return presenca;
	}
	public void setPresenca(boolean presenca) {
		this.presenca = presenca;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}

}
