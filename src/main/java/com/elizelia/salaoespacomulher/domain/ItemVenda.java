package com.elizelia.salaoespacomulher.domain;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItemVenda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idItem;
	private Long quantidadeItem;
	
	@ManyToOne
	private Produto itemProduto;
	@ManyToOne
	private Servico itemServico;
	
	private BigDecimal valorTotalItem;
	
	@JsonIgnore
	@ManyToOne(cascade = { CascadeType.MERGE })
	private Venda Venda;
	
	@ManyToOne
	private Profissional profissionalVenda;

	public ItemVenda() {
	}

	public ItemVenda(Venda Venda) {
		super();
		this.Venda = Venda;
	}

	public ItemVenda(Long quantidadeItem, Produto itemProduto, Servico itemServico, BigDecimal valorTotalItem,
			Venda Venda, Profissional profissionalVenda) {
		super();
		this.quantidadeItem = quantidadeItem;
		this.itemProduto = itemProduto;
		this.itemServico = itemServico;
		this.valorTotalItem = valorTotalItem;
		this.Venda = Venda;
		this.profissionalVenda = profissionalVenda;
	}

	public Long getIdItem() {
		return idItem;
	}

	public void setIdItem(Long idItem) {
		this.idItem = idItem;
	}

	public Long getQuantidadeItem() {
		return quantidadeItem;
	}

	public void setQuantidadeItem(Long quantidadeItem) {
		this.quantidadeItem = quantidadeItem;
	}

	public Produto getItemProduto() {
		return itemProduto;
	}

	public void setItemProduto(Produto itemProduto) {
		this.itemProduto = itemProduto;
	}

	public Servico getItemServico() {
		return itemServico;
	}

	public void setItemServico(Servico itemServico) {
		this.itemServico = itemServico;
	}

	public BigDecimal getValorTotalItem() {
		return valorTotalItem;
	}

	public void setValorTotalItem(BigDecimal valorTotalItem) {
		this.valorTotalItem = valorTotalItem;
	}

	public Venda getVenda() {
		return Venda;
	}

	public void setVenda(Venda Venda) {
		this.Venda = Venda;
	}

	public Profissional getProfissionalVenda() {
		return profissionalVenda;
	}

	public void setProfissionalVenda(Profissional profissionalVenda) {
		this.profissionalVenda = profissionalVenda;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idItem);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemVenda other = (ItemVenda) obj;
		return Objects.equals(idItem, other.idItem);
	}
	
	

}
