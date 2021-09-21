package com.elizelia.salaoespacomulher.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonIgnore;

@CrossOrigin("*")
@Entity
public class Profissional implements Serializable{
	
	private static final long serialVersionUID = 4471858427625233249L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProfissional;
	@NotEmpty(message = "Campo necessário")
	@Length(min = 3, max = 50, message = "Tamanho do campo incorreto.")
	private String nomeProfissional;
	@NotEmpty(message = "Campo necessário")
	@Length(min = 10, max = 11, message = "Tamanho do campo incorreto.")
	private String telefoneProfissional;
	@NotEmpty(message = "Campo necessário")
	@Length(min = 11, max = 11, message = "Tamanho do campo incorreto.")
	private String numeroCPF;
	@NotEmpty(message = "Campo necessário")
	@Length(min = 3, max = 80, message = "Tamanho do campo incorreto.")
	private String enderecoCompleto;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "profissionais", cascade = CascadeType.PERSIST)
	private List<CatProfissional> catProfissional = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "profissionalVenda", fetch = FetchType.LAZY)
	private List<ItemVenda> itensVenda = new ArrayList<>();

	public Profissional() {
		super();
	}

	public Profissional(String nomeProfissional, String telefoneProfissional, String numeroCPF, String enderecoCompleto) {
		super();
		this.nomeProfissional = nomeProfissional;
		this.telefoneProfissional = telefoneProfissional;
		this.numeroCPF = numeroCPF;
		this.enderecoCompleto = enderecoCompleto;
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
