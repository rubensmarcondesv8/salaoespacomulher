package com.elizelia.salaoespacomulher.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.elizelia.salaoespacomulher.domain.CatLancamento;
import com.elizelia.salaoespacomulher.domain.Lancamento;

public class CatLancamentoDTO implements Serializable{

	private static final long serialVersionUID = -4378690267534974534L;
	
	private Long idCatLancamento;
	@NotEmpty(message = "Campo Necessário")
	@Length(min=1, max=1, message="Tamanho do campo incorreto")
	private String tipoLancamento;
	@NotEmpty(message = "Campo Necessário")
	@Length(min=3, max=30, message="Tamanho do campo incorreto")
	private String descrLancamento;
	
	private List<Lancamento> listaLancamentos = new ArrayList<>();

	public CatLancamentoDTO() {
		super();
	}

	public CatLancamentoDTO(CatLancamento obj) {
		super();
		this.tipoLancamento = obj.getTipoLancamento();
		this.descrLancamento = obj.getDescrLancamento();
	}

	public Long getIdCatLancamento() {
		return idCatLancamento;
	}

	public void setIdCatLancamento(Long idCatLancamento) {
		this.idCatLancamento = idCatLancamento;
	}

	public String getTipoLancamento() {
		return tipoLancamento;
	}

	public void setTipoLancamento(String tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
	}

	public String getDescrLancamento() {
		return descrLancamento;
	}

	public void setDescrLancamento(String descrLancamento) {
		this.descrLancamento = descrLancamento;
	}

	public List<Lancamento> getListaLancamentos() {
		return listaLancamentos;
	}

	public void setListaLancamentos(List<Lancamento> listaLancamentos) {
		this.listaLancamentos = listaLancamentos;
	}	

}
