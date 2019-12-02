package com.cotemig.ProjetoMecanOn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cotemig.ProjetoMecanOn.model.OrdemServico;
import com.cotemig.ProjetoMecanOn.repo.OrdemServicoRepostory;

@Service("ordemServicoService")
public class OrdemServicoServiceImpl implements OrdemServicoService{

	@Autowired
	OrdemServicoRepostory ordemServicoRepository;
	
	@Override
	public Optional<OrdemServico> getOrdemServicoById(Integer id) {
		return ordemServicoRepository.findById(id);
	}

	@Override
	public List<OrdemServico> getAllOrdensServico() {
		return ordemServicoRepository.findAll();
	}

	@Override
	public void deleteAllOrdensServico() {
		ordemServicoRepository.deleteAll();
	}

	@Override
	public void deleteOrdemServicoById(Integer id) {
		ordemServicoRepository.deleteById(id);	
	}

	@Override
	public void updateOrdemServicoById(Integer id, OrdemServico ordemServico) {
		Optional<OrdemServico> getOrdemServico = getOrdemServicoById(id);
		getOrdemServico.get().setDescricao(ordemServico.getDescricao());
		getOrdemServico.get().setCliente(ordemServico.getCliente());
		getOrdemServico.get().setDataSolicitacao(ordemServico.getDataSolicitacao());
		getOrdemServico.get().setDataInicio(ordemServico.getDataInicio());
		getOrdemServico.get().setDataEntrega(ordemServico.getDataEntrega());
		getOrdemServico.get().setStatus(ordemServico.getStatus());
		getOrdemServico.get().setValor(ordemServico.getValor());
		getOrdemServico.get().setVeiculo(ordemServico.getVeiculo());
		getOrdemServico.get().setUsuario(ordemServico.getUsuario());
		getOrdemServico.get().setCliente(ordemServico.getCliente());
		
		ordemServicoRepository.save(ordemServico);		
	}

	@Override
	public void updateOrdemServico(OrdemServico ordemServico) {
		ordemServicoRepository.save(ordemServico);
	}

	@Override
	public void insertOrdemServico(OrdemServico ordemServico) {
		ordemServicoRepository.save(ordemServico);
	}
}
