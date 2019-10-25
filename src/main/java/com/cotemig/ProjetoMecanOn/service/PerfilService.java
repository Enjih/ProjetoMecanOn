package com.cotemig.ProjetoMecanOn.service;

import java.util.List;
import java.util.Optional;
import com.cotemig.ProjetoMecanOn.model.Perfil;

public interface PerfilService {
	Optional<Perfil> getPerfilById(Integer id);
	List<Perfil> getAllPerfis();
	void deleteAllPerfis();
	void deletePerfilById(Integer id);
	void updatePerfilById(Integer id, Perfil perfil);
	void updatePerfil(Perfil perfil);
	void insertPerfil(Perfil perfil);
}
