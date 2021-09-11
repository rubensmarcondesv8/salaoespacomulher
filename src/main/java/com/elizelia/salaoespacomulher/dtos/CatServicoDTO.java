package com.elizelia.salaoespacomulher.dtos;

import java.io.Serializable;

import com.elizelia.salaoespacomulher.domain.CatServico;

public class CatServicoDTO implements Serializable {
	private static final long serialVersionUID = -3516175159395689751L;
	
	private String nomeCatServico;
	private String descrCatServico;
	
	public CatServicoDTO() {
		super();
	}
	public CatServicoDTO(CatServico obj) {
		super();
		this.nomeCatServico = obj.getNomeCatServico();
		this.descrCatServico = obj.getDescrCatServico();
	}
	public String getNomeCatServico() {
		return nomeCatServico;
	}
	public void setNomeCatServico(String nomeCatServico) {
		this.nomeCatServico = nomeCatServico;
	}
	public String getDescrCatServico() {
		return descrCatServico;
	}
	public void setDescrCatServico(String descrCatServico) {
		this.descrCatServico = descrCatServico;
	}
	
	

}
