package com.elizelia.salaoespacomulher.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@Entity
public class Lancamento implements Serializable{
	private static final long serialVersionUID = -7898701916162118804L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLancamento;
	
	@ManyToOne
	@JoinColumn
	private CatLancamento catLancamento;
	
	@ManyToOne
	@JoinColumn
	private ItemVenda itemvenda;
	
	private BigDecimal valorLancamento;
	
	@ManyToOne
	@JoinColumn
	private ContaCorrente contaCorrente;

	public Lancamento() {
		super();
	}

	public Lancamento(CatLancamento catLancamento, ItemVenda itemvenda, BigDecimal valorLancamento,
			ContaCorrente contaCorrente) {
		super();
		this.catLancamento = catLancamento;
		this.itemvenda = itemvenda;
		this.valorLancamento = valorLancamento;
		this.contaCorrente = contaCorrente;
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

	@Override
	public int hashCode() {
		return Objects.hash(idLancamento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lancamento other = (Lancamento) obj;
		return Objects.equals(idLancamento, other.idLancamento);
	}

}
