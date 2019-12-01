package com.cotemig.ProjetoMecanOn.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cotemig.ProjetoMecanOn.model.Cliente;
import com.cotemig.ProjetoMecanOn.service.ClienteService;

@Controller
public class ClienteController {
	@Autowired
	private ClienteService  clienteService;

	@RequestMapping( value = "/Cliente", method = RequestMethod.GET) 
	public ModelAndView Cliente(){
		ModelAndView mav = new ModelAndView("cliente");

		mav.addObject("clientes", clienteService.getAllClientes());
		mav.addObject("cliente", new Cliente());

		return mav;
	}	

	@RequestMapping(value = "/Cliente", method = RequestMethod.POST)
	public String submitIncluirCliente(@Valid @ModelAttribute("cliene")Cliente cliente, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "error";
		}		
		clienteService.insertCliente(cliente);        
		return "redirect:Cliente";
	}

	@RequestMapping(value = "/Cliente/Alterar", method = RequestMethod.GET)
	public ModelAndView AlterarCliente(Integer id) {
		return new ModelAndView("cliente_alterar", "cliente", clienteService.getClienteById(id).get());		
	}

	@RequestMapping(value = "/Cliente/Alterar", method = RequestMethod.POST)
	public String submitAlterarCliente(@Valid @ModelAttribute("cliente")Cliente cliente,
			BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "error";
		}

		return "redirect:";
	}
	@RequestMapping(value = "/Cliente/Excluir", method = RequestMethod.GET)
	public ModelAndView ExcluirCliente(Integer id) {
		return new ModelAndView("cliente_excluir", "cliente", clienteService.getClienteById(id).get());
	}

	@RequestMapping(value = "/Cliente/Excluir", method = RequestMethod.POST)
	public String submitExcluirCliente(@Valid @ModelAttribute("cliente")Cliente cliente, BindingResult result, ModelMap model) {	
		if (result.hasErrors()) {			
			return "error";
		}
		clienteService.deleteClienteById(cliente.getId());		        
		return "redirect:Cliente";
	}
}
