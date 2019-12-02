package com.cotemig.ProjetoMecanOn.service;

import java.util.List;
import java.util.Optional;

import com.cotemig.ProjetoMecanOn.model.OrdemServico;

public interface OrdemServicoService {
	Optional<OrdemServico> getOrdemServicoById(Integer id);
	List<OrdemServico> getAllOrdensServico();
	void deleteAllOrdensServico();
	void deleteOrdemServicoById(Integer id);
	void updateOrdemServicoById(Integer id, OrdemServico ordemServico);
	void updateOrdemServico(OrdemServico ordemServico);
	void insertOrdemServico(OrdemServico ordemServico);
}
