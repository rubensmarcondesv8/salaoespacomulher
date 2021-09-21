package com.elizelia.salaoespacomulher.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.elizelia.salaoespacomulher.domain.CatServico;

public class CatServicoDTO implements Serializable {
	private static final long serialVersionUID = -3516175159395689751L;
	
	@NotEmpty(message = "Campo necessário")
	@Length(min = 4, max = 4, message = "Tamanho do campo incorreto.")
	private String nomeCatServico;
	@NotEmpty(message = "Campo necessário")
	@Length(min = 3, max = 80, message = "Tamanho do campo incorreto.")
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
