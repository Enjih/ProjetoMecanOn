package com.cotemig.ProjetoMecanOn.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cotemig.ProjetoMecanOn.model.OrdemServico;

@Repository("ordemServicoRepository")
public interface OrdemServicoRepostory extends JpaRepository<OrdemServico, Integer>{

}

