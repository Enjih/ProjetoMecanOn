package com.cotemig.ProjetoMecanOn.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cotemig.ProjetoMecanOn.model.Fornecedor;

@Repository("fornecedorRepository")
public interface FornecedorRepository  extends JpaRepository<Fornecedor, Integer> {

}
