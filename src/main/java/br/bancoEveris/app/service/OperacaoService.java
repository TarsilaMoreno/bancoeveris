package br.bancoEveris.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.bancoEveris.app.repository.OperacaoRepository;

@Service
public class OperacaoService {
	
	final OperacaoRepository _repository;
	
	@Autowired
	public OperacaoService(OperacaoRepository repository) {
		_repository = repository;
		
	}
	

}
