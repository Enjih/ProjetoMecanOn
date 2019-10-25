package com.cotemig.ProjetoMecanOn.service;

import java.util.List;
import java.util.Optional;
import com.cotemig.ProjetoMecanOn.model.Usuario;

public interface UsuarioService {
	Optional<Usuario> getUsuarioById(Integer id);
	List<Usuario> getAllUsuarios();
	void deleteAllUsuarios();
	void deleteUsuarioById(Integer id);
	void updateUsuarioById(Integer id, Usuario usuario);
	void updateUsuario(Usuario usuario);
	void insertUsuario(Usuario usuario);
}
