package com.elizelia.salaoespacomulher.domain;

import java.util.Objects;

public class CatServico extends EntidadeBase{
	private String nomeCatServico;
	private String descricaoServico;
	public String getNomeCatServico() {
		return nomeCatServico;
	}
	public void setNomeCatServico(String nomeCatServico) {
		this.nomeCatServico = nomeCatServico;
	}
	public String getDescricaoServico() {
		return descricaoServico;
	}
	public void setDescricaoServico(String descricaoServico) {
		this.descricaoServico = descricaoServico;
	}
	public CatServico() {
		super();
	}
	public CatServico(Long id) {
		super(id);
	}
	public CatServico(String nomeCatServico, String descricaoServico) {
		super();
		this.nomeCatServico = nomeCatServico;
		this.descricaoServico = descricaoServico;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(nomeCatServico);
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
		CatServico other = (CatServico) obj;
		return Objects.equals(nomeCatServico, other.nomeCatServico);
	}
	
	
}
