package com.elizelia.salaoespacomulher.dtos;

import java.io.Serializable;
import java.math.BigDecimal;

import com.elizelia.salaoespacomulher.domain.CatProfissional;

public class CatProfissionalDTO implements Serializable{
	private static final long serialVersionUID = 3006580664543382556L;
	
	private String nomeCatProfissional;
	private String descCatProfissional;
	private BigDecimal comissaoCobradaSalao;
	
	public CatProfissionalDTO() {
		super();
	}

	public CatProfissionalDTO(CatProfissional obj) {
		super();
		this.nomeCatProfissional = obj.getNomeCatProfissional();
		this.descCatProfissional = obj.getDescCatProfissional();
		this.comissaoCobradaSalao = obj.getComissaoCobradaSalao();
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

	public void setDescCatProfissional(String descCatProfissional) {
		this.descCatProfissional = descCatProfissional;
	}

	public BigDecimal getComissaoCobradaSalao() {
		return comissaoCobradaSalao;
	}

	public void setComissaoCobradaSalao(BigDecimal comissaoCobradaSalao) {
		this.comissaoCobradaSalao = comissaoCobradaSalao;
	}
}
