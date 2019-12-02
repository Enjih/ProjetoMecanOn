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

import com.cotemig.ProjetoMecanOn.model.Perfil;
import com.cotemig.ProjetoMecanOn.service.PerfilService;

@Controller
public class PerfilController {
	@Autowired
	private PerfilService  perfilService;
	
	@RequestMapping( value = "/Perfil", method = RequestMethod.GET) 
	public ModelAndView Perfil(){
		ModelAndView mav = new ModelAndView("perfil");
		char [] tipos = new char[]{'E', 'G', 'O'};

		mav.addObject("tipos", tipos);
		mav.addObject("perfil", new Perfil()); 

		return mav;
	}	

	
	@RequestMapping(value = "/Perfil", method = RequestMethod.POST)
	public String submitIncluirPerfil(@Valid @ModelAttribute("perfil")Perfil perfil, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "error";
		}		
		perfilService.insertPerfil(perfil);     
		return "redirect:Perfil";
	}

	@RequestMapping(value = "/Perfil/Alterar", method = RequestMethod.GET)
	public ModelAndView AlterarPerfil(Integer id) {
		return new ModelAndView("perfil_alterar", "perfil", perfilService.getPerfilById(id).get());		
	}

	@RequestMapping(value = "/Perfil/Alterar", method = RequestMethod.POST)
	public String submitAlterarPerfil(@Valid @ModelAttribute("cliente")Perfil perfil,
			BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "error";
		}
		perfilService.updatePerfilById(perfil.getId(), perfil);

		return "redirect:";
	}
	@RequestMapping(value = "/Perfil/Excluir", method = RequestMethod.GET)
	public ModelAndView ExcluirPerfil(Integer id) {
		return new ModelAndView("perfil_excluir", "perfil", perfilService.getPerfilById(id).get());
	}

	@RequestMapping(value = "/Perfil/Excluir", method = RequestMethod.POST)
	public String submitExcluirPerfil(@Valid @ModelAttribute("perfil")Perfil perfil, BindingResult result, ModelMap model) {	
		if (result.hasErrors()) {			
			return "error";
		}
		perfilService.deletePerfilById(perfil.getId());			
		return "redirect:";
	}
}
