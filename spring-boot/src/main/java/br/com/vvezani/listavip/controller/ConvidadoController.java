package br.com.vvezani.listavip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.vvezani.enviadorEmail.EmailService;
import br.com.vvezani.listavip.model.Convidado;
import br.com.vvezani.listavip.repository.ConvidadoRepository;

@Controller
public class ConvidadoController {
	
	@Autowired
	private ConvidadoRepository repository;
	
	@Autowired
	private EmailService emailService;
	
	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
	@RequestMapping("listaconvidados")
	public String listaConvidados(Model model){
		
		Iterable<Convidado> convidados = repository.findAll();
		
		model.addAttribute("convidados", convidados);
		
		return "listaconvidados";
	}
	
	@RequestMapping(value = "salvar", method = RequestMethod.POST )
	public String salvar(@RequestParam("nome") String nome, @RequestParam("email")String email, 
			@RequestParam("telefone") String telefone, Model model){
		
		Convidado novoConvidado = new Convidado(nome, email, telefone);
		
		repository.save(novoConvidado);
		
		Iterable<Convidado> convidados = repository.findAll();

		emailService.enviar(nome, email);
		
		model.addAttribute("convidados", convidados);
		
		return "listaconvidados";
		
	}

}
