package com.elizelia.salaoespacomulher.dtos;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;

import com.elizelia.salaoespacomulher.domain.ItemVenda;
import com.elizelia.salaoespacomulher.domain.Produto;
import com.elizelia.salaoespacomulher.domain.Profissional;
import com.elizelia.salaoespacomulher.domain.Servico;
import com.elizelia.salaoespacomulher.domain.Venda;

public class ItemVendaDTO implements Serializable{
	
	private static final long serialVersionUID = -910635064191748751L;
	
	private Long idItem;
	@NotEmpty(message = "Campo necessário")
	private Long quantidadeItem;
	private Produto itemProduto;
	private Servico itemServico;
	private BigDecimal valorTotalItem;
	@NotEmpty(message = "Campo necessário")
	private Venda Venda;
	@NotEmpty(message = "Campo necessário")
	private Profissional profissionalVenda;
	
	public ItemVendaDTO() {
		super();
	}
	public ItemVendaDTO(ItemVenda obj) {
		super();
		this.idItem = obj.getIdItem();
		this.quantidadeItem = obj.getQuantidadeItem();
		this.itemProduto = obj.getItemProduto();
		this.itemServico = obj.getItemServico();
		this.valorTotalItem = obj.getValorTotalItem();
		this.Venda = obj.getVenda();
		this.profissionalVenda = obj.getProfissionalVenda();
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
	public void setItemVenda(Venda Venda) {
		this.Venda = Venda;
	}
	public Profissional getProfissionalVenda() {
		return profissionalVenda;
	}
	public void setProfissionalVenda(Profissional profissionalVenda) {
		this.profissionalVenda = profissionalVenda;
	}

}
