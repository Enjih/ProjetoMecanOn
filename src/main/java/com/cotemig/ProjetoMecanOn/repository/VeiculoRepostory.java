package com.cotemig.ProjetoMecanOn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cotemig.ProjetoMecanOn.model.Veiculo;

@Repository("veiculoRepository")
public interface VeiculoRepostory extends JpaRepository<Veiculo, Integer>{
	
}
