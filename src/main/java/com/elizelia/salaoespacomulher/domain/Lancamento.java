package com.elizelia.salaoespacomulher.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;

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
public class Lancamento implements Serializable{
	private static final long serialVersionUID = -7898701916162118804L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLancamento;
	
	private TipoLancamento tipoLancamento;
	
	private String descrLancamento;
	
	private BigDecimal valorLancamento;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn
	private ContaCorrente contaCorrente;
	
	private GregorianCalendar dataHoraLancamento = new GregorianCalendar(TimeZone.getTimeZone("GMT-3"),new Locale("pt_BR"));

	@OneToOne(mappedBy = "comissãoSalao")
	private ItemVenda item_com;
	
	@OneToOne(mappedBy = "pagamentoProfissional")
	private ItemVenda item_pag;

	public Lancamento() {
		super();
	}

	public Lancamento(TipoLancamento tipoLancamenot, ItemVenda itemvenda, BigDecimal valorLancamento,
			ContaCorrente contaCorrente, String descrLancamento) {
		super();
		this.tipoLancamento = tipoLancamenot;
		this.valorLancamento = valorLancamento;
		this.contaCorrente = contaCorrente;
		this.descrLancamento = descrLancamento;
	}

	public Long getIdLancamento() {
		return idLancamento;
	}

	public void setIdLancamento(Long idLancamento) {
		this.idLancamento = idLancamento;
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

	public GregorianCalendar getDataHoraLancamento() {
		return dataHoraLancamento;
	}

	public void setDataHoraLancamento(GregorianCalendar dataHoraLancamento) {
		this.dataHoraLancamento = dataHoraLancamento;
	}

	public TipoLancamento getTipoLancamento() {
		return tipoLancamento;
	}

	public void setTipoLancamento(TipoLancamento tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
	}

	public String getDescrLancamento() {
		return descrLancamento;
	}

	public void setDescrLancamento(String descrLancamento) {
		this.descrLancamento = descrLancamento;
	}

}
