package com.elizelia.salaoespacomulher.domain;

import java.util.Objects;

public class EntidadeBase {
	private Long id;

	public EntidadeBase() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EntidadeBase(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntidadeBase other = (EntidadeBase) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
