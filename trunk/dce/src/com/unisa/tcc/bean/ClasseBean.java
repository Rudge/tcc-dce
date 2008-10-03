package com.unisa.tcc.bean;

public class ClasseBean {
	
	private String serie;
	private String periodo;
	private ChamadaBean chamada;
	private int ano;
	
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public ChamadaBean getChamada() {
		return chamada;
	}
	public void setChamada(ChamadaBean chamada) {
		this.chamada = chamada;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
}
