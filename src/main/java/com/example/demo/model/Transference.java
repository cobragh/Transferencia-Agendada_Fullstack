package com.example.demo.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Transference {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length=6)
	private Integer contaOrigem;
	
	@Column(length=6)
	private Integer contaDestino;
	
	private LocalDate dataTransference;
	
	private LocalDate dataAgendada;
	
	private BigDecimal valor;
	
	private BigDecimal taxa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(Integer contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public Integer getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(Integer contaDestino) {
		this.contaDestino = contaDestino;
	}

	public LocalDate getDataTransference() {
		LocalDate data = LocalDate.now();
		return data;
	}

	public void setDataTransference(LocalDate dataTransference) {
		this.dataTransference = dataTransference;
	}

	public LocalDate getDataAgendada() {
		LocalDate data = LocalDate.now();
		return data;
	}

	public void setDataAgendada(LocalDate dataAgendada) {
		this.dataAgendada = dataAgendada;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getTaxa() {
		if (Objects.isNull(this.taxa)) {
			this.taxa = BigDecimal.ZERO;
		}
		return taxa;
	}

	public void setTaxa(BigDecimal taxa) {
		this.taxa = taxa;
	}


}
