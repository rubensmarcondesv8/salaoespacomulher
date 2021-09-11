package com.elizelia.salaoespacomulher.domain;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Servico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idServico;
	private String nomeServico;
	private String descrServico;
	private BigDecimal precoBaseServico;
	@ManyToOne
	private CatServico catServico;
	public Servico() {
		super();
	}
	public Servico(String nomeServico, String descrServico, BigDecimal precoBaseServico, CatServico catServico) {
		super();
		this.nomeServico = nomeServico;
		this.descrServico = descrServico;
		this.precoBaseServico = precoBaseServico;
		this.catServico = catServico;
	}
	public Long getIdServico() {
		return idServico;
	}
	public void setIdServico(Long idServico) {
		this.idServico = idServico;
	}
	public String getNomeServico() {
		return nomeServico;
	}
	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}
	public String getDescrServico() {
		return descrServico;
	}
	public void setDescrServico(String descrServico) {
		this.descrServico = descrServico;
	}
	public BigDecimal getPrecoBaseServico() {
		return precoBaseServico;
	}
	public void setPrecoBaseServico(BigDecimal precoBaseServico) {
		this.precoBaseServico = precoBaseServico;
	}
	public CatServico getCatServico() {
		return catServico;
	}
	public void setCatServico(CatServico catServico) {
		this.catServico = catServico;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idServico);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Servico other = (Servico) obj;
		return Objects.equals(idServico, other.idServico);
	}

}
