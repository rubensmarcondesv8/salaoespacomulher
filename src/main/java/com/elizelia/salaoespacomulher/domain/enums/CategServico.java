package com.elizelia.salaoespacomulher.domain.enums;

public enum CategServico {
	CO01("Corte de cabelo feminino"),
	UN01("Unha da mão");
	
	private String descricao;
	
	private CategServico(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
