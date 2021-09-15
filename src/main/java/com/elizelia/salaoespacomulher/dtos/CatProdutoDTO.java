package com.elizelia.salaoespacomulher.dtos;

import java.io.Serializable;

import javax.persistence.Column;

import com.elizelia.salaoespacomulher.domain.CatProduto;

public class CatProdutoDTO implements Serializable{

	private static final long serialVersionUID = -3479380782361675603L;
	
	private String nomeCatProduto;
	@Column(nullable = false, unique = true, length = 100)
	private String descCatProduto;
	
	public CatProdutoDTO() {
		super();
	}

	public CatProdutoDTO(CatProduto obj) {
		super();
		this.nomeCatProduto = obj.getNomeCatProduto();
		this.descCatProduto = obj.getDescCatProduto();
	}

	public String getNomeCatProduto() {
		return nomeCatProduto;
	}

	public void setNomeCatProduto(String nomeCatProduto) {
		this.nomeCatProduto = nomeCatProduto;
	}

	public String getDescCatProduto() {
		return descCatProduto;
	}

	public void setDescCatProduto(String descCatProduto) {
		this.descCatProduto = descCatProduto;
	}
	
}
