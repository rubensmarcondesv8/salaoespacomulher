package com.elizelia.salaoespacomulher.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@Entity
public class CatProduto implements Serializable{
	
	private static final long serialVersionUID = 3361866691088870049L;
	
	@Id
	@NotEmpty(message = "Campo necessário")
	@Length(min = 4, max = 4, message = "Tamanho do campo incorreto.")
	private String nomeCatProduto;
	@NotEmpty(message = "Campo necessário")
	@Length(min = 3, max = 80, message = "Tamanho do campo incorreto.")
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
