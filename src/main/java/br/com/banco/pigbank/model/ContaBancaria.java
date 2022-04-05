package br.com.banco.pigbank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class ContaBancaria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long idContaDigital;
	private String nomeConta;
	@Column(unique = true)
	private Long numeroConta;
	private double saldo;
	private int senhaConta;
}
