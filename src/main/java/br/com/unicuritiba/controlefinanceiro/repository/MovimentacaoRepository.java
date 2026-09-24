package br.com.unicuritiba.controlefinanceiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.unicuritiba.controlefinanceiro.model.Movimentacao;

public interface MovimentacaoRepository 
		extends JpaRepository<Movimentacao, Long> {

}