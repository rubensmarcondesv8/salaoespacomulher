package com.elizelia.salaoespacomulher.dtos;

import java.io.Serializable;
import java.math.BigDecimal;

import com.elizelia.salaoespacomulher.domain.CatLancamento;
import com.elizelia.salaoespacomulher.domain.ContaCorrente;
import com.elizelia.salaoespacomulher.domain.ItemVenda;
import com.elizelia.salaoespacomulher.domain.Lancamento;

public class LancamentoDTO implements Serializable{

	private static final long serialVersionUID = 7179906567867885142L;
	private Long idLancamento;
	private CatLancamento catLancamento;
	private ItemVenda itemvenda;
	private BigDecimal valorLancamento;
	private ContaCorrente contaCorrente;
	public LancamentoDTO() {
		super();
	}
	public LancamentoDTO(Lancamento obj) {
		super();
		this.catLancamento = obj.getCatLancamento();
		this.itemvenda = obj.getItemvenda();
		this.valorLancamento = obj.getValorLancamento();
		this.contaCorrente = obj.getContaCorrente();
	}
	public Long getIdLancamento() {
		return idLancamento;
	}
	public void setIdLancamento(Long idLancamento) {
		this.idLancamento = idLancamento;
	}
	public CatLancamento getCatLancamento() {
		return catLancamento;
	}
	public void setCatLancamento(CatLancamento catLancamento) {
		this.catLancamento = catLancamento;
	}
	public ItemVenda getItemvenda() {
		return itemvenda;
	}
	public void setItemvenda(ItemVenda itemvenda) {
		this.itemvenda = itemvenda;
	}
	public BigDecimal getValorLancamento() {
		return valorLancamento;
	}
	public void setValorLancamento(BigDecimal valorLancamento) {
		this.valorLancamento = valorLancamento;
	}
	public ContaCorrente getContaCorrente() {
		return contaCorrente;
	}
	public void setContaCorrente(ContaCorrente contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

}
