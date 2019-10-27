package com.cotemig.ProjetoMecanOn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cotemig.ProjetoMecanOn.dao.PerfilRepostory;
import com.cotemig.ProjetoMecanOn.model.Perfil;

@Service("perfilService")
public class PerfilServiceImpl implements PerfilService{

	@Autowired
	PerfilRepostory perfilRepository;
	
	@Override
	public Optional<Perfil> getPerfilById(Integer id) {
		return perfilRepository.findById(id);
	}

	@Override
	public List<Perfil> getAllPerfis() {
		return perfilRepository.findAll();
	}

	@Override
	public void deleteAllPerfis() {
		perfilRepository.deleteAll();
	}

	@Override
	public void deletePerfilById(Integer id) {
		perfilRepository.deleteById(id);	
	}

	@Override
	public void updatePerfilById(Integer id, Perfil perfil) {
		Optional<Perfil> getPerfil = getPerfilById(id);
		getPerfil.get().setNome(perfil.getNome());
		getPerfil.get().setTipo(perfil.getTipo());
		getPerfil.get().setPermissoes(perfil.getPermissoes());
		
		perfilRepository.save(perfil);		
	}

	@Override
	public void updatePerfil(Perfil perfil) {
		perfilRepository.save(perfil);
	}

	@Override
	public void insertPerfil(Perfil perfil) {
		perfilRepository.save(perfil);
	}

	
}
