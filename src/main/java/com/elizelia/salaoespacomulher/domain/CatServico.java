package com.elizelia.salaoespacomulher.domain;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CatServico {
	@Id
	private String nomeCatServico;
	private String descricaoServico;
	
	@OneToMany(mappedBy = "catServico")
	private List<Servico> servicosLista;
	
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
