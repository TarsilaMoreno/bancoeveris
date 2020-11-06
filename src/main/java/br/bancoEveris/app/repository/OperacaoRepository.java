package br.bancoEveris.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.bancoEveris.app.model.Operacao;

@Repository
public interface OperacaoRepository extends JpaRepository<Operacao, Long> {

}
