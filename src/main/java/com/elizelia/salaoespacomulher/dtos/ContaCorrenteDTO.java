package com.elizelia.salaoespacomulher.dtos;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.elizelia.salaoespacomulher.domain.ContaCorrente;

public class ContaCorrenteDTO implements Serializable{

	private static final long serialVersionUID = 6471844776954119856L;
	
	private Long idContaCorrente;
	@NotEmpty(message = "Campo Necessário")
	@Length(min=11, max=11, message="Tamanho do campo incorreto")
	private String numeroContaCorrente;
	
	private BigDecimal saldoContaCorrente;

	public ContaCorrenteDTO() {
		super();
	}

	public ContaCorrenteDTO(ContaCorrente obj) {
		super();
		this.idContaCorrente = obj.getIdContaCorrente();
		this.numeroContaCorrente = obj.getNumeroContaCorrente();
		this.saldoContaCorrente = obj.getSaldoContaCorrente();
	}

	public Long getIdContaCorrente() {
		return idContaCorrente;
	}

	public void setIdContaCorrente(Long idContaCorrente) {
		this.idContaCorrente = idContaCorrente;
	}

	public String getNumeroContaCorrente() {
		return numeroContaCorrente;
	}

	public void setNumeroContaCorrente(String numeroContaCorrente) {
		this.numeroContaCorrente = numeroContaCorrente;
	}

	public BigDecimal getSaldoContaCorrente() {
		return saldoContaCorrente;
	}

	public void setSaldoContaCorrente(BigDecimal saldoContaCorrente) {
		this.saldoContaCorrente = saldoContaCorrente;
	}

}
