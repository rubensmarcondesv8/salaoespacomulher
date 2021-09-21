package com.elizelia.salaoespacomulher.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.elizelia.salaoespacomulher.domain.Cliente;
import com.elizelia.salaoespacomulher.domain.ItemVenda;
import com.elizelia.salaoespacomulher.domain.Venda;

public class VendaDTO implements Serializable{
	private static final long serialVersionUID = 4220710453311622476L;

	private Long idVenda;
	@NotEmpty(message = "Campo necessário")
	private Date dataVenda;
	private BigDecimal totalVenda;
	@NotEmpty(message = "Campo necessário")
	private Cliente clienteVenda;
	
	private List<ItemVenda> itensVenda = new ArrayList<>();
	
	public VendaDTO() {
		super();
	}
	public VendaDTO(Venda obj) {
		super();
		this.idVenda = obj.getIdVenda();
		this.dataVenda = obj.getDataVenda();
		this.totalVenda = obj.getTotalVenda();
		this.clienteVenda = obj.getClienteVenda();
		this.itensVenda = obj.getItensVenda();
	}
	public List<ItemVenda> getItensVenda() {
		return itensVenda;
	}
	public void setItensVenda(List<ItemVenda> itensVenda) {
		this.itensVenda = itensVenda;
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
