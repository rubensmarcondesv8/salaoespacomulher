package com.elizelia.salaoespacomulher.dtos;

import java.io.Serializable;

import com.elizelia.salaoespacomulher.domain.Cliente;

public class ClienteDTO implements Serializable{
	
	private static final long serialVersionUID = -6354479302924410372L;
	
	private Long idCliente;
	private String nomeCliente;
	private String telefoneCliente;
	
	public ClienteDTO() {
		super();
	}
	public ClienteDTO(Cliente obj) {
		super();
		this.idCliente = obj.getIdCliente();
		this.nomeCliente = obj.getNomeCliente();
		this.telefoneCliente = obj.getTelefoneCliente();
	}
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getTelefoneCliente() {
		return telefoneCliente;
	}
	public void setTelefoneCliente(String telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}
	
	
}
