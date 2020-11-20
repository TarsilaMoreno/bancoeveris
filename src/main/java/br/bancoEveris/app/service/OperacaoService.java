package br.bancoEveris.app.service;

import br.bancoEveris.app.model.BaseResponse;
import br.bancoEveris.app.model.Operacao;

public interface OperacaoService {
	
	public BaseResponse inserir(Operacao operacao);
	public double saldo(Long id);
	
}