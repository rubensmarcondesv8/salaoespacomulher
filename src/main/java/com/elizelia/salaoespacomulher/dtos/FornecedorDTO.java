package com.elizelia.salaoespacomulher.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.elizelia.salaoespacomulher.domain.Fornecedor;

public class FornecedorDTO implements Serializable{
	
	private static final long serialVersionUID = 8452773336905801083L;
	
	private Long idFornecedor;
	@NotEmpty(message = "Campo necessário")
	@Length(min = 3, max = 50, message = "Tamanho do campo incorreto.")
	private String nomeFornecedor;
	@NotEmpty(message = "Campo necessário")
	@Length(min = 10, max = 11, message = "Tamanho do campo incorreto.")
	private String telefoneFornecedor;
	@Length(min = 0, max = 200, message = "Tamanho do campo incorreto.")
	private String obsevacaoFornecedor;
	
	public FornecedorDTO() {
		super();
	}

	public FornecedorDTO(Fornecedor obj) {
		super();
		this.nomeFornecedor = obj.getNomeFornecedor();
		this.telefoneFornecedor = obj.getTelefoneFornecedor();
		this.obsevacaoFornecedor = obj.getObsevacaoFornecedor();
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
	
}
