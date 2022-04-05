package br.com.banco.pigbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.banco.pigbank.repository.ContaBancariaRepository;
import br.com.banco.pigbank.repository.ContaDigitalRepository;

@Controller
public class BancoController {
	
	@Autowired
	private ContaDigitalRepository repCd;
	
	@Autowired
	private ContaBancariaRepository repCb;
	
	
}
