package com.elizelia.salaoespacomulher.dtos;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.elizelia.salaoespacomulher.domain.ContaCorrente;
import com.elizelia.salaoespacomulher.domain.Profissional;

public class ContaCorrenteDTO implements Serializable{

	private static final long serialVersionUID = 6471844776954119856L;
	
	private Long idContaCorrente;
	
	@NotEmpty(message = "Campo Necessário")
	@Length(min=11, max=11, message="Tamanho do campo incorreto")
	private String numeroContaCorrente;
	
	private BigDecimal saldoContaCorrente;
	
	private Profissional profissional;

	public ContaCorrenteDTO() {
		super();
	}

	public ContaCorrenteDTO(ContaCorrente obj) {
		super();
		this.idContaCorrente = obj.getIdContaCorrente();
		this.numeroContaCorrente = obj.getNumeroContaCorrente();
		this.saldoContaCorrente = obj.getSaldoContaCorrente();
		this.profissional = obj.getProfissional();
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

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

}
