package com.elizelia.salaoespacomulher.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonIgnore;

@CrossOrigin("*")
@Entity
public class Servico implements Serializable{
	
	private static final long serialVersionUID = -6783103192865048837L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idServico;
	@NotEmpty(message = "Campo necessário")
	@Length(min = 3, max = 50, message = "Tamanho do campo incorreto.")
	private String nomeServico;
	@NotEmpty(message = "Campo necessário")
	@Length(min = 3, max = 50, message = "Tamanho do campo incorreto.")
	private String descrServico;
	
	private BigDecimal precoBaseServico;
	
	private Fornecedor fornecedor;
	
	@JsonIgnore
	@ManyToOne(cascade = { CascadeType.MERGE })
	private CatServico catServico;
	
	@JsonIgnore
	@OneToMany(mappedBy = "itemServico", fetch = FetchType.LAZY)
	private List<ItemVenda> itensVenda = new ArrayList<>();
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="FORNEC_SERVICO",
	             joinColumns={@JoinColumn(name="idServico")},
	             inverseJoinColumns={@JoinColumn(name="idFornecedor")})
	private List<Fornecedor> listaFornecedores = new ArrayList<>();
	
	public Servico() {
		super();
	}
	public Servico(String nomeServico, String descrServico, BigDecimal precoBaseServico, CatServico catServico) {
		super();
		this.nomeServico = nomeServico;
		this.descrServico = descrServico;
		this.precoBaseServico = precoBaseServico;
		this.catServico = catServico;
	}
	public Long getIdServico() {
		return idServico;
	}
	public void setIdServico(Long idServico) {
		this.idServico = idServico;
	}
	public String getNomeServico() {
		return nomeServico;
	}
	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}
	public String getDescrServico() {
		return descrServico;
	}
	public void setDescrServico(String descrServico) {
		this.descrServico = descrServico;
	}
	public BigDecimal getPrecoBaseServico() {
		return precoBaseServico;
	}
	public void setPrecoBaseServico(BigDecimal precoBaseServico) {
		this.precoBaseServico = precoBaseServico;
	}
	public CatServico getCatServico() {
		return catServico;
	}
	public void setCatServico(CatServico catServico) {
		this.catServico = catServico;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idServico);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Servico other = (Servico) obj;
		return Objects.equals(idServico, other.idServico);
	}
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

}
