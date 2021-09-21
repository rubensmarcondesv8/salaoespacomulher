package com.elizelia.salaoespacomulher.dtos;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.elizelia.salaoespacomulher.domain.Servico;

public class ServicoDTO implements Serializable {

	private static final long serialVersionUID = -5746326630761483852L;
	@NotEmpty(message = "Campo necessário")
	@Length(min = 3, max = 50, message = "Tamanho do campo incorreto.")
	private String nomeServico;
	@NotEmpty(message = "Campo necessário")
	@Length(min = 3, max = 0, message = "Tamanho do campo incorreto.")
	private String descrServico;
	@NotEmpty(message = "Campo necessário")
	private BigDecimal precoBaseServico;
	
	public ServicoDTO() {
		super();
	}
	public ServicoDTO(Servico obj) {
		super();
		this.nomeServico = obj.getNomeServico();
		this.precoBaseServico = obj.getPrecoBaseServico();
		this.descrServico = obj.getDescrServico();
	}
	public String getDescrServico() {
		return descrServico;
	}
	public void setDescrServico(String descrServico) {
		this.descrServico = descrServico;
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
