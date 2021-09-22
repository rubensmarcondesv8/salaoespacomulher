package com.elizelia.salaoespacomulher.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@Entity
public class CatProfissional {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCatProfissional;
	@NotEmpty(message = "Campo necessário")
	@Length(min = 3, max = 50, message = "Tamanho do campo incorreto.")
	private String nomeCatProfissional;
	@NotEmpty(message = "Campo necessário")
	@Length(min = 3, max = 80, message = "Tamanho do campo incorreto.")
	private String descCatProfissional;
	
	private BigDecimal comissaoCobradaSalao;
	
	@ManyToMany(mappedBy="catProfissional", cascade = CascadeType.ALL)
	private List<Profissional> profissionais = new ArrayList<>();

	public Long getIdCatProfissional() {
		return idCatProfissional;
	}

	public void setIdCatProfissional(Long idCatProfissional) {
		this.idCatProfissional = idCatProfissional;
	}

	public CatProfissional() {
		super();
	}

	public CatProfissional(String nomeCatProfissional, String descCatProfissional, BigDecimal comissaoCobradaSalao) {
		super();
		this.nomeCatProfissional = nomeCatProfissional;
		this.descCatProfissional = descCatProfissional;
		this.comissaoCobradaSalao = comissaoCobradaSalao;
	}

	public BigDecimal getComissaoCobradaSalao() {
		return comissaoCobradaSalao;
	}

	public void setComissaoCobradaSalao(BigDecimal comissaoCobradaSalao) {
		this.comissaoCobradaSalao = comissaoCobradaSalao;
	}

	public String getNomeCatProfissional() {
		return nomeCatProfissional;
	}

	public void setNomeCatProfissional(String nomeCatProfissional) {
		this.nomeCatProfissional = nomeCatProfissional;
	}

	public String getDescCatProfissional() {
		return descCatProfissional;
	}

	public void setDescCatProfissional(String descCatProfissional) {
		this.descCatProfissional = descCatProfissional;
	}
	public List<Profissional> getProfissionais() {
		return profissionais;
	}
	
	public void setProfissionais(List<Profissional> profissionais) {
		this.profissionais = profissionais;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCatProfissional);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CatProfissional other = (CatProfissional) obj;
		return Objects.equals(idCatProfissional, other.idCatProfissional);
	}
	
	


}
