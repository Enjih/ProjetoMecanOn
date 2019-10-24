package com.cotemig.ProjetoMecanOn.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Usuario {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String login;
	private String senha;
	
	@ManyToOne
	@JoinColumn(name="perfil_id", nullable=false)
	private Perfil perfil;
	private int perfil_id;
	
	public int getPerfil_id() {
		return perfil_id;
	}
	public void setPerfil_id(int perfil_id) {
		this.perfil_id = perfil_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
