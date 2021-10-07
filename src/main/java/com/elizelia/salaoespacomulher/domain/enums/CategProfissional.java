package com.elizelia.salaoespacomulher.domain.enums;

public enum CategProfissional {
	CAB1("Cabeleireira"),
	MAN1("Manicure");
	
	private String descricao;
	
	private CategProfissional(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}

}
