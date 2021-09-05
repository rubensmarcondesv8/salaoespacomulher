package com.elizelia.salaoespacomulher.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Servico extends EntidadeBase{
	private String nomeServico;
	private String descrServico;
	private CatServico catServico;
	private TipoFatServico tipoFatServico;
	private BigDecimal precoBaseServico;
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
	public CatServico getCatServico() {
		return catServico;
	}
	public void setCatServico(CatServico catServico) {
		this.catServico = catServico;
	}
	public TipoFatServico getTipoFatServico() {
		return tipoFatServico;
	}
	public void setTipoFatServico(TipoFatServico tipoFatServico) {
		this.tipoFatServico = tipoFatServico;
	}
	public BigDecimal getPrecoBaseServico() {
		return precoBaseServico;
	}
	public void setPrecoBaseServico(BigDecimal precoBaseServico) {
		this.precoBaseServico = precoBaseServico;
	}
	public Servico() {
		super();
	}
	public Servico(Long id) {
		super(id);
	}
	public Servico(String nomeServico, String descrServico, CatServico catServico, TipoFatServico tipoFatServico,
			BigDecimal precoBaseServico) {
		super();
		this.nomeServico = nomeServico;
		this.descrServico = descrServico;
		this.catServico = catServico;
		this.tipoFatServico = tipoFatServico;
		this.precoBaseServico = precoBaseServico;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(nomeServico);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Servico other = (Servico) obj;
		return Objects.equals(nomeServico, other.nomeServico);
	}
	
	
	
}
