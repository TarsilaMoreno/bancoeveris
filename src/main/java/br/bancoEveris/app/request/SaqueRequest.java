package br.bancoEveris.app.request;

import br.bancoEveris.app.model.BaseResponse;

public class SaqueRequest extends BaseResponse{

	private String hash;
	private String tipo;
	private double valor;
	
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
}
