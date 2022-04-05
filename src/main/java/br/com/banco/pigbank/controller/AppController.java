package br.com.banco.pigbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.banco.pigbank.model.ContaBancaria;
import br.com.banco.pigbank.model.ContaDigital;
import br.com.banco.pigbank.repository.ContaBancariaRepository;
import br.com.banco.pigbank.repository.ContaDigitalRepository;

@Controller
public class AppController {
	
	@Autowired
	private ContaDigitalRepository contaDigitalRep;
	
	@Autowired
	private ContaBancariaRepository contaBancariaRep;
	
	@RequestMapping("/")
	public String index() {
		return "app/index";
	}
	
	@RequestMapping("cadastro")
	public String cadastro() {
		return "app/cadastro";
	}
	
	@RequestMapping(value = "cadastroConta", method = RequestMethod.POST)
	public String cadastroConta(Model model, ContaDigital cD) {
		contaDigitalRep.save(cD);
		model.addAttribute("cD", cD);
		Long a = cD.getId() + cD.getId() * 200;
		model.addAttribute("conta", a);
		return "app/cadastroBancaria";
	}
	
	@RequestMapping(value = "salvarContaBancaria", method = RequestMethod.POST)
	public String salvarContaBancaria(Model model, ContaBancaria cB, Long idContaDigital) {
		cB.setIdContaDigital(idContaDigital);
		System.out.println(cB.getIdContaDigital());
		System.out.println(cB.getNomeConta());
		System.out.println(cB.getNumeroConta());
		System.out.println(cB.getSaldo());
		System.out.println(cB.getSenhaConta());
		contaBancariaRep.save(cB);
		System.out.println(cB.getId());
		ContaDigital cD = contaDigitalRep.findById(idContaDigital).get();
		model.addAttribute("cD", cD.getId());
		return "forward:bancoInicio";
	}
	
	@RequestMapping("bancoInicio")
	public String inicio(Model model) {
		System.out.println(model.getAttribute("cD"));
		
		return "banco/inicio";
	}
}
