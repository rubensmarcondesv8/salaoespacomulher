package com.elizelia.salaoespacomulher.dtos;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;

import com.elizelia.salaoespacomulher.domain.ItemVenda;
import com.elizelia.salaoespacomulher.domain.Produto;
import com.elizelia.salaoespacomulher.domain.Servico;

public class ItemVendaDTO implements Serializable{
	
	private static final long serialVersionUID = -910635064191748751L;
	
	private Long idItem;
	
	@NotEmpty(message = "Campo necessário")
	private Integer quantidadeItem;
	
	private Produto itemProduto;
	
	private Servico itemServico;
	
	private BigDecimal valorTotalItem;
	
	private BigDecimal descontoItem;
	private BigDecimal acrescimoItem;
	
	public ItemVendaDTO() {
		super();
	}
	public ItemVendaDTO(ItemVenda obj) {
		super();
		this.idItem = obj.getIdItem();
		this.quantidadeItem = obj.getQuantidadeItem();
		this.itemProduto = obj.getItemProduto();
		this.itemServico = obj.getItemServico();
		this.acrescimoItem = obj.getAcrescimoItem();
		this.descontoItem = obj.getDescontoItem();
		this.valorTotalItem = obj.getValorTotalItem();
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
	
	public BigDecimal getDescontoItem() {
		return descontoItem;
	}
	public void setDescontoItem(BigDecimal descontoItem) {
		this.descontoItem = descontoItem;
	}
	public BigDecimal getAcrescimoItem() {
		return acrescimoItem;
	}
	public void setAcrescimoItem(BigDecimal acrescimoItem) {
		this.acrescimoItem = acrescimoItem;
	}

}
