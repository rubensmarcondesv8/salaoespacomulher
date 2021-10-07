package com.elizelia.salaoespacomulher.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.elizelia.salaoespacomulher.domain.enums.CategProduto;
import com.fasterxml.jackson.annotation.JsonIgnore;

@CrossOrigin("*")
@Entity
public class Produto implements Serializable{
	
	private static final long serialVersionUID = 9139809455524522355L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduto;
	
	@NotEmpty(message = "Campo necessário")
	@Length(min = 3, max = 50, message = "Tamanho do campo incorreto.")
	private String nomeProduto;
	
	@NotEmpty(message = "Campo necessário")
	@Length(min = 3, max = 80, message = "Tamanho do campo incorreto.")
	private String descProduto;
	
	private Integer quantidadeEstoque;
	
	private BigDecimal precoUnitario;
	
	private BigDecimal comissaoProduto;
	
	private CategProduto categoriaProduto;
	
	@JsonIgnore
	@OneToMany(mappedBy = "itemProduto", fetch = FetchType.LAZY)
	private List<ItemVenda> itensVenda = new ArrayList<>();
	
	public Produto() {
	}

	public Produto(String nomeProduto, String descProduto, BigDecimal precoUnitario, BigDecimal comissaoProduto, CategProduto categoriaProduto) {
		super();
		this.nomeProduto = nomeProduto;
		this.descProduto = descProduto;
		this.precoUnitario = precoUnitario;
		this.comissaoProduto = comissaoProduto;
		this.categoriaProduto = categoriaProduto;
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

	public List<ItemVenda> getItensVenda() {
		return itensVenda;
	}

	public void setItensVenda(List<ItemVenda> itensVenda) {
		this.itensVenda = itensVenda;
	}

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public BigDecimal getComissaoProduto() {
		return comissaoProduto;
	}

	public void setComissaoProduto(BigDecimal comissaoProduto) {
		this.comissaoProduto = comissaoProduto;
	}

	public CategProduto getCategoriaProduto() {
		return categoriaProduto;
	}

	public void setCategoriaProduto(CategProduto categoriaProduto) {
		this.categoriaProduto = categoriaProduto;
	}

}
