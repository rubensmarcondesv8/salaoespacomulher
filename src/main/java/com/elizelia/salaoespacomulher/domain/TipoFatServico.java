package com.elizelia.salaoespacomulher.domain;

import java.util.Objects;

public class TipoFatServico extends EntidadeBase{
	private String nomeFat;
	private String descricaoFat;
	public String getNomeFat() {
		return nomeFat;
	}
	public void setNomeFat(String nomeFat) {
		this.nomeFat = nomeFat;
	}
	public String getDescricaoFat() {
		return descricaoFat;
	}
	public void setDescricaoFat(String descricaoFat) {
		this.descricaoFat = descricaoFat;
	}
	public TipoFatServico() {
		super();
	}
	public TipoFatServico(Long id) {
		super(id);
	}
	public TipoFatServico(String nomeFat, String descricaoFat) {
		super();
		this.nomeFat = nomeFat;
		this.descricaoFat = descricaoFat;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(nomeFat);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoFatServico other = (TipoFatServico) obj;
		return Objects.equals(nomeFat, other.nomeFat);
	}
	
	
}
