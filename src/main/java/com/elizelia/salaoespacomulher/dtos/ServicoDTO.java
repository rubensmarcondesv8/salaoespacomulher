package com.elizelia.salaoespacomulher.dtos;

import java.io.Serializable;
import java.math.BigDecimal;

import com.elizelia.salaoespacomulher.domain.Servico;

public class ServicoDTO implements Serializable {

	private static final long serialVersionUID = -5746326630761483852L;
	
	private String nomeServico;
	private BigDecimal precoBaseServico;
	public ServicoDTO() {
		super();
	}
	public ServicoDTO(Servico obj) {
		super();
		this.nomeServico = obj.getNomeServico();
		this.precoBaseServico = obj.getPrecoBaseServico();
	}
	public String getNomeServico() {
		return nomeServico;
	}
	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}
	public BigDecimal getPrecoBaseServico() {
		return precoBaseServico;
	}
	public void setPrecoBaseServico(BigDecimal precoBaseServico) {
		this.precoBaseServico = precoBaseServico;
	}
	
	
	

}
