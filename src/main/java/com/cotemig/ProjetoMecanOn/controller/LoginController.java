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
import com.cotemig.ProjetoMecanOn.service.UsuarioService;

@Controller
public class LoginController {
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping( value = "/Login", method = RequestMethod.GET) 
    public ModelAndView Login(){
        return new ModelAndView("login");
    }
	
	@RequestMapping(value = "/Login", method = RequestMethod.POST)
	public String submitLogin(@Valid @ModelAttribute("usuario")Usuario usuario, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
            return "error";
        }
		
		for(Usuario u : usuarioService.getAllUsuarios()) {				
			if(u.getEmail().equals(usuario.getEmail())) {
				if(u.getSenha().equals(usuario.getSenha())) {
					return "redirect:Home";				
				}else {
					return "error";
				}
			}
		}
		return "error";
    }

}
