package com.cotemig.ProjetoMecanOn.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Produto {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String nome;
	private double preco;
	
	@ManyToOne
	@JoinColumn(name="fornecedor_id", nullable=false)
	private Fornecedor fornecedor;
	private Integer fornecedor_id;
	
	public Integer getFornecedor_id() {
		return fornecedor_id;
	}
	public void setFornecedor_id(Integer fornecedor_id) {
		this.fornecedor_id = fornecedor_id;
	}
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
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
}
