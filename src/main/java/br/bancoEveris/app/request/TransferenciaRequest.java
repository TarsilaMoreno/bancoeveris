package br.bancoEveris.app.request;

public class TransferenciaRequest {

	private String hash;
	private Double valor;
	private Long idContaOrigem;
	private Long idContaDestino;
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
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
