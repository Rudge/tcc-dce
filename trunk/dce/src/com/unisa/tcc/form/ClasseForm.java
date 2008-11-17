package com.unisa.tcc.form;

public class ClasseForm {
	
	private int id;
	private int serie;
	private String periodo;
	private int ano;
	private char turma;
	private String descricaoSala;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricaoSala() {
		return descricaoSala;
	}
	public void setDescricaoSala(String descricaoSala) {
		this.descricaoSala = descricaoSala;
	}
	public char getTurma() {
		return turma;
	}
	public void setTurma(char turma) {
		this.turma = turma;
	}
	public int getSerie() {
		return serie;
	}
	public void setSerie(int serie) {
		this.serie = serie;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}

}
