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
		char [] tipos = new char[]{'C', 'M'};


		mav.addObject("clientes", clienteService.getAllClientes());
		mav.addObject("veiculos", veiculoService.getAllVeiculos());
		mav.addObject("tipos", tipos);
		mav.addObject("veiculo", new Veiculo()); 

		return mav;
	}	


	@RequestMapping(value = "/Veiculo", method = RequestMethod.POST)
	public String submitIncluirVeiculo(@Valid @ModelAttribute("veiculo")Veiculo veiculo, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "error";
		}		
		veiculoService.insertVeiculo(veiculo);     
		clienteService.getClienteById(veiculo.getCliente().getId()).get().getVeiculos().add(veiculo);
		return "redirect:Veiculo";
	}

	@RequestMapping(value = "/Veiculo/Alterar", method = RequestMethod.GET)
	public ModelAndView AlterarVeiculo(Integer id) {
		return new ModelAndView("veiculo_alterar", "veiculo", veiculoService.getVeiculoById(id).get());		
	}

	@RequestMapping(value = "/Veiculo/Alterar", method = RequestMethod.POST)
	public String submitAlterarVeiculo(@Valid @ModelAttribute("cliente")Veiculo veiculo,
			BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "error";
		}
		veiculoService.updateVeiculoById(veiculo.getId(), veiculo);

		return "redirect:";
	}
	@RequestMapping(value = "/Veiculo/Excluir", method = RequestMethod.GET)
	public ModelAndView ExcluirVeiculo(Integer id) {
		return new ModelAndView("veiculo_excluir", "veiculo", veiculoService.getVeiculoById(id).get());
	}

	@RequestMapping(value = "/Veiculo/Excluir", method = RequestMethod.POST)
	public String submitExcluirVeiculo(@Valid @ModelAttribute("veiculo")Veiculo veiculo, BindingResult result, ModelMap model) {	
		if (result.hasErrors()) {			
			return "error";
		}
		veiculoService.deleteVeiculoById(veiculo.getId());			
		return "redirect:";
	}
}
