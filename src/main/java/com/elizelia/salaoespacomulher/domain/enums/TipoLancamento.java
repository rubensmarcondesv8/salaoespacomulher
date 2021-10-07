package com.elizelia.salaoespacomulher.domain.enums;

public enum TipoLancamento {
	D("Débito"),
	C("Crédito");
	
	private String descricao;

	private TipoLancamento(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
