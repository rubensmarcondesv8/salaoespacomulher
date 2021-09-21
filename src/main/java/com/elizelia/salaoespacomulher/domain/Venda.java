package com.elizelia.salaoespacomulher.domain;

import java.io.Serializable;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonIgnore;

@CrossOrigin("*")
@Entity
public class Venda implements Serializable{
	
	private static final long serialVersionUID = -4253162678476217325L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVenda;
	
	private Date dataVenda;
	private BigDecimal totalVenda = new BigDecimal(0);

	@JsonIgnore
	@OneToMany(mappedBy = "Venda", fetch = FetchType.LAZY)
	private List<ItemVenda> itensVenda = new ArrayList<>();
	
	public void setTotalVenda(BigDecimal totalVenda) {
		this.totalVenda = totalVenda;
	}

	@JsonIgnore
	@ManyToOne
	@JoinColumn
	private Cliente clienteVenda;

	public Venda(Date dataVenda, Cliente clienteVenda) {
		super();
		this.dataVenda = dataVenda;
		this.clienteVenda = clienteVenda;
	}
	
	

	public Venda(Date dataVenda, BigDecimal totalVenda,
			List<ItemVenda> itensVenda, Cliente clienteVenda) {
		super();
		this.dataVenda = dataVenda;
		this.itensVenda = itensVenda;
		this.clienteVenda = clienteVenda;
		this.totalVenda = new BigDecimal(0);
		for(ItemVenda item : this.getItensVenda()) {
			this.totalVenda = this.totalVenda.add(item.getValorTotalItem());
		}
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

	public void setTotalVenda() {
		this.totalVenda = new BigDecimal(0);
		for(ItemVenda item : this.getItensVenda()) {
			this.totalVenda = this.totalVenda.add(item.getValorTotalItem());
		}
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
