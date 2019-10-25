package com.cotemig.ProjetoMecanOn.service;

import java.util.List;
import java.util.Optional;
import com.cotemig.ProjetoMecanOn.model.Fornecedor;

public interface FornecedorService {
	Optional<Fornecedor> getFornecedorById(Integer id);
	List<Fornecedor> getAllFornecedores();
	void deleteAllFornecedores();
	void deleteFornecedorById(Integer id);
	void updateFornecedorById(Integer id, Fornecedor Fornecedor);
	void updateFornecedor(Fornecedor Fornecedor);
	void insertFornecedor(Fornecedor Fornecedor);
}
