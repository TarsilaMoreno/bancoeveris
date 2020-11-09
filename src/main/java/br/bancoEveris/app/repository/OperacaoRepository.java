package br.bancoEveris.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.bancoEveris.app.model.Conta;
import br.bancoEveris.app.model.Operacao;

@Repository
public interface OperacaoRepository extends JpaRepository<Operacao, Long> {
	
	List<Operacao> findByContaOrigem(Conta contaOrigem);
	List<Operacao> findByContaDestino(Conta contaDestino);
}
