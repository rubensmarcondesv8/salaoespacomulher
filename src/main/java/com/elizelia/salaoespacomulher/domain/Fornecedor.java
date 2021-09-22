package com.elizelia.salaoespacomulher.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@Entity
public class Fornecedor implements Serializable{
	
	private static final long serialVersionUID = -2571496759507709812L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFornecedor;
	@NotEmpty(message = "Campo necessário")
	@Length(min = 3, max = 50, message = "Tamanho do campo incorreto.")
	private String nomeFornecedor;
	@NotEmpty(message = "Campo necessário")
	@Length(min = 10, max = 11, message = "Tamanho do campo incorreto.")
	private String telefoneFornecedor;
	@Length(min = 0, max = 200, message = "Tamanho do campo incorreto.")
	private String obsevacaoFornecedor;
	
	@ManyToMany(mappedBy="listaFornecedores", cascade = CascadeType.ALL)
	private List<Servico> listaServicosFornecidos = new ArrayList<>();
	
	@ManyToMany(mappedBy="listaFornecedorProd", cascade = CascadeType.ALL)
	private List<Produto> listaProdutosFornecidos = new ArrayList<>();
	
	public Fornecedor() {
		super();
	}
	public Fornecedor(String nomeFornecedor, String telefoneFornecedor, String obsevacaoFornecedor) {
		super();
		this.nomeFornecedor = nomeFornecedor;
		this.telefoneFornecedor = telefoneFornecedor;
		this.obsevacaoFornecedor = obsevacaoFornecedor;
	}
	public Long getIdFornecedor() {
		return idFornecedor;
	}
	public void setIdFornecedor(Long idFornecedor) {
		this.idFornecedor = idFornecedor;
	}
	public String getNomeFornecedor() {
		return nomeFornecedor;
	}
	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
	}
	public String getTelefoneFornecedor() {
		return telefoneFornecedor;
	}
	public void setTelefoneFornecedor(String telefoneFornecedor) {
		this.telefoneFornecedor = telefoneFornecedor;
	}
	public String getObsevacaoFornecedor() {
		return obsevacaoFornecedor;
	}
	public void setObsevacaoFornecedor(String obsevacaoFornecedor) {
		this.obsevacaoFornecedor = obsevacaoFornecedor;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idFornecedor);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		return Objects.equals(idFornecedor, other.idFornecedor);
	}
	
	

}
