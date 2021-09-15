package com.elizelia.salaoespacomulher.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Venda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVenda;
	private Date dataVenda;
	private BigDecimal totalVenda;
	@OneToMany(mappedBy = "Venda", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<ItemVenda> itensVenda = new ArrayList<>();
	
	@ManyToOne
	private Cliente clienteVenda;

	public Venda(Date dataVenda, Cliente clienteVenda) {
		super();
		this.dataVenda = dataVenda;
		this.clienteVenda = clienteVenda;
	}

	public Cliente getClienteVenda() {
		return clienteVenda;
	}

	public void setClienteVenda(Cliente clienteVenda) {
		this.clienteVenda = clienteVenda;
	}

	public Venda() {
	}

	public Venda(Date dataVenda) {
		super();
		this.dataVenda = dataVenda;
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

	public List<ItemVenda> getItensVenda() {
		return itensVenda;
	}

	public void setItensVenda(List<ItemVenda> itensVenda) {
		this.itensVenda = itensVenda;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataVenda);
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
	
	
}
