package com.elizelia.salaoespacomulher.dtos;

import java.io.Serializable;

import com.elizelia.salaoespacomulher.domain.Profissional;

public class ProfissionalDTO implements Serializable{
	
	private static final long serialVersionUID = -225826576010755857L;
	
	private String nomeProfissional;
	private String telefoneProfissional;
	private String numeroCPF;
	private String enderecoCompleto;
	public ProfissionalDTO() {
		super();
	}
	public ProfissionalDTO(Profissional obj) {
		super();
		this.nomeProfissional = obj.getNomeProfissional();
		this.telefoneProfissional = obj.getTelefoneProfissional();
		this.numeroCPF = obj.getNumeroCPF();
		this.enderecoCompleto = obj.getEnderecoCompleto();
	}
	public String getNomeProfissional() {
		return nomeProfissional;
	}
	public void setNomeProfissional(String nomeProfissional) {
		this.nomeProfissional = nomeProfissional;
	}
	public String getTelefoneProfissional() {
		return telefoneProfissional;
	}
	public void setTelefoneProfissional(String telefoneProfissional) {
		this.telefoneProfissional = telefoneProfissional;
	}
	public String getNumeroCPF() {
		return numeroCPF;
	}
	public void setNumeroCPF(String numeroCPF) {
		this.numeroCPF = numeroCPF;
	}
	public String getEnderecoCompleto() {
		return enderecoCompleto;
	}
	public void setEnderecoCompleto(String enderecoCompleto) {
		this.enderecoCompleto = enderecoCompleto;
	}
	
	
}
