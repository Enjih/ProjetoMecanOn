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

import com.cotemig.ProjetoMecanOn.model.OrdemServico;
import com.cotemig.ProjetoMecanOn.service.ClienteService;
import com.cotemig.ProjetoMecanOn.service.OrdemServicoService;
import com.cotemig.ProjetoMecanOn.service.UsuarioService;

@Controller
public class OrdemServicoController {
	@Autowired
	OrdemServicoService ordemServicoService;
	
	@Autowired
	ClienteService clienteService;
	
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping( value = "/OrdemServico", method = RequestMethod.GET) 
	public ModelAndView OrdemServico(){
		ModelAndView mav = new ModelAndView("ordemServico");

		mav.addObject("ordensServico", ordemServicoService.getAllOrdensServico());
		mav.addObject("clientes", clienteService.getAllClientes());
		mav.addObject("usuarios", usuarioService.getAllUsuarios());
		
		mav.addObject("ordemServico", new OrdemServico()); 	

		return mav;
	}
	
	@RequestMapping(value = "/OrdemServico", method = RequestMethod.POST)
	public String submitIncluirOrdemServico(@Valid @ModelAttribute("ordemServico")OrdemServico ordemServico, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "error";
		}		
		ordemServicoService.insertOrdemServico(ordemServico);     
		return "redirect:OrdemServico";
	}

	@RequestMapping(value = "/OrdemServico/Alterar", method = RequestMethod.GET)
	public ModelAndView AlterarOrdemServico(Integer id) {
		return new ModelAndView("ordemServico_alterar", "ordemServico", ordemServicoService.getOrdemServicoById(id).get());		
	}

	@RequestMapping(value = "/OrdemServico/Alterar", method = RequestMethod.POST)
	public String submitAlterarOrdemServico(@Valid @ModelAttribute("fornecedor")OrdemServico ordemServico,
			BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "error";
		}
		ordemServicoService.updateOrdemServicoById(ordemServico.getId(), ordemServico);

		return "redirect:";
	}
	@RequestMapping(value = "/OrdemServico/Excluir", method = RequestMethod.GET)
	public ModelAndView ExcluirOrdemServico(Integer id) {
		return new ModelAndView("ordemServico_excluir", "ordemServico", ordemServicoService.getOrdemServicoById(id).get());
	}

	@RequestMapping(value = "/OrdemServico/Excluir", method = RequestMethod.POST)
	public String submitExcluirOrdemServico(@Valid @ModelAttribute("ordemServico")OrdemServico ordemServico, BindingResult result, ModelMap model) {	
		if (result.hasErrors()) {			
			return "error";
		}
		ordemServicoService.deleteOrdemServicoById(ordemServico.getId());			
		return "redirect:";
	}
	

}
