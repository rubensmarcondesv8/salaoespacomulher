package com.elizelia.salaoespacomulher.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CatServico {
	@Id
	private String nomeCatServico;
	private String descrCatServico;
	
	@OneToMany(mappedBy = "catServico", fetch = FetchType.LAZY)
	private List<Servico> servicosLista = new ArrayList<>();
	
	public List<Servico> getServicosLista() {
		return servicosLista;
	}

	public void setServicosLista(List<Servico> servicosLista) {
		this.servicosLista = servicosLista;
	}

	public String getNomeCatServico() {
		return nomeCatServico;
	}

	public void setNomeCatServico(String nomeCatServico) {
		this.nomeCatServico = nomeCatServico;
	}

	public String getDescrCatServico() {
		return descrCatServico;
	}

	public void setDescrCatServico(String descrCatServico) {
		this.descrCatServico = descrCatServico;
	}

	public CatServico() {
		super();
	}

	public CatServico(String nomeCatServico, String descrCatServico) {
		super();
		this.nomeCatServico = nomeCatServico;
		this.descrCatServico = descrCatServico;
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
