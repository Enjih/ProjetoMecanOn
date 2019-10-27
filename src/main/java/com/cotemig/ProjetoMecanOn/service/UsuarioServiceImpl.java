package com.cotemig.ProjetoMecanOn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cotemig.ProjetoMecanOn.dao.UsuarioRepository;
import com.cotemig.ProjetoMecanOn.model.Usuario;

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService{
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public Optional<Usuario> getUsuarioById(Integer id) {
		return usuarioRepository.findById(id);
	}

	@Override
	public List<Usuario> getAllUsuarios() {
		return usuarioRepository.findAll();
	}

	@Override
	public void deleteAllUsuarios() {
		usuarioRepository.deleteAll();		
	}

	@Override
	public void deleteUsuarioById(Integer id) {
		usuarioRepository.deleteById(id);	
	}

	@Override
	public void updateUsuarioById(Integer id, Usuario usuario) {
		Optional<Usuario> getUsuario = getUsuarioById(id);
		getUsuario.get().setLogin(usuario.getLogin());
		getUsuario.get().setSenha(usuario.getSenha());
		getUsuario.get().setPerfil(usuario.getPerfil());
		
		usuarioRepository.save(usuario);
	}

	@Override
	public void updateUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	@Override
	public void insertUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	

}