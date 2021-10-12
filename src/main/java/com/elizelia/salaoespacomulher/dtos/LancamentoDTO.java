package com.elizelia.salaoespacomulher.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import com.elizelia.salaoespacomulher.domain.ContaCorrente;
import com.elizelia.salaoespacomulher.domain.Lancamento;

public class LancamentoDTO implements Serializable{

	private static final long serialVersionUID = 7179906567867885142L;
	private Long idLancamento;
	private BigDecimal valorLancamento;
	private ContaCorrente contaCorrente;
	private String tipoLancamento;
	private GregorianCalendar dataHoraLancamento = new GregorianCalendar(TimeZone.getTimeZone("GMT-3"),new Locale("pt_BR"));
	
	public GregorianCalendar getDataHoraLancamento() {
		return dataHoraLancamento;
	}
	public void setDataHoraLancamento(GregorianCalendar dataHoraLancamento) {
		this.dataHoraLancamento = dataHoraLancamento;
	}
	public LancamentoDTO() {
		super();
	}
	public LancamentoDTO(Lancamento obj) {
		super();
		this.idLancamento = obj.getIdLancamento();
		this.tipoLancamento = obj.getTipoLancamento();
		this.valorLancamento = obj.getValorLancamento();
		this.contaCorrente = obj.getContaCorrente();
		this.dataHoraLancamento = obj.getDataHoraLancamento();
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
	public String getTipoLancamento() {
		return tipoLancamento;
	}
	public void setTipoLancamento(String tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
	}

}
