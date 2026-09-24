package br.com.unicuritiba.controlefinanceiro.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Movimentacao {

    public enum TipoMovimentacao {
        RECEITA,
        DESPESA
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String descricao;
    private Double valor;

    @Enumerated(EnumType.STRING)
    private TipoMovimentacao tipo;

    private LocalDate data;
    private String categoria;

    public Movimentacao() {}

    public long getId() { 
    	return id; 
    	}
    
    public void setId(long id) { 
    	this.id = id; 
    	}

    public String getDescricao() { 
    	return descricao; 
    	}
    
    public void setDescricao(String descricao) { 
    	this.descricao = descricao;
    	}

    public Double getValor() { 
    	return valor; 
    	}
    
    public void setValor(Double valor) { 
    	this.valor = valor; 
    	}

    public TipoMovimentacao getTipo() { 
    	return tipo; 
    	}
    public void setTipo(TipoMovimentacao tipo) { 
    	this.tipo = tipo; 
    	}

    public LocalDate getData() { 
    	return data; 
    	}
    
    public void setData(LocalDate data) { 
    	this.data = data; 
    	}

    public String getCategoria() { 
    	return categoria; 
    	}
    
    public void setCategoria(String categoria) { 
    	this.categoria = categoria; 
    	}
}
