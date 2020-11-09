package br.bancoEveris.app.spec;

import java.util.List;

import br.bancoEveris.app.model.BaseResponse;
import br.bancoEveris.app.model.Conta;

public class ContaList extends BaseResponse {
	private List<Conta> Contas;
	
	public List<Conta> getContas() {
		return Contas;
	}
	
	public void setContas(List<Conta> contas) {
		Contas = contas;
	}
}
