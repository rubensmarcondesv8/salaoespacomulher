package com.elizelia.salaoespacomulher.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.elizelia.salaoespacomulher.domain.Cliente;
import com.elizelia.salaoespacomulher.domain.Venda;

public class VendaDTO implements Serializable{
	private static final long serialVersionUID = 4220710453311622476L;

	private Long idVenda;
	private Date dataVenda;
	private BigDecimal totalVenda;
	private Cliente clienteVenda;
	public VendaDTO() {
		super();
	}
	public VendaDTO(Venda obj) {
		super();
		this.idVenda = obj.getIdVenda();
		this.dataVenda = obj.getDataVenda();
		this.totalVenda = obj.getTotalVenda();
		this.clienteVenda = obj.getClienteVenda();
	}
	public Long getIdVenda() {
		return idVenda;
	}
	public void setIdVenda(Long idVenda) {
		this.idVenda = idVenda;
	}
	public Date getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}
	public BigDecimal getTotalVenda() {
		return totalVenda;
	}
	public void setTotalVenda(BigDecimal totalVenda) {
		this.totalVenda = totalVenda;
	}
	public Cliente getClienteVenda() {
		return clienteVenda;
	}
	public void setClienteVenda(Cliente clienteVenda) {
		this.clienteVenda = clienteVenda;
	}
	
}
