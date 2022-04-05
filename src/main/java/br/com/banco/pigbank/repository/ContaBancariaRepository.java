package br.com.banco.pigbank.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.banco.pigbank.model.ContaBancaria;

public interface ContaBancariaRepository extends PagingAndSortingRepository<ContaBancaria, Long>{

}
