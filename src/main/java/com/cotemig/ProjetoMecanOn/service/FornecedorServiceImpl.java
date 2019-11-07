package com.cotemig.ProjetoMecanOn.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cotemig.ProjetoMecanOn.model.Fornecedor;
import com.cotemig.ProjetoMecanOn.repo.FornecedorRepository;

@Service("fornecedorService")
public class FornecedorServiceImpl implements FornecedorService{
	@Autowired
	FornecedorRepository fornecedorRepository;
	
	@Override
	public Optional<Fornecedor> getFornecedorById(Integer id) {
		return fornecedorRepository.findById(id);
	}

	@Override
	public List<Fornecedor> getAllFornecedores() {
		return fornecedorRepository.findAll();
	}

	@Override
	public void deleteAllFornecedores() {
		fornecedorRepository.deleteAll();		
	}

	@Override
	public void deleteFornecedorById(Integer id) {
		fornecedorRepository.deleteById(id);	
	}

	@Override
	public void updateFornecedorById(Integer id, Fornecedor fornecedor) {
		Optional<Fornecedor> getFornecedor = getFornecedorById(id);
		getFornecedor.get().setNome(fornecedor.getNome());
		getFornecedor.get().setCnpj(fornecedor.getCnpj());
		getFornecedor.get().setEmail(fornecedor.getEmail());
		getFornecedor.get().setTelefone(fornecedor.getTelefone());
		
		fornecedorRepository.save(fornecedor);		
	}

	@Override
	public void updateFornecedor(Fornecedor fornecedor) {
		fornecedorRepository.save(fornecedor);
	}

	@Override
	public void insertFornecedor(Fornecedor fornecedor) {
		fornecedorRepository.save(fornecedor);		
	}

}
