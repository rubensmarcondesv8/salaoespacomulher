package com.elizelia.salaoespacomulher.domain;

import java.util.Objects;

public class Pessoa extends EntidadeBase{
	private String nomePessoa;
	private String telefonePessoa;
	public String getNomePessoa() {
		return nomePessoa;
	}
	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}
	public String getTelefonePessoa() {
		return telefonePessoa;
	}
	public void setTelefonePessoa(String telefonePessoa) {
		this.telefonePessoa = telefonePessoa;
	}
	public Pessoa() {
		super();
	}
	public Pessoa(Long id) {
		super(id);
	}
	public Pessoa(String nomePessoa, String telefonePessoa) {
		super();
		this.nomePessoa = nomePessoa;
		this.telefonePessoa = telefonePessoa;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(telefonePessoa);
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
		Pessoa other = (Pessoa) obj;
		return Objects.equals(telefonePessoa, other.telefonePessoa);
	}
	
	
	
	
	
}
