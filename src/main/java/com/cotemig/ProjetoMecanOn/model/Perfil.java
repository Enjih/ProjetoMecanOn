package com.cotemig.ProjetoMecanOn.model;

public class Perfil {
	
	private int id;
	private String nome;
	private char tipo;
	private int permissoes;
	
	
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
	public char getTipo() {
		return tipo;
	}
	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
	public int getPermissoes() {
		return permissoes;
	}
	public void setPermissoes(int permissoes) {
		this.permissoes = permissoes;
	}	
}
