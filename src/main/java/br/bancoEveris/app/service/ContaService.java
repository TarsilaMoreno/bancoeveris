package br.bancoEveris.app.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.bancoEveris.app.model.BaseResponse;
import br.bancoEveris.app.model.Conta;
import br.bancoEveris.app.repository.ContaRepository;
import br.bancoEveris.app.spec.ContaList;
import br.bancoEveris.app.spec.ContaSpec;

@Service
public class ContaService {

	final ContaRepository _repository;
	final OperacaoService _operacaoService;

	@Autowired
	public ContaService(ContaRepository repository, OperacaoService operacaoService) {
		_repository = repository;
		_operacaoService = operacaoService;

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
	
	public ContaList obter() {
		List<Conta> contas = _repository.findAll();
		
		ContaList base = new ContaList();
		base.setContas(contas);
		base.statusCode = 200;
		base.message = "Contas obtidas com sucesso.";
		return base;
	}
	
	public Conta obterByHash(String hash) {
		Conta conta = _repository.findByHash(hash);
		
//		verifica se contas está vazio
		if(conta == null) {
			conta = new Conta();
			conta.statusCode = 400;
			conta.message = "Hash não encontrado.";
			return conta;
		}
		conta.statusCode = 200;
		conta.message = "Conta encontrada.";
		return conta;
	}
	
	
	public Conta editar(String hash, ContaSpec contaSpec) {
		Conta conta = _repository.findByHash(hash);
		
		if(contaSpec.getHash().isEmpty()) {
			conta.statusCode = 400;
			conta.message = "Hash não encontrado.";
			return conta;
		}
		
		conta.setHash(contaSpec.getHash());
		_repository.save(conta);
		conta.statusCode = 200;
		conta.message = "Conta atualizada.";
		return conta;
	}
	
	public BaseResponse deletar(String hash) {
		Conta conta = _repository.findByHash(hash);
		
		if(hash.isEmpty()) {
			conta.statusCode = 400;
			conta.message = "Hash não encontrado.";
			return conta;
		}
		
		_repository.delete(conta);
		conta.statusCode = 200;
		conta.message = "Conta deletada.";
		return conta;
	}
	
	public Conta saldo(String hash) {
		Conta response = new Conta();
		
		response.statusCode = 400;
		
		Conta lista = _repository.findByHash(hash);
		if(lista == null) {
			response.message = "Conta não encontrada.";
			return response;
		}
		
		double saldo = _operacaoService.saldo(lista.getId());
		response.setSaldo(saldo);
		response.setHash(lista.getHash());
		response.statusCode = 200;
		return response;
	}
}

