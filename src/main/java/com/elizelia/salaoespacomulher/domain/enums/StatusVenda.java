package com.elizelia.salaoespacomulher.domain.enums;

public enum StatusVenda {
	A("Aberto"),
	X("Em atendimento"),
	C("Finalizado"),
	P("Pago");
	
	private String descricao;
	
	private StatusVenda(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

}
