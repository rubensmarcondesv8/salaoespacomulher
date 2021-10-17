package com.elizelia.salaoespacomulher.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	@Length(min = 3, max = 100, message = "Tamanho do campo incorreto.")
	private String descrServico;
	
	private BigDecimal precoBaseServico;
	
	private BigDecimal comissaoSalao;
	
	private String categoriaServico;
	
	@JsonIgnore
	@OneToMany(mappedBy = "itemServico", fetch = FetchType.LAZY)
	private List<ItemVenda> itensVenda = new ArrayList<>();
	
	public Servico() {
		super();
	}
	public Servico(String nomeServico, String descrServico, BigDecimal precoBaseServico, String categoriaServico, BigDecimal comissaoSalao) {
		super();
		this.nomeServico = nomeServico;
		this.descrServico = descrServico;
		this.precoBaseServico = precoBaseServico;
		this.comissaoSalao = comissaoSalao;
		this.categoriaServico = categoriaServico;
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
	
	public BigDecimal getComissaoSalao() {
		return comissaoSalao;
	}
	public void setComissaoSalao(BigDecimal comissaoSalao) {
		this.comissaoSalao = comissaoSalao;
	}
	public String getCategoriaServico() {
		return categoriaServico;
	}
	public void setCategoriaServico(String categoriaServico) {
		this.categoriaServico = categoriaServico;
	}

}
