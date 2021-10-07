package com.elizelia.salaoespacomulher.dtos;

import java.io.Serializable;
import java.util.GregorianCalendar;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.elizelia.salaoespacomulher.domain.Cliente;

public class ClienteDTO implements Serializable{
	
	private static final long serialVersionUID = -6354479302924410372L;
	
	private Long idCliente;
	@NotEmpty(message = "Campo necessário")
	@Length(min = 3, max = 50, message = "Tamanho do campo incorreto.")
	private String nomeCliente;
	@NotEmpty(message = "Campo necessário")
	@Length(min = 3, max = 50, message = "Tamanho do campo incorreto.")
	private String telefoneCliente;
	
	private GregorianCalendar aniversarioCliente;
	
	public ClienteDTO() {
		super();
	}
	public ClienteDTO(Cliente obj) {
		super();
		this.idCliente = obj.getIdCliente();
		this.nomeCliente = obj.getNomeCliente();
		this.telefoneCliente = obj.getTelefoneCliente();
		this.aniversarioCliente = obj.getAniversarioCliente();
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
	public GregorianCalendar getAniversarioCliente() {
		return aniversarioCliente;
	}
	public void setAniversarioCliente(GregorianCalendar aniversarioCliente) {
		this.aniversarioCliente = aniversarioCliente;
	}
	
	
}
