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

import com.cotemig.ProjetoMecanOn.model.Fornecedor;
import com.cotemig.ProjetoMecanOn.service.FornecedorService;

@Controller
public class FornecedorController {
	@Autowired
	private FornecedorService  fornecedorService;

	@RequestMapping( value = "/Fornecedor", method = RequestMethod.GET) 
	public ModelAndView Fornecedor(){
		ModelAndView mav = new ModelAndView("fornecedor");
		mav.addObject("fornecedores", fornecedorService.getAllFornecedores());
		mav.addObject("fornecedor", new Fornecedor());

		return mav;
	}	

	@RequestMapping(value = "/Fornecedor", method = RequestMethod.POST)
	public String submitIncluirFornecedor(@Valid @ModelAttribute("fornecedor")Fornecedor fornecedor, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "error";
		}		
		fornecedorService.insertFornecedor(fornecedor);        
		return "redirect:Fornecedor";
	}

	@RequestMapping(value = "/Fornecedor/Alterar", method = RequestMethod.GET)
	public ModelAndView AlterarFornecedor(Integer id) {
		return new ModelAndView("fornecedor_alterar", "fornecedor", fornecedorService.getFornecedorById(id).get());		
	}

	@RequestMapping(value = "/Fornecedor/Alterar", method = RequestMethod.POST)
	public String submitAlterarFornecedor(@Valid @ModelAttribute("fornecedor")Fornecedor fornecedor,
			BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "error";
		}
		fornecedorService.updateFornecedorById(fornecedor.getId(), fornecedor);

		return "redirect:";
	}
	@RequestMapping(value = "/Fornecedor/Excluir", method = RequestMethod.GET)
	public ModelAndView ExcluirFornecedor(Integer id) {
		return new ModelAndView("fornecedor_excluir", "fornecedor", fornecedorService.getFornecedorById(id).get());
	}

	@RequestMapping(value = "/Fornecedor/Excluir", method = RequestMethod.POST)
	public String submitExcluirFornecedor(@Valid @ModelAttribute("fornecedor")Fornecedor fornecedor, BindingResult result, ModelMap model) {	
		if (result.hasErrors()) {			
			return "error";
		}
		fornecedorService.deleteFornecedorById(fornecedor.getId());		        
		return "redirect:";
	}
}
