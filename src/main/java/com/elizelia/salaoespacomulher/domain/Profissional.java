package com.elizelia.salaoespacomulher.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Profissional{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProfissional;
	private String nomeProfissional;
	private String telefoneProfissional;
	private String numeroCPF;
	private String enderecoCompleto;
	
	@ManyToMany(mappedBy = "profissionais", cascade = CascadeType.PERSIST)
	private List<CatProfissional> catProfissional = new ArrayList<>();

	public Profissional() {
		super();
	}

	public Profissional(String nomeProfissional, String telefoneProfissional, String numeroCPF,
			List<CatProfissional> catProfissional) {
		super();
		this.nomeProfissional = nomeProfissional;
		this.telefoneProfissional = telefoneProfissional;
		this.numeroCPF = numeroCPF;
		this.catProfissional = catProfissional;
	}

	public Long getIdProfissional() {
		return idProfissional;
	}

	public void setIdProfissional(Long idProfissional) {
		this.idProfissional = idProfissional;
	}

	public String getNomeProfissional() {
		return nomeProfissional;
	}

	public void setNomeProfissional(String nomeProfissional) {
		this.nomeProfissional = nomeProfissional;
	}

	public String getTelefoneProfissional() {
		return telefoneProfissional;
	}

	public void setTelefoneProfissional(String telefoneProfissional) {
		this.telefoneProfissional = telefoneProfissional;
	}

	public String getNumeroCPF() {
		return numeroCPF;
	}

	public void setNumeroCPF(String numeroCPF) {
		this.numeroCPF = numeroCPF;
	}

	public String getEnderecoCompleto() {
		return enderecoCompleto;
	}

	public void setEnderecoCompleto(String enderecoCompleto) {
		this.enderecoCompleto = enderecoCompleto;
	}

	public List<CatProfissional> getCatProfissional() {
		return catProfissional;
	}

	public void setCatProfissional(List<CatProfissional> catProfissional) {
		this.catProfissional = catProfissional;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idProfissional);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profissional other = (Profissional) obj;
		return Objects.equals(idProfissional, other.idProfissional);
	}

	
	
}
