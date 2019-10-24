package com.cotemig.ProjetoMecanOn.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Perfil {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String nome;
	private char tipo;
	private Integer permissoes;
	
	@OneToMany(mappedBy="perfil")
	private Set<Usuario> usuarios;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public Integer getPermissoes() {
		return permissoes;
	}
	public void setPermissoes(Integer permissoes) {
		this.permissoes = permissoes;
	}	
}
