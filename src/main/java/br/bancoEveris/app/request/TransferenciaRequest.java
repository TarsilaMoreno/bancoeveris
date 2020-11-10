package br.bancoEveris.app.request;

public class TransferenciaRequest {

	
	private Double valor;
	private Long idContaOrigem;
	private Long idContaDestino;
	
	
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Long getIdContaOrigem() {
		return idContaOrigem;
	}
	public void setIdContaOrigem(Long idContaOrigem) {
		this.idContaOrigem = idContaOrigem;
	}
	public Long getIdContaDestino() {
		return idContaDestino;
	}
	public void setIdContaDestino(Long idContaDestino) {
		this.idContaDestino = idContaDestino;
	}
	
	
}
