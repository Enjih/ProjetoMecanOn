package com.cotemig.ProjetoMecanOn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cotemig.ProjetoMecanOn.model.Produto;

@Repository("produtoRepository")
public interface ProdutoRepostory extends JpaRepository<Produto, Integer>{

}