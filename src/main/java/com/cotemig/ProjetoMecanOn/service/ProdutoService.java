package com.cotemig.ProjetoMecanOn.service;

import java.util.List;
import java.util.Optional;

import com.cotemig.ProjetoMecanOn.model.Produto;

public interface ProdutoService {
	Optional<Produto> getProdutoById(Integer id);
	List<Produto> getAllProdutos();
	void deleteAllProdutos();
	void deleteProdutoById(Integer id);
	void updateProdutoById(Integer id, Produto produto);
	void updateProduto(Produto produto);
	void insertProduto(Produto produto);
}
