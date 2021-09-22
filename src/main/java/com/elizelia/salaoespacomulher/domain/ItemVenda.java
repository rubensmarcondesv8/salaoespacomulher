package com.elizelia.salaoespacomulher.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonIgnore;

@CrossOrigin("*")
@Entity
public class ItemVenda implements Serializable{
	
	private static final long serialVersionUID = 4722081701361157109L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idItem;
	
	private Long quantidadeItem;
	
	@ManyToOne
	@JoinColumn
	private Produto itemProduto;
	
	@ManyToOne
	@JoinColumn
	private Servico itemServico;
	
	private BigDecimal valorTotalItem;
	
	private BigDecimal descontoItem;
	private BigDecimal acrescimoItem;
	
	@JsonIgnore
	@ManyToOne(cascade = { CascadeType.MERGE })
	@JoinColumn
	private Venda Venda;
	
	@ManyToOne
	@JoinColumn
	private Profissional profissionalVenda;

	public ItemVenda() {
	}

	public ItemVenda(Venda Venda) {
		super();
		this.Venda = Venda;
	}

	public ItemVenda(Long quantidadeItem, Produto itemProduto, Servico itemServico,
			Profissional profissionalVenda) {
		super();
		this.quantidadeItem = quantidadeItem;
		this.itemProduto = itemProduto;
		this.itemServico = itemServico;
		if(itemProduto != null) {			
			this.valorTotalItem = itemProduto.getPrecoUnitario().multiply(BigDecimal.valueOf(quantidadeItem));
		}
		if(itemServico != null) {
			this.valorTotalItem = itemServico.getPrecoBaseServico().multiply(BigDecimal.valueOf(quantidadeItem));		}
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
		if(this.itemServico == null) {			
			this.itemProduto = itemProduto;
		}
	}

	public Servico getItemServico() {
		return itemServico;
	}

	public void setItemServico(Servico itemServico) {
		if(this.itemProduto == null) {			
			this.itemServico = itemServico;
		}
	}

	public BigDecimal getValorTotalItem() {
		return valorTotalItem;
	}

	public void setValorTotalItem() {
		if(itemProduto != null) {			
			this.valorTotalItem = itemProduto.getPrecoUnitario().multiply(BigDecimal.valueOf(quantidadeItem));
		}
		if(itemServico != null) {
			this.valorTotalItem = itemServico.getPrecoBaseServico().multiply(BigDecimal.valueOf(quantidadeItem));		}
		
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

	public BigDecimal getAcrescimoItem() {
		return acrescimoItem;
	}

	public void setAcrescimoItem(BigDecimal acrescimoItem) {
		this.acrescimoItem = acrescimoItem;
	}

	public BigDecimal getDescontoItem() {
		return descontoItem;
	}

	public void setDescontoItem(BigDecimal descontoItem) {
		this.descontoItem = descontoItem;
	}
	
	

}
