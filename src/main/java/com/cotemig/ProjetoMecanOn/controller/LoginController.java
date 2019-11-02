package com.cotemig.ProjetoMecanOn.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cotemig.ProjetoMecanOn.model.Usuario;
import com.cotemig.ProjetoMecanOn.service.UsuarioService;

@Controller
public class LoginController {
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping( value = "/Login") 
    public ModelAndView home(){        
        return new ModelAndView("login");
    }	
	
	@RequestMapping(value = "/Login", method = RequestMethod.POST)
	public String submitIncluirUsuario(@Valid @ModelAttribute("usuario")Usuario usuario, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
            return "error";
        }		
		if(usuarioService.getAllUsuarios().contains(usuario)) {
			return "redirect:Home";			
		}else {
			return "Usuário não existe!";
		}
    }

}
