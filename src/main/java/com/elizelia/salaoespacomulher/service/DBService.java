package com.elizelia.salaoespacomulher.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elizelia.salaoespacomulher.domain.CatProduto;
import com.elizelia.salaoespacomulher.domain.CatProfissional;
import com.elizelia.salaoespacomulher.domain.CatServico;
import com.elizelia.salaoespacomulher.domain.ItemVenda;
import com.elizelia.salaoespacomulher.domain.Produto;
import com.elizelia.salaoespacomulher.domain.Profissional;
import com.elizelia.salaoespacomulher.domain.Servico;
import com.elizelia.salaoespacomulher.domain.Venda;
import com.elizelia.salaoespacomulher.repositories.CatProdutoRepository;
import com.elizelia.salaoespacomulher.repositories.CatProfissionalRepository;
import com.elizelia.salaoespacomulher.repositories.CatServicoRepository;
import com.elizelia.salaoespacomulher.repositories.ItemVendaRepository;
import com.elizelia.salaoespacomulher.repositories.ProdutoRepository;
import com.elizelia.salaoespacomulher.repositories.ProfissionalRepository;
import com.elizelia.salaoespacomulher.repositories.ServicoRepository;
import com.elizelia.salaoespacomulher.repositories.VendaRepository;

@Service
public class DBService {
	@Autowired
	private CatServicoRepository catServicoRepository;
	@Autowired
	private ServicoRepository servicoRepository;
	@Autowired
	private CatProfissionalRepository catProfissionalRepository;
	@Autowired
	private ProfissionalRepository profissionalRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CatProdutoRepository catProdutoRepository;
	@Autowired
	private VendaRepository vendaRepository;
	@Autowired
	private ItemVendaRepository itemVendaRepository;

	public void instanciaBaseDeDados() {
		CatServico cabelo1 = new CatServico("CAB1", "Corte");
		CatServico unha1 = new CatServico("UNH1", "Esmalte");
		Servico servico1 = new Servico("COR1", "Corte de cabelo feminino", BigDecimal.valueOf(40), cabelo1);
		Servico servico2 = new Servico("PE01", "Fazer unha do pé", BigDecimal.valueOf(20), unha1);
		Servico servico3 = new Servico("MAO1", "Fazer unha da mão", BigDecimal.valueOf(22), unha1);
		Servico servico4 = new Servico("TIN1", "Pintar cabelo", BigDecimal.valueOf(30), cabelo1);

		CatProfissional cp1 = new CatProfissional("CPR2", "Cableleireira Parceira", BigDecimal.valueOf(0.15));
		List<CatProfissional> categorias = new ArrayList<>();
		categorias.add(cp1);
		Profissional p1 = new Profissional("Elizelia Marcondes", "31999880011", "11111111111", categorias);
		Profissional p2 = new Profissional("Michele Carina", "31999882222", "22222222222", categorias);

		List<Profissional> prof = new ArrayList<>();
		prof.add(p1);
		prof.add(p2);
		cp1.setProfissionais(prof);

		CatProduto catpr1 = new CatProduto("CABELO", "Produtos para cabelo geral");
		Produto prod1 = new Produto("Shampoo1", "Shampoo Eudora Leite 500ml", BigDecimal.valueOf(13.50), catpr1);
		Produto prod2 = new Produto("Shampoo2", "Shampoo Oxx Erva Doce 300ml", BigDecimal.valueOf(10.80), catpr1);
		List<Produto> prList = new ArrayList<>();
		prList.add(prod1);
		prList.add(prod2);

		catpr1.setProdutosLista(prList);

		Date d1 = new Date();
		Venda venda1 = new Venda(d1);
		ItemVenda item = new ItemVenda(venda1);
		List<ItemVenda> lista = new ArrayList<>();
		lista.add(item);

		this.catServicoRepository.saveAll(Arrays.asList(cabelo1, unha1));
		this.servicoRepository.saveAll(Arrays.asList(servico1, servico2, servico3, servico4));

		this.catProfissionalRepository.saveAll(Arrays.asList(cp1));
		this.profissionalRepository.saveAll(Arrays.asList(p1, p2));

		this.catProdutoRepository.saveAll(Arrays.asList(catpr1));
		this.produtoRepository.saveAll(Arrays.asList(prod1, prod2));

		this.vendaRepository.saveAll(Arrays.asList(venda1));
		this.itemVendaRepository.saveAll(Arrays.asList(item));
	}

}
