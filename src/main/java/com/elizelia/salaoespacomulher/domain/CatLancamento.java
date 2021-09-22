package com.elizelia.salaoespacomulher.domain;

import java.io.Serializable;
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
public class CatLancamento implements Serializable{
	
	private static final long serialVersionUID = -3351379465320135861L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCatLancamento;
	@NotEmpty(message = "Campo Necessário")
	@Length(min=1, max=1, message="Tamanho do campo incorreto")
	private String tipoLancamento;
	@NotEmpty(message = "Campo Necessário")
	@Length(min=3, max=30, message="Tamanho do campo incorreto")
	private String descrLancamento;
	
	@JsonIgnore
	@OneToMany(mappedBy = "catLancamento", fetch = FetchType.LAZY)
	private List<Lancamento> listaLancamentos = new ArrayList<>();
	
	public CatLancamento() {
		super();
	}
	public CatLancamento(
			@NotEmpty(message = "Campo Necessário") @Length(min = 1, max = 1, message = "Tamanho do campo incorreto") String tipoLancamento,
			@NotEmpty(message = "Campo Necessário") @Length(min = 3, max = 30, message = "Tamanho do campo incorreto") String descrLancamento) {
		super();
		this.tipoLancamento = tipoLancamento;
		this.descrLancamento = descrLancamento;
	}
	public Long getIdCatLancamento() {
		return idCatLancamento;
	}
	public void setIdCatLancamento(Long idCatLancamento) {
		this.idCatLancamento = idCatLancamento;
	}
	public String getTipoLancamento() {
		return tipoLancamento;
	}
	public void setTipoLancamento(String tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
	}
	public String getDescrLancamento() {
		return descrLancamento;
	}
	public void setDescrLancamento(String descrLancamento) {
		this.descrLancamento = descrLancamento;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idCatLancamento);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CatLancamento other = (CatLancamento) obj;
		return Objects.equals(idCatLancamento, other.idCatLancamento);
	}	

}
