package com.elizelia.salaoespacomulher.dtos;

import java.io.Serializable;
import java.util.GregorianCalendar;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.elizelia.salaoespacomulher.domain.Profissional;
import com.elizelia.salaoespacomulher.domain.enums.CategProfissional;

public class ProfissionalDTO implements Serializable{
	
	private static final long serialVersionUID = -225826576010755857L;
	@NotEmpty(message = "Campo necessário")
	@Length(min = 3, max = 50, message = "Tamanho do campo incorreto.")
	private String nomeProfissional;
	@NotEmpty(message = "Campo necessário")
	@Length(min = 10, max = 11, message = "Tamanho do campo incorreto.")
	private String telefoneProfissional;
	@NotEmpty(message = "Campo necessário")
	@Length(min = 11, max = 11, message = "Tamanho do campo incorreto.")
	private String numeroCPF;
	@NotEmpty(message = "Campo necessário")
	@Length(min = 3, max = 80, message = "Tamanho do campo incorreto.")
	private String enderecoCompleto;
	
	private GregorianCalendar dataNascProfissional;
	
	private CategProfissional categoriaPrincipal;
	private CategProfissional categoriaAdicional;
	
	public ProfissionalDTO() {
		super();
	}
	public ProfissionalDTO(Profissional obj) {
		super();
		this.nomeProfissional = obj.getNomeProfissional();
		this.telefoneProfissional = obj.getTelefoneProfissional();
		this.numeroCPF = obj.getNumeroCPF();
		this.enderecoCompleto = obj.getEnderecoCompleto();
		this.categoriaPrincipal = obj.getCategoriaPrincipal();
		this.categoriaAdicional = obj.getCategoriaAdicional();
		this.dataNascProfissional = obj.getDataNascProfissional();
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
	
	public GregorianCalendar getDataNascProfissional() {
		return dataNascProfissional;
	}
	public void setDataNascProfissional(GregorianCalendar dataNascProfissional) {
		this.dataNascProfissional = dataNascProfissional;
	}
	public CategProfissional getCategoriaPrincipal() {
		return categoriaPrincipal;
	}
	public void setCategoriaPrincipal(CategProfissional categoriaPrincipal) {
		this.categoriaPrincipal = categoriaPrincipal;
	}
	public CategProfissional getCategoriaAdicional() {
		return categoriaAdicional;
	}
	public void setCategoriaAdicional(CategProfissional categoriaAdicional) {
		this.categoriaAdicional = categoriaAdicional;
	}
		
}
