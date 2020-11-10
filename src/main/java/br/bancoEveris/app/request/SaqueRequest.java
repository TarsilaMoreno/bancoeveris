package br.bancoEveris.app.request;

import br.bancoEveris.app.model.BaseResponse;

public class SaqueRequest extends BaseResponse {

	private String hash;
	private Double valor;

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;

	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
