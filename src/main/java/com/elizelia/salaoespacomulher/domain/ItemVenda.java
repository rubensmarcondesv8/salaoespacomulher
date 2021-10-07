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
import javax.persistence.OneToOne;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.elizelia.salaoespacomulher.domain.enums.TipoLancamento;
import com.fasterxml.jackson.annotation.JsonIgnore;

@CrossOrigin("*")
@Entity
public class ItemVenda implements Serializable{
	
	private static final long serialVersionUID = 4722081701361157109L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idItem;
	
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn
	private Produto itemProduto;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn
	private Servico itemServico;
	
	private Integer quantidadeItem;
	private BigDecimal valorTotalItem;
	
	private BigDecimal descontoItem;
	private BigDecimal acrescimoItem;
	
	@JsonIgnore
	@ManyToOne(cascade = { CascadeType.MERGE })
	@JoinColumn
	private Venda Venda;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn
	private Profissional profissionalVenda;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "lanc_comissao_id", referencedColumnName = "idLancamento")
	private Lancamento comissãoSalao;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "lanc_pagamento_id", referencedColumnName = "idLancamento")
	private Lancamento pagamentoProfissional;


	public ItemVenda() {
	}

	public ItemVenda(Venda Venda) {
		super();
		this.Venda = Venda;
	}

	public ItemVenda(Integer quantidadeItem, Produto itemProduto, Profissional profissionalVenda, Profissional salao) {
		super();
		this.quantidadeItem = quantidadeItem;
		this.itemProduto = itemProduto;
		this.profissionalVenda = profissionalVenda;
		if(this.itemServico == null) {
			this.setValorTotalItem();
		}
		BigDecimal comissao = new BigDecimal(0);
		BigDecimal pagamento = new BigDecimal(0);
		
		comissao = this.valorTotalItem.multiply(this.getItemProduto().getComissaoProduto());
		pagamento = this.valorTotalItem.subtract(comissao);
		
		this.comissãoSalao = new Lancamento(TipoLancamento.C, this, comissao, salao.getContacorrente(), this.getItemProduto().getNomeProduto());
		this.pagamentoProfissional = new Lancamento(TipoLancamento.C, this, pagamento, this.getProfissionalVenda().getContacorrente(), this.getItemProduto().getNomeProduto());
	}
	
	public ItemVenda(Integer quantidadeItem, Servico itemServico, Profissional profissionalVenda, Profissional salao) {
		super();
		this.quantidadeItem = quantidadeItem;
		this.itemServico = itemServico;
		this.profissionalVenda = profissionalVenda;
		if(this.itemProduto == null) {
			this.setValorTotalItem();
		}
		
		BigDecimal comissao = new BigDecimal(0);
		BigDecimal pagamento = new BigDecimal(0);
		
		comissao = this.valorTotalItem.multiply(this.getItemServico().getComissaoSalao());
		pagamento = this.valorTotalItem.subtract(comissao);
		
		this.comissãoSalao = new Lancamento(TipoLancamento.C, this, comissao, salao.getContacorrente(), this.getItemServico().getNomeServico());
		this.pagamentoProfissional = new Lancamento(TipoLancamento.C, this, pagamento, this.getProfissionalVenda().getContacorrente(), this.getItemServico().getNomeServico());
	}
	
	public Long getIdItem() {
		return idItem;
	}

	public void setIdItem(Long idItem) {
		this.idItem = idItem;
	}

	public Integer getQuantidadeItem() {
		return quantidadeItem;
	}

	public void setQuantidadeItem(Integer quantidadeItem) {
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

	public void setValorTotalItem(BigDecimal valorTotalItem) {
		this.valorTotalItem = valorTotalItem;
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

	public Lancamento getComissãoSalao() {
		return comissãoSalao;
	}

	public void setComissãoSalao(Lancamento comissãoSalao) {
		this.comissãoSalao = comissãoSalao;
	}

	public Lancamento getPagamentoProfissional() {
		return pagamentoProfissional;
	}

	public void setPagamentoProfissional(Lancamento pagamentoProfissional) {
		this.pagamentoProfissional = pagamentoProfissional;
	}
	
	

}
