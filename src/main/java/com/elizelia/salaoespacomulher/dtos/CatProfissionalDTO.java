package com.elizelia.salaoespacomulher.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.elizelia.salaoespacomulher.domain.CatProfissional;

public class CatProfissionalDTO implements Serializable{
	private static final long serialVersionUID = 3006580664543382556L;
	@NotEmpty(message = "Campo necessário")
	@Length(min = 3, max = 50, message = "Tamanho do campo incorreto.")
	private String nomeCatProfissional;
	@NotEmpty(message = "Campo necessário")
	@Length(min = 3, max = 80, message = "Tamanho do campo incorreto.")
	private String descCatProfissional;
	
	public CatProfissionalDTO() {
		super();
	}

	public CatProfissionalDTO(CatProfissional obj) {
		super();
		this.nomeCatProfissional = obj.getNomeCatProfissional();
		this.descCatProfissional = obj.getDescCatProfissional();
	}

	public String getNomeCatProfissional() {
		return nomeCatProfissional;
	}

	public void setNomeCatProfissional(String nomeCatProfissional) {
		this.nomeCatProfissional = nomeCatProfissional;
	}

	public String getDescCatProfissional() {
		return descCatProfissional;
	}
	
	public void setDescCatprofissional(String descCatProfissional) {
		this.descCatProfissional = descCatProfissional;
	}

}
