package br.bancoEveris.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.bancoEveris.app.model.Conta;
import br.bancoEveris.app.model.Operacao;
import br.bancoEveris.app.repository.OperacaoRepository;

@Service
public class OperacaoService {
	
	final OperacaoRepository _repository;
	
	@Autowired
	public OperacaoService(OperacaoRepository repository) {
		_repository = repository;
	}
	
	public double saldo(Long id) {
		double saldo = 0;
		
		Conta contaOrigem = new Conta();
		contaOrigem.setId(id);
		
		Conta contaDestino = new Conta();
		contaDestino.setId(id);
		
		List<Operacao> listaOrigem = _repository.findByContaOrigem(contaOrigem);		
		List<Operacao> listaDestino = _repository.findByContaDestino(contaDestino);
		
		for(Operacao o : listaOrigem) {
			switch(o.getTipo()) {
			case "D":
				saldo += o.getValor();
				break;
			case "S":
				saldo -= o.getValor();
				break;
			case "T":
				saldo -= o.getValor();
				break;
			default:
				break;
			}
		}
		
		for(Operacao o : listaDestino) {
			switch(o.getTipo()) {
			case "D":
				saldo += o.getValor();
				break;
			case "S":
				saldo -= o.getValor();
				break;
			case "T":
				saldo += o.getValor();
				break;
			default:
				break;
			}
		}
		return saldo;
	}
}
