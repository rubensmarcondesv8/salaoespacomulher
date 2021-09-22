package com.elizelia.salaoespacomulher.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonIgnore;

@CrossOrigin("*")
@Entity
public class ContaCorrente implements Serializable{
	private static final long serialVersionUID = -6096951704005867853L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idContaCorrente;
	@NotEmpty(message = "Campo Necessário")
	@Length(min=11, max=11, message="Tamanho do campo incorreto")
	private String numeroContaCorrente;
	
	private BigDecimal saldoContaCorrente;
	
	@OneToOne(mappedBy = "contacorrente")
	private Profissional profissional;
	
	@JsonIgnore
	@OneToMany(mappedBy = "contaCorrente", fetch = FetchType.LAZY)
	private List<Lancamento> extratoContaCorrente;

	public ContaCorrente() {
		super();
	}

	public ContaCorrente(Profissional profissional) {
		super();
		this.numeroContaCorrente = profissional.getNumeroCPF();
		this.saldoContaCorrente = new BigDecimal(0);
		this.profissional = profissional;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
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

	@Override
	public int hashCode() {
		return Objects.hash(idContaCorrente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContaCorrente other = (ContaCorrente) obj;
		return Objects.equals(idContaCorrente, other.idContaCorrente);
	}
	
	public void saidaValor(BigDecimal debito) {
		this.saldoContaCorrente.subtract(debito);
	}
	
	public void entradaValor(BigDecimal credito) {
		this.saldoContaCorrente.add(credito);
	}

	public List<Lancamento> getExtratoContaCorrente() {
		return extratoContaCorrente;
	}

	public void setExtratoContaCorrente(List<Lancamento> extratoContaCorrente) {
		this.extratoContaCorrente = extratoContaCorrente;
	}
	
}
