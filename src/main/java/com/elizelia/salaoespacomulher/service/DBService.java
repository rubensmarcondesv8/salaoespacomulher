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
import com.elizelia.salaoespacomulher.domain.Cliente;
import com.elizelia.salaoespacomulher.domain.ItemVenda;
import com.elizelia.salaoespacomulher.domain.Produto;
import com.elizelia.salaoespacomulher.domain.Profissional;
import com.elizelia.salaoespacomulher.domain.Servico;
import com.elizelia.salaoespacomulher.domain.Venda;
import com.elizelia.salaoespacomulher.repositories.CatProdutoRepository;
import com.elizelia.salaoespacomulher.repositories.CatProfissionalRepository;
import com.elizelia.salaoespacomulher.repositories.CatServicoRepository;
import com.elizelia.salaoespacomulher.repositories.ClienteRepository;
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
	@Autowired
	private ClienteRepository clienteRepository;

	public void instanciaBaseDeDados() {
		CatProduto cab1 = new CatProduto("C001", "Produtos para lavar cabelo");
		CatProduto maq1 = new CatProduto("M001", "Produtos para automaquiagem");
		
		Produto prod1 = new Produto("Shampoo1", "Shampoo Eudora Leite 500ml", BigDecimal.valueOf(13.50), cab1);
		Produto prod2 = new Produto("Shampoo2", "Shampoo Oxx Erva Doce 300ml", BigDecimal.valueOf(10.80), cab1);
		Produto prod3 = new Produto("Batom1", "Batom Matte Eudora Cores Diversas", BigDecimal.valueOf(6.15), maq1);
		
		List<Produto> listaProd = new ArrayList<>();
		listaProd.add(prod1);
		listaProd.add(prod1);
		cab1.setProdutosLista(listaProd);
		listaProd.clear();
		listaProd.add(prod3);
		maq1.setProdutosLista(listaProd);

		this.catProdutoRepository.saveAll(Arrays.asList(cab1, maq1));
		this.produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3));

		CatProfissional cp1 = new CatProfissional("CPR2", "Cableleireira Parceira", BigDecimal.valueOf(0.15));
		CatProfissional mp1 = new CatProfissional("MPR2", "Manicure Parceira", BigDecimal.valueOf(0.20));
		
		Profissional p1 = new Profissional("Elizelia Marcondes", "31999880011", "11111111111", "Rua 8, 88 - Rib. das Neves, MG");
		Profissional p2 = new Profissional("Michele Carina", "31999882222", "22222222222", "Rua 6, 56 - BH, MG");
		Profissional p3 = new Profissional("Keila Lorenzo", "31999883344", "33333333333", "Rua José, 110 - BH, MG");
		
		p1.getCatProfissional().addAll(Arrays.asList(cp1));
		p2.getCatProfissional().addAll(Arrays.asList(cp1, mp1));
		p3.getCatProfissional().addAll(Arrays.asList(mp1));
		
		this.profissionalRepository.saveAll(Arrays.asList(p1, p2, p3));
		this.catProfissionalRepository.saveAll(Arrays.asList(mp1, cp1));
		
		CatServico cabelo1 = new CatServico("CB01", "Corte");
		CatServico unha1 = new CatServico("UN01", "Esmalte");
		Servico servico1 = new Servico("Corte", "Corte de cabelo feminino", BigDecimal.valueOf(40), cabelo1);
		Servico servico2 = new Servico("Esmalte pé", "Fazer unha do pé", BigDecimal.valueOf(20), unha1);
		Servico servico3 = new Servico("Esmalte mão", "Fazer unha da mão", BigDecimal.valueOf(22), unha1);
		Servico servico4 = new Servico("Tintura", "Pintar cabelo", BigDecimal.valueOf(30), cabelo1);

		this.catServicoRepository.saveAll(Arrays.asList(cabelo1, unha1));
		this.servicoRepository.saveAll(Arrays.asList(servico1, servico2, servico3, servico4));
		
		Date d1 = new Date();

		Cliente c1 = new Cliente("Cintia Marcondes", "31988778866");
		Cliente c2 = new Cliente("Luzia Rosa", "31988770011");
		Cliente c3 = new Cliente("Daniela Falcão", "31988007700");
		Cliente c4 = new Cliente("Evaldo Pereira", "31990904477");
		
		
		ItemVenda item1 = new ItemVenda(1L, prod1, null, p1);
		ItemVenda item2 = new ItemVenda(3L, prod3, null, p1);
		ItemVenda item3 = new ItemVenda(1L, null, servico1, p2);
		ItemVenda item4 = new ItemVenda(1L, null, servico2, p3);
		ItemVenda item5 = new ItemVenda(2L, prod2, null, p2);
		ItemVenda item6 = new ItemVenda(1L, null, servico3, p2);
		ItemVenda item7 = new ItemVenda(1L, null, servico4, p3);
		ItemVenda item8 = new ItemVenda(5L, prod1, null, p1);
		
		
		List<ItemVenda> list = new ArrayList<>();
		list.addAll(Arrays.asList(item1, item2));
		Venda venda1 = new Venda(d1, list, c1);
		item1.setVenda(venda1);
		item2.setVenda(venda1);
		list.clear();
		list.addAll(Arrays.asList(item4, item3));
		Venda venda2 = new Venda(d1, list, c2);
		item3.setVenda(venda2);
		item4.setVenda(venda2);
		list.clear();
		list.addAll(Arrays.asList(item5, item6));
		Venda venda3 = new Venda(d1, list, c3);
		item5.setVenda(venda3);
		item6.setVenda(venda3);
		list.clear();
		list.addAll(Arrays.asList(item7, item8));
		Venda venda4 = new Venda(d1, list, c4);
		item7.setVenda(venda4);
		item8.setVenda(venda4);
		
		this.clienteRepository.saveAll(Arrays.asList(c1, c2, c3, c4));		
		this.vendaRepository.saveAll(Arrays.asList(venda1, venda2, venda3, venda4));
		this.itemVendaRepository.saveAll(Arrays.asList(item1, item2, item3, item4, item5, item6, item7, item8));
	}

}
