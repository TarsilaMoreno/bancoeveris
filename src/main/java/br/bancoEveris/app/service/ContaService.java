package br.bancoEveris.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.bancoEveris.app.model.BaseResponse;
import br.bancoEveris.app.model.Conta;
import br.bancoEveris.app.repository.ContaRepository;
import br.bancoEveris.app.spec.ContaSpec;

@Service
public class ContaService {

	final ContaRepository _repository;

	@Autowired
	public ContaService(ContaRepository repository) {
		_repository = repository;

	}

	public BaseResponse inserir(ContaSpec contaSpec) {
		Conta conta = new Conta();
		BaseResponse base = new BaseResponse();

		base.statusCode = 400;

		if (contaSpec.getHash() == "") {
			base.message = "Nome do usuário não preenchido";
			return base;
		}
	
		conta.setHash(contaSpec.getHash());
		

		_repository.save(conta);
		base.statusCode = 201;
		base.message = "Conta cadastrada com sucesso";
		return base;

		
	}

}
	

