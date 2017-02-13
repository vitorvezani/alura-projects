package org.casadocodigo.controllers;

import org.casadocodigo.daos.ProdutoDAO;
import org.casadocodigo.models.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProdutosController {

  @Autowired
  private ProdutoDAO produtoDao;
	
	@RequestMapping("/produtos")
	public String gravar(Produto produto) {
		System.out.println(produto);
		produtoDao.gravar(produto);
		return "/produtos/ok";
	}
	
  @RequestMapping("/produtos/form")
  public String form(){
      return "produtos/form";
  }

}