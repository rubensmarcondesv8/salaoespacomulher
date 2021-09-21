package com.elizelia.salaoespacomulher.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.elizelia.salaoespacomulher.domain.CatProduto;

public class CatProdutoDTO implements Serializable{

	private static final long serialVersionUID = -3479380782361675603L;
	
	@NotEmpty(message = "Campo necessário")
	@Length(min = 4, max = 4, message = "Tamanho do campo incorreto.")
	private String nomeCatProduto;
	
	@NotEmpty(message = "Campo necessário")
	@Length(min = 3, max = 80, message = "Tamanho do campo incorreto.")
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
