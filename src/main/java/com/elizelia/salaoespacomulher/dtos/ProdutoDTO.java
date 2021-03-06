package com.elizelia.salaoespacomulher.dtos;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.elizelia.salaoespacomulher.domain.Produto;

public class ProdutoDTO implements Serializable {

 static final long serialVersionUID = -218528037217817957L;

 	private Long idProduto;
 	
 	@NotEmpty(message = "Campo necessário")
	@Length(min = 3, max = 50, message = "Tamanho do campo incorreto.")
	private String nomeProduto;
 	
 	@NotEmpty(message = "Campo necessário")
	@Length(min = 3, max = 80, message = "Tamanho do campo incorreto.")
	private String descProduto;
 	
 	@NotEmpty(message = "Campo necessário")
	private BigDecimal precoUnitario;
 	
 	private Integer quantidadeEstoque;
	
 	private String categoriaProduto;
 	
 	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
	
	private BigDecimal comissaoProduto;
	
	public ProdutoDTO() {
		super();
	}
	public ProdutoDTO(Produto obj) {
		super();
		this.idProduto = obj.getIdProduto();
		this.nomeProduto = obj.getNomeProduto();
		this.descProduto = obj.getDescProduto();
		this.precoUnitario = obj.getPrecoUnitario();
		this.comissaoProduto = obj.getComissaoProduto();
		this.quantidadeEstoque = obj.getQuantidadeEstoque();
		this.categoriaProduto = obj.getCategoriaProduto();
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
	public BigDecimal getComissaoProduto() {
		return comissaoProduto;
	}
	public void setComissaoProduto(BigDecimal comissaoProduto) {
		this.comissaoProduto = comissaoProduto;
	}
	
	public String getCategoriaProduto() {
		return categoriaProduto;
	}
	public void setCategoriaProduto(String categoriaProduto) {
		this.categoriaProduto = categoriaProduto;
	}
		
}
