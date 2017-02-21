package org.casadocodigo.controllers;

import org.casadocodigo.daos.ProdutoDAO;
import org.casadocodigo.models.CarrinhoCompras;
import org.casadocodigo.models.CarrinhoItem;
import org.casadocodigo.models.Produto;
import org.casadocodigo.models.TipoPreco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/carrinho")
public class CarrinhoComprasController {

  @Autowired
  private CarrinhoCompras carrinho;
	
	@Autowired
	private ProdutoDAO produtoDao;

  @RequestMapping("/add")
  public ModelAndView add(Integer produtoId, TipoPreco tipoPreco) {
      ModelAndView modelAndView = new ModelAndView("redirect:/produtos");
      CarrinhoItem carrinhoItem = criaItem(produtoId,tipoPreco);
      carrinho.add(carrinhoItem);
      return modelAndView;   
  }

  private CarrinhoItem criaItem(Integer produtoId, TipoPreco tipoPreco) {
      Produto produto = produtoDao.find(produtoId);
      CarrinhoItem carrinhoItem = new CarrinhoItem(produto,tipoPreco);
      return carrinhoItem;
  }

}