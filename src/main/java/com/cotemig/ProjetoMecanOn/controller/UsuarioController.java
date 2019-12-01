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

import com.cotemig.ProjetoMecanOn.model.Usuario;
import com.cotemig.ProjetoMecanOn.service.PerfilService;
import com.cotemig.ProjetoMecanOn.service.UsuarioService;

@Controller
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private PerfilService perfilService;

	@RequestMapping( value = "/Usuario", method = RequestMethod.GET) 
	public ModelAndView usuario(){
		ModelAndView mav = new ModelAndView("usuario");

		mav.addObject("usuarios", usuarioService.getAllUsuarios());
		mav.addObject("usuario", new Usuario());
		mav.addObject("perfis", perfilService.getAllPerfis());

		return mav;
	}	

	@RequestMapping(value = "/Usuario", method = RequestMethod.POST)
	public String submitIncluirUsuario(@Valid @ModelAttribute("usuario")Usuario usuario, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "error";
		}

		usuarioService.insertUsuario(usuario);

		return "redirect:Usuario";
	}

	@RequestMapping(value = "/Usuario/Alterar", method = RequestMethod.GET)
	public ModelAndView AlterarUsuario(Integer id) {
		ModelAndView mav = new ModelAndView("usuario_alterar", "usuario", usuarioService.getUsuarioById(id).get());
		mav.addObject("perfis", perfilService.getAllPerfis());
		return mav;		
	}

	@RequestMapping(value = "/Usuario/Alterar", method = RequestMethod.POST)
	public String submitAlterarUsuario(@Valid @ModelAttribute("usuario")Usuario usuario,
			BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "error";
		}

		return "redirect:";
	}

	@RequestMapping(value = "/Usuario/Excluir", method = RequestMethod.GET)
	public ModelAndView ExcluirUsuario(Integer id) {
		return new ModelAndView("usuario_excluir", "usuario", usuarioService.getUsuarioById(id).get());
	}

	@RequestMapping(value = "/Usuario/Excluir", method = RequestMethod.POST)
	public String submitExcluirUsuario(@Valid @ModelAttribute("usuario")Usuario usuario, BindingResult result, ModelMap model) {	
		if (result.hasErrors()) {
			return "error";
		}

		usuarioService.deleteUsuarioById(usuario.getId());		        
		return "redirect:Usuario";
	}
}
