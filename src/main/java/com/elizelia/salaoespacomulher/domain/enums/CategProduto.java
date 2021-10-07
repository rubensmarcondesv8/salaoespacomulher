package com.elizelia.salaoespacomulher.domain.enums;

public enum CategProduto {
	SH01("Shampoo Comum"),
	CN01("Condicionador Comum");
	
	private String descricao;
	
	private CategProduto(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

}
