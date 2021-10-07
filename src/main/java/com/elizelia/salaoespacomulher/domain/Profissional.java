package com.elizelia.salaoespacomulher.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.elizelia.salaoespacomulher.domain.enums.CategProfissional;
import com.fasterxml.jackson.annotation.JsonIgnore;

@CrossOrigin("*")
@Entity
public class Profissional implements Serializable {

	private static final long serialVersionUID = 4471858427625233249L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProfissional;

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

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idContaCorrente", referencedColumnName = "idContaCorrente")
	private ContaCorrente contacorrente;

	private CategProfissional categoriaPrincipal;
	private CategProfissional categoriaAdicional;

	@JsonIgnore
	@OneToMany(mappedBy = "profissionalVenda", fetch = FetchType.LAZY)
	private List<ItemVenda> itensVenda = new ArrayList<>();

	public Profissional() {
		super();
	}

	public Profissional(String nomeProfissional, String telefoneProfissional, String numeroCPF, String enderecoCompleto,
			GregorianCalendar dataNascProfissional, CategProfissional categoriaPrincipal, CategProfissional categoriaAdicional) {
		super();
		this.nomeProfissional = nomeProfissional;
		this.telefoneProfissional = telefoneProfissional;
		this.numeroCPF = numeroCPF;
		this.enderecoCompleto = enderecoCompleto;
		this.dataNascProfissional = dataNascProfissional;
		this.categoriaPrincipal = categoriaPrincipal;
		this.categoriaAdicional = categoriaAdicional;
	}

	public ContaCorrente getContacorrente() {
		return this.contacorrente;
	}

	public void setContacorrente(ContaCorrente contacorrente) {
		this.contacorrente = contacorrente;
	}

	public List<ItemVenda> getItensVenda() {
		return itensVenda;
	}

	public void setItensVenda(List<ItemVenda> itensVenda) {
		this.itensVenda = itensVenda;
	}

	public Long getIdProfissional() {
		return idProfissional;
	}

	public void setIdProfissional(Long idProfissional) {
		this.idProfissional = idProfissional;
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

	@Override
	public int hashCode() {
		return Objects.hash(idProfissional);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profissional other = (Profissional) obj;
		return Objects.equals(idProfissional, other.idProfissional);
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
