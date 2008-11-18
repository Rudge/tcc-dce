package com.unisa.tcc.bean;

import java.io.Serializable;

public abstract class Usuario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1541723203590284902L;
	private int id;
	private String nome;
	private String usuario;
	private String senha;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario.toUpperCase().trim();
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
