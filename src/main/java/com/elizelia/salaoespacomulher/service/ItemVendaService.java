package com.elizelia.salaoespacomulher.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elizelia.salaoespacomulher.domain.ItemVenda;
import com.elizelia.salaoespacomulher.domain.Lancamento;
import com.elizelia.salaoespacomulher.domain.Venda;
import com.elizelia.salaoespacomulher.repositories.ContaCorrenteRepository;
import com.elizelia.salaoespacomulher.repositories.ItemVendaRepository;
import com.elizelia.salaoespacomulher.service.exceptions.ObjectNotFoundException;

@Service
public class ItemVendaService {
	@Autowired
	private ItemVendaRepository repository;
	@Autowired
	private ContaCorrenteRepository contaRepository;
	@Autowired
	private VendaService VendaService;
	@Autowired
	private LancamentoService lancamentoService;
	
	public ItemVenda findById(Long idItemVenda) {
		Optional<ItemVenda> obj = repository.findById(idItemVenda);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado. Id: " + idItemVenda + ". Tipo: " + ItemVenda.class.getName()));
	}
	public List<ItemVenda> findAll(Long idVenda) {
		VendaService.findById(idVenda);
		return repository.findAllByIdVenda(idVenda);
	}
	public ItemVenda update(Long idItemVenda, ItemVenda obj) {
		ItemVenda newObj = findById(idItemVenda);
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	private void updateData(ItemVenda newObj, ItemVenda obj) {
		newObj.setQuantidadeItem(obj.getQuantidadeItem());
		if(obj.getItemProduto() != null && obj.getVenda().getStatusVenda().equals("Pago")) {			
			newObj.setItemProduto(obj.getItemProduto());
			obj.setValorTotalItem(obj.getItemProduto().getPrecoUnitario().multiply(new BigDecimal(obj.getQuantidadeItem())));
			
			Lancamento pagamentoSalao = new Lancamento();
			Lancamento comissaoProfissional = new Lancamento();			
			
			comissaoProfissional.setTipoLancamento("Crédito");
			comissaoProfissional.setValorLancamento(obj.getValorTotalItem().multiply(obj.getItemProduto().getComissaoProduto()));
			comissaoProfissional.setDescrLancamento("Comissão - " + obj.getItemProduto().getNomeProduto());
			
			pagamentoSalao.setTipoLancamento("Crédito");
			pagamentoSalao.setValorLancamento(obj.getValorTotalItem().subtract(comissaoProfissional.getValorLancamento()));
			pagamentoSalao.setDescrLancamento("Venda - " + obj.getItemProduto().getNomeProduto() + " - " + obj.getProfissionalVenda().getNomeProfissional());
			
			lancamentoService.create(obj.getProfissionalVenda().getContacorrente().getIdContaCorrente(), comissaoProfissional);
			lancamentoService.create(contaRepository.findByNumeroContaCorrente("04691198623").getIdContaCorrente() , pagamentoSalao);		
		}
		if(obj.getItemServico() != null && obj.getVenda().getStatusVenda().equals("Pago")) {			
			newObj.setItemServico(obj.getItemServico());
			obj.setValorTotalItem(obj.getItemServico().getPrecoBaseServico().multiply(new BigDecimal(obj.getQuantidadeItem())));
			
			Lancamento comissaoSalao = new Lancamento();
			Lancamento pagamentoProfissional = new Lancamento();
			
			comissaoSalao.setTipoLancamento("Crédito");
			comissaoSalao.setValorLancamento(obj.getValorTotalItem().multiply(obj.getItemServico().getComissaoSalao()));
			comissaoSalao.setDescrLancamento("Comissao - " + obj.getItemServico().getNomeServico() + " - " + obj.getProfissionalVenda().getNomeProfissional());
			
			pagamentoProfissional.setTipoLancamento("Crédito");
			pagamentoProfissional.setValorLancamento(obj.getValorTotalItem().subtract(comissaoSalao.getValorLancamento()));
			pagamentoProfissional.setDescrLancamento("Pgto - " + obj.getItemServico().getNomeServico());
			
			lancamentoService.create(obj.getProfissionalVenda().getContacorrente().getIdContaCorrente(), pagamentoProfissional);
			lancamentoService.create(contaRepository.findByNumeroContaCorrente("04691198623").getIdContaCorrente() , comissaoSalao);
		}
		newObj.setProfissionalVenda(obj.getProfissionalVenda());
	}
	public ItemVenda create(Long idVenda, ItemVenda obj) {
		obj.setIdItem(null);
		
		if(obj.getItemProduto() != null) {			
			obj.setValorTotalItem(obj.getItemProduto().getPrecoUnitario().multiply(new BigDecimal(obj.getQuantidadeItem())));	
		}
		if(obj.getItemServico() != null) {			
			obj.setValorTotalItem(obj.getItemServico().getPrecoBaseServico().multiply(new BigDecimal(obj.getQuantidadeItem())));
			
		}
		
		Venda venda = VendaService.findById(idVenda);
		venda.setTotalVenda(venda.getTotalVenda().add(obj.getValorTotalItem()));
		List<ItemVenda> lista = new ArrayList<>();
		lista = venda.getItensVenda();
		lista.add(obj);
		venda.setItensVenda(lista);
		VendaService.update(idVenda, venda);
		obj.setVenda(venda);
		return repository.save(obj);
	}
	public void delete(Long idItemVenda) {
		ItemVenda obj = findById(idItemVenda);
		Venda venda = VendaService.findById(obj.getVenda().getIdVenda());
		venda.setTotalVenda(venda.getTotalVenda().subtract(obj.getValorTotalItem()));
		List<ItemVenda> lista = new ArrayList<>();
		lista = venda.getItensVenda();
		lista.remove(obj);
		venda.setItensVenda(lista);
		VendaService.update(obj.getVenda().getIdVenda(), venda);
		repository.delete(obj);	
	}
}
