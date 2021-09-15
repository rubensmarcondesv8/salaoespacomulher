package com.elizelia.salaoespacomulher.domain;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduto;
	private String nomeProduto;
	private String descProduto;
	private BigDecimal precoUnitario;
	@JsonIgnore
	@ManyToOne
	private CatProduto catProduto;
	
	public Produto() {
	}

	public Produto(String nomeProduto, String descProduto, BigDecimal precoUnitario, CatProduto catProduto) {
		super();
		this.nomeProduto = nomeProduto;
		this.descProduto = descProduto;
		this.precoUnitario = precoUnitario;
		this.catProduto = catProduto;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getDescProduto() {
		return descProduto;
	}

	public void setDescProduto(String descProduto) {
		this.descProduto = descProduto;
	}

	public BigDecimal getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(BigDecimal precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public CatProduto getCatProduto() {
		return catProduto;
	}

	public void setCatProduto(CatProduto catProduto) {
		this.catProduto = catProduto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idProduto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(idProduto, other.idProduto);
	}

}
