package br.com.unicuritiba.controlefinanceiro.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.unicuritiba.controlefinanceiro.model.Movimentacao;
import br.com.unicuritiba.controlefinanceiro.repository.MovimentacaoRepository;

@RestController
public class MovimentacaoController {

	private final MovimentacaoRepository repositorio;

	MovimentacaoController(MovimentacaoRepository repositorio) {
		this.repositorio = repositorio;
	}
	
	@GetMapping("/movimentacoes")
	public ResponseEntity<List<Movimentacao>> getMovimentacoes() {
		
		List<Movimentacao> movimentacoes = repositorio.findAll();
		return ResponseEntity.ok(movimentacoes);
	}
	
	@GetMapping("/movimentacoes/{id}")
	public ResponseEntity<Movimentacao> getMovimentacaoById(
			@PathVariable long id){
		
		Movimentacao movimentacao = repositorio.getReferenceById(id);
		return ResponseEntity.ok(movimentacao);
	}
	
	@DeleteMapping("/movimentacoes/{id}")
	public ResponseEntity<Movimentacao> deleteMovimentacaoById(
			@PathVariable long id){
		
		repositorio.deleteById(id);
		return ResponseEntity.ok(null);
	}
	
	@PutMapping("/movimentacoes/{id}")
	public ResponseEntity<Movimentacao> updateMovimentacaoById(
			@PathVariable long id,
			@RequestBody Movimentacao movimentacao){
		
		movimentacao.setId(id);
		Movimentacao movimentacaoAtualizada = repositorio.save(movimentacao);
		return ResponseEntity.ok(movimentacaoAtualizada);
	}
	
	@PostMapping("/movimentacoes")
	public ResponseEntity<Movimentacao> saveMovimentacao(
			@RequestBody Movimentacao movimentacao){
		
		Movimentacao movimentacaoSalva = repositorio.save(movimentacao);
		return ResponseEntity.ok(movimentacaoSalva);
	}

	@GetMapping("/movimentacoes/saldo")
	public ResponseEntity<Double> getSaldo(
			@RequestParam int mes,
			@RequestParam int ano){
		
		List<Movimentacao> todasMovimentacoes = repositorio.findAll();
		Double saldo = 0.0;
		
		for (Movimentacao m : todasMovimentacoes) {
			if (m.getData().getYear() == ano && m.getData().getMonthValue() == mes) {
				if (m.getTipo() == Movimentacao.TipoMovimentacao.RECEITA) {
					saldo += m.getValor();
				} else {
					saldo -= m.getValor();
				}
			}
		}
		
		return ResponseEntity.ok(saldo);
	}
	
}