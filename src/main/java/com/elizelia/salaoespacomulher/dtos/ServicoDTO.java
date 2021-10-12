package com.elizelia.salaoespacomulher.dtos;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.elizelia.salaoespacomulher.domain.Servico;

public class ServicoDTO implements Serializable {

	private static final long serialVersionUID = -5746326630761483852L;
	
	private Long idServico;
	
	@NotEmpty(message = "Campo necessário")
	@Length(min = 3, max = 50, message = "Tamanho do campo incorreto.")
	private String nomeServico;
	
	@NotEmpty(message = "Campo necessário")
	@Length(min = 3, max = 0, message = "Tamanho do campo incorreto.")
	private String descrServico;
	
	@NotEmpty(message = "Campo necessário")
	private BigDecimal precoBaseServico;
	
	private BigDecimal comissaoSalao;
	
	private String categoriaServico;
	
	public ServicoDTO() {
		super();
	}
	public Long getIdServico() {
		return idServico;
	}
	public void setIdServico(Long idServico) {
		this.idServico = idServico;
	}
	
	public ServicoDTO(Servico obj) {
		super();
		this.idServico = obj.getIdServico();
		this.nomeServico = obj.getNomeServico();
		this.precoBaseServico = obj.getPrecoBaseServico();
		this.descrServico = obj.getDescrServico();
		this.comissaoSalao = obj.getComissaoSalao();
		this.categoriaServico = obj.getCategoriaServico();
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
	public BigDecimal getComissaoSalao() {
		return comissaoSalao;
	}
	public void setComissaoSalao(BigDecimal comissaoSalao) {
		this.comissaoSalao = comissaoSalao;
	}
	public String getCategoriaServico() {
		return categoriaServico;
	}
	public void setCategoriaServico(String categoriaServico) {
		this.categoriaServico = categoriaServico;
	}
}
