package org.casadocodigo.controllers;

import org.casadocodigo.models.CarrinhoCompras;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import models.DadosPagamento;

@RequestMapping("/pagamento")
@Controller
public class PagamentoController {

	@Autowired
	CarrinhoCompras carrinho;

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value = "/finalizar", method = RequestMethod.POST)
	public ModelAndView finalizar(RedirectAttributes model) {

		String uri = "http://book-payment.herokuapp.com/payment";
		String response = restTemplate.postForObject(uri, new DadosPagamento(carrinho.getTotal()), String.class);

		model.addFlashAttribute("message", response);
		System.out.println(response);

		return new ModelAndView("redirect:/produtos");
	}

}
