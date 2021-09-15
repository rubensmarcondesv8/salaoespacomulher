package com.elizelia.salaoespacomulher.domain;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CatProduto {
	@Id
	private String nomeCatProduto;
	@Column(nullable = false, unique = true, length = 100)
	private String descCatProduto;
	@OneToMany(mappedBy = "catProduto")
	private List<Produto> produtosLista;

	public CatProduto() {
	}

	public CatProduto(String descCatProduto, List<Produto> produtosLista) {
		super();
		this.descCatProduto = descCatProduto;
		this.produtosLista = produtosLista;
	}

	public CatProduto(String nomeCatProduto, String descCatProduto) {
		super();
		this.nomeCatProduto = nomeCatProduto;
		this.descCatProduto = descCatProduto;
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

	public List<Produto> getProdutosLista() {
		return produtosLista;
	}

	public void setProdutosLista(List<Produto> produtosLista) {
		this.produtosLista = produtosLista;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nomeCatProduto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CatProduto other = (CatProduto) obj;
		return Objects.equals(nomeCatProduto, other.nomeCatProduto);
	}

	
}
