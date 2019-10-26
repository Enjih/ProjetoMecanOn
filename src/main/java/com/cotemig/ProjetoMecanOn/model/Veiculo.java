package com.cotemig.ProjetoMecanOn.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Veiculo {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String nome;
	private char tipo;
	private String placa;
	private Date ano;
	
	@ManyToOne
	@JoinColumn(name="cliente_id", nullable=false)
	private Cliente cliente;
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
	public char getTipo() {
		return tipo;
	}
	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public Date getAno() {
		return ano;
	}
	public void setAno(Date ano) {
		this.ano = ano;
	}
}
