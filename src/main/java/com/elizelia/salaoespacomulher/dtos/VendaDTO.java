package com.elizelia.salaoespacomulher.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.elizelia.salaoespacomulher.domain.Cliente;
import com.elizelia.salaoespacomulher.domain.ItemVenda;
import com.elizelia.salaoespacomulher.domain.Venda;
import com.elizelia.salaoespacomulher.domain.enums.StatusVenda;

public class VendaDTO implements Serializable{
	private static final long serialVersionUID = 4220710453311622476L;

	private Long idVenda;
	@NotEmpty(message = "Campo necessário")
	private BigDecimal totalVenda;
	@NotEmpty(message = "Campo necessário")
	private Cliente clienteVenda;
	
	private List<ItemVenda> itensVenda = new ArrayList<>();
	
	private GregorianCalendar dataHoraPagamentoVenda;
	
	public StatusVenda getStatusVenda() {
		return statusVenda;
	}
	public void setStatusVenda(StatusVenda statusVenda) {
		this.statusVenda = statusVenda;
	}
	public GregorianCalendar getDataHoraAgendamento() {
		return dataHoraAgendamento;
	}
	public void setDataHoraAgendamento(GregorianCalendar dataHoraAgendamento) {
		this.dataHoraAgendamento = dataHoraAgendamento;
	}
	public GregorianCalendar getDataHoraAtendimento() {
		return dataHoraAtendimento;
	}
	public void setDataHoraAtendimento(GregorianCalendar dataHoraAtendimento) {
		this.dataHoraAtendimento = dataHoraAtendimento;
	}
	public GregorianCalendar getDataHoraFinalizado() {
		return dataHoraFinalizado;
	}
	public void setDataHoraFinalizado(GregorianCalendar dataHoraFinalizado) {
		this.dataHoraFinalizado = dataHoraFinalizado;
	}
	private StatusVenda statusVenda = StatusVenda.A;
	
	private GregorianCalendar dataHoraAgendamento;
	private GregorianCalendar dataHoraAtendimento;
	private GregorianCalendar dataHoraFinalizado;
	
	public VendaDTO() {
		super();
	}
	public VendaDTO(Venda obj) {
		super();
		this.idVenda = obj.getIdVenda();
		this.totalVenda = obj.getTotalVenda();
		this.clienteVenda = obj.getClienteVenda();
		this.itensVenda = obj.getItensVenda();
		this.dataHoraPagamentoVenda = obj.getDataHoraPagamentoVenda();
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
	public GregorianCalendar getDataHoraPagamentoVenda() {
		return dataHoraPagamentoVenda;
	}
	public void setDataHoraPagamentoVenda(GregorianCalendar dataHoraPagamentoVenda) {
		this.dataHoraPagamentoVenda = dataHoraPagamentoVenda;
	}
	
}
