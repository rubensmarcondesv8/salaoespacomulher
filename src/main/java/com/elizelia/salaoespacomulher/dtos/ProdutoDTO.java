package com.elizelia.salaoespacomulher.dtos;

import java.io.Serializable;
import java.math.BigDecimal;

import com.elizelia.salaoespacomulher.domain.Produto;

public class ProdutoDTO implements Serializable {

 static final long serialVersionUID = -218528037217817957L;

 	private Long idProduto;
	private String nomeProduto;
	private String descProduto;
	private BigDecimal precoUnitario;
	
	public ProdutoDTO() {
		super();
	}
	public ProdutoDTO(Produto obj) {
		super();
		this.idProduto = obj.getIdProduto();
		this.nomeProduto = obj.getNomeProduto();
		this.descProduto = obj.getDescProduto();
		this.precoUnitario = obj.getPrecoUnitario();
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
		
}
