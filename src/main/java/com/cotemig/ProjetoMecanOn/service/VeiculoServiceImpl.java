package com.cotemig.ProjetoMecanOn.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cotemig.ProjetoMecanOn.model.Veiculo;
import com.cotemig.ProjetoMecanOn.repo.VeiculoRepostory;

@Service("veiculoService")
public class VeiculoServiceImpl implements VeiculoService{
	@Autowired
	VeiculoRepostory veiculoRepository;
	
	@Override
	public Optional<Veiculo> getVeiculoById(Integer id) {
		return veiculoRepository.findById(id);
	}

	@Override
	public List<Veiculo> getAllVeiculos() {
		return veiculoRepository.findAll();
	}

	@Override
	public void deleteAllVeiculos() {
		veiculoRepository.deleteAll();		
	}

	@Override
	public void deleteVeiculoById(Integer id) {
		veiculoRepository.deleteAll();		
	}

	@Override
	public void updateVeiculoById(Integer id, Veiculo veiculo) {
		Optional<Veiculo> getVeiculo = getVeiculoById(id);
		getVeiculo.get().setNome(veiculo.getNome());
		getVeiculo.get().setTipo(veiculo.getTipo());
		getVeiculo.get().setPlaca(veiculo.getPlaca());
		getVeiculo.get().setAno(veiculo.getAno());
		getVeiculo.get().setCliente(veiculo.getCliente());
		
		veiculoRepository.save(veiculo);
	}

	@Override
	public void updateVeiculo(Veiculo veiculo) {
		veiculoRepository.save(veiculo);
	}

	@Override
	public void insertVeiculo(Veiculo veiculo) {
		veiculoRepository.save(veiculo);
	}
}
