package com.elizelia.salaoespacomulher.domain;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
	@ManyToOne
	private Venda itemVenda;

	public ItemVenda() {
	}

	public ItemVenda(Venda itemVenda) {
		super();
		this.itemVenda = itemVenda;
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

	public Venda getItemVenda() {
		return itemVenda;
	}

	public void setItemVenda(Venda itemVenda) {
		this.itemVenda = itemVenda;
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
