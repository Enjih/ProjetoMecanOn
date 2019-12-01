package com.cotemig.ProjetoMecanOn.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cotemig.ProjetoMecanOn.model.Veiculo;
import com.cotemig.ProjetoMecanOn.service.ClienteService;
import com.cotemig.ProjetoMecanOn.service.VeiculoService;

@Controller
public class VeiculoController {
	@Autowired
	private ClienteService  clienteService;
	
	@Autowired
	private VeiculoService  veiculoService;
	
	@RequestMapping( value = "/Veiculo", method = RequestMethod.GET) 
	public ModelAndView Veiculo(){
		ModelAndView mav = new ModelAndView("veiculo");
		char [] Tipos = new char[]{'C', 'M'};

		mav.addObject("clientes", clienteService.getAllClientes());
		mav.addObject("veiculos", veiculoService.getAllVeiculos());
		mav.addObject("tipos", Tipos);
		mav.addObject("veiculo", new Veiculo());

		return mav;
	}	
	
}
