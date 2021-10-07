package com.elizelia.salaoespacomulher.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.elizelia.salaoespacomulher.domain.enums.StatusVenda;
import com.fasterxml.jackson.annotation.JsonIgnore;

@CrossOrigin("*")
@Entity
public class Venda implements Serializable{
	
	private static final long serialVersionUID = -4253162678476217325L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVenda;
	
	private BigDecimal totalVenda = new BigDecimal(0);

	@JsonIgnore
	@OneToMany(mappedBy = "Venda", fetch = FetchType.LAZY)
	private List<ItemVenda> itensVenda = new ArrayList<>();
	

	@JsonIgnore
	@ManyToOne
	@JoinColumn
	private Cliente clienteVenda;
	
	private StatusVenda statusVenda = StatusVenda.A;
	
	private GregorianCalendar dataHoraAgendamento = new GregorianCalendar(TimeZone.getTimeZone("GMT-3"),new Locale("pt_BR"));
	private GregorianCalendar dataHoraAtendimento;
	private GregorianCalendar dataHoraFinalizado;
	private GregorianCalendar dataHoraPagamentoVenda;
	
	public Venda() {
		super();
	}

	public Venda(Cliente clienteVenda) {
		super();
		this.clienteVenda = clienteVenda;
	}
	
	public Venda(List<ItemVenda> itensVenda, Cliente clienteVenda) {
		super();
		this.itensVenda = itensVenda;
		this.clienteVenda = clienteVenda;
		this.totalVenda = new BigDecimal(0);
		for(ItemVenda item : this.getItensVenda()) {
			this.totalVenda = this.totalVenda.add(item.getValorTotalItem());
		}
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

	public GregorianCalendar getDataHoraAgendamento() {
		return dataHoraAgendamento;
	}

	public void setDataHoraAgendamento(GregorianCalendar dataHoraAgendamento) {
		this.dataHoraAgendamento = dataHoraAgendamento;
	}

	public StatusVenda getStatusVenda() {
		return statusVenda;
	}

	public void setStatusVenda(StatusVenda statusVenda) {
		this.statusVenda = statusVenda;
	}

	
	public Cliente getClienteVenda() {
		return clienteVenda;
	}

	public void setClienteVenda(Cliente clienteVenda) {
		this.clienteVenda = clienteVenda;
	}

	public Long getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(Long idVenda) {
		this.idVenda = idVenda;
	}

	public List<ItemVenda> getItensVenda() {
		return itensVenda;
	}

	public void setItensVenda(List<ItemVenda> itensVenda) {
		this.itensVenda = itensVenda;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idVenda);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venda other = (Venda) obj;
		return Objects.equals(idVenda, other.idVenda);
	}

	public GregorianCalendar getDataHoraPagamentoVenda() {
		return dataHoraPagamentoVenda;
	}

	public void setDataHoraPagamentoVenda(GregorianCalendar dataHoraPagamentoVenda) {
		this.dataHoraPagamentoVenda = dataHoraPagamentoVenda;
	}

	public BigDecimal getTotalVenda() {
		return totalVenda;
	}

	public void setTotalVenda(BigDecimal totalVenda) {
		this.totalVenda = totalVenda;
	}
	
	
}
