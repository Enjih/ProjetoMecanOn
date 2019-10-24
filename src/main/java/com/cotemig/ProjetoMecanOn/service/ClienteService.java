package com.cotemig.ProjetoMecanOn.service;

import java.util.List;
import java.util.Optional;
import com.cotemig.ProjetoMecanOn.model.Cliente;

public interface ClienteService {
	Optional<Cliente> getClienteById(Integer id);
	List<Cliente> getAllClientes();
	void deleteAllClientes();
	void deleteClienteById(Integer id);
	void updateClienteById(Integer id, Cliente cliente);
	void updateCliente(Cliente cliente);
	void insertCliente(Cliente cliente);
}