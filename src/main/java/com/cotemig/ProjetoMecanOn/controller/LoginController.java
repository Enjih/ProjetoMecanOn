package com.cotemig.ProjetoMecanOn.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cotemig.ProjetoMecanOn.model.Usuario;

@Controller
public class LoginController {
	@RequestMapping(value = "/Login", method = RequestMethod.POST)
    public ModelAndView submitLogin(@Valid @ModelAttribute("usuario")Usuario usuario,
    	      BindingResult result, ModelMap model){        
        return new ModelAndView("login");
    }

}
