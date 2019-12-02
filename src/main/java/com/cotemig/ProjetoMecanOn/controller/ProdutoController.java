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

import com.cotemig.ProjetoMecanOn.model.Produto;
import com.cotemig.ProjetoMecanOn.service.FornecedorService;
import com.cotemig.ProjetoMecanOn.service.ProdutoService;

@Controller
public class ProdutoController {
	@Autowired
	private FornecedorService  fornecedorService;

	@Autowired
	private ProdutoService  produtoService;

	@RequestMapping( value = "/Produto", method = RequestMethod.GET) 
	public ModelAndView Produto(){
		ModelAndView mav = new ModelAndView("produto");

		mav.addObject("fornecedores", fornecedorService.getAllFornecedores());
		mav.addObject("produtos", produtoService.getAllProdutos());
		mav.addObject("produto", new Produto()); 

		return mav;
	}	


	@RequestMapping(value = "/Produto", method = RequestMethod.POST)
	public String submitIncluirProduto(@Valid @ModelAttribute("produto")Produto produto, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "error";
		}		
		produtoService.insertProduto(produto);     
		return "redirect:Produto";
	}

	@RequestMapping(value = "/Produto/Alterar", method = RequestMethod.GET)
	public ModelAndView AlterarProduto(Integer id) {
		return new ModelAndView("produto_alterar", "produto", produtoService.getProdutoById(id).get());		
	}

	@RequestMapping(value = "/Produto/Alterar", method = RequestMethod.POST)
	public String submitAlterarProduto(@Valid @ModelAttribute("fornecedor")Produto produto,
			BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "error";
		}
		produtoService.updateProdutoById(produto.getId(), produto);

		return "redirect:";
	}
	@RequestMapping(value = "/Produto/Excluir", method = RequestMethod.GET)
	public ModelAndView ExcluirProduto(Integer id) {
		return new ModelAndView("produto_excluir", "produto", produtoService.getProdutoById(id).get());
	}

	@RequestMapping(value = "/Produto/Excluir", method = RequestMethod.POST)
	public String submitExcluirProduto(@Valid @ModelAttribute("produto")Produto produto, BindingResult result, ModelMap model) {	
		if (result.hasErrors()) {			
			return "error";
		}
		produtoService.deleteProdutoById(produto.getId());			
		return "redirect:";
	}
}
