package com.cotemig.ProjetoMecanOn.service;

import java.util.List;
import java.util.Optional;
import com.cotemig.ProjetoMecanOn.model.Veiculo;

public interface VeiculoService {
	Optional<Veiculo> getVeiculoById(Integer id);
	List<Veiculo> getAllVeiculos();
	void deleteAllVeiculos();
	void deleteVeiculoById(Integer id);
	void updateVeiculoById(Integer id, Veiculo veiculo);
	void updateVeiculo(Veiculo veiculo);
	void insertVeiculo(Veiculo veiculo);
}
