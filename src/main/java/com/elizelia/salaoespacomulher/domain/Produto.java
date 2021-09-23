package com.elizelia.salaoespacomulher.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.bind.annotation.CrossOrigin;

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
	
	private Long quantidadeEstoque;
	
	private Fornecedor fornecedor;
	
	private BigDecimal precoUnitario;
	
	private BigDecimal comissaoProduto;
	
	@JsonIgnore
	@ManyToOne
	private CatProduto catProduto;
	
	@JsonIgnore
	@OneToMany(mappedBy = "itemProduto", fetch = FetchType.LAZY)
	private List<ItemVenda> itensVenda = new ArrayList<>();
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="FORNEC_PROD",
	             joinColumns={@JoinColumn(name="idProduto")},
	             inverseJoinColumns={@JoinColumn(name="idFornecedor")})
	private List<Fornecedor> listaFornecedorProd = new ArrayList<>();
	
	public Produto() {
	}

	public Produto(String nomeProduto, String descProduto, BigDecimal precoUnitario, CatProduto catProduto, BigDecimal comissaoProduto) {
		super();
		this.nomeProduto = nomeProduto;
		this.descProduto = descProduto;
		this.precoUnitario = precoUnitario;
		this.catProduto = catProduto;
		this.setComissaoProduto(comissaoProduto);
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

	public Long getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Long quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public BigDecimal getComissaoProduto() {
		return comissaoProduto;
	}

	public void setComissaoProduto(BigDecimal comissaoProduto) {
		this.comissaoProduto = comissaoProduto;
	}

}
