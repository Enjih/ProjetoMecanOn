package com.cotemig.ProjetoMecanOn.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cotemig.ProjetoMecanOn.model.Cliente;

@Repository("clienteRepostory")
public interface  ClienteRepository extends JpaRepository<Cliente, Integer> {

}
