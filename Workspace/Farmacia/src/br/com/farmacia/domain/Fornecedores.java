package br.com.farmacia.domain;

public class Fornecedores {
	
	private long codigo;
	private String description;
	
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		String saida = codigo + " - " + description;
		return saida;
	}

}
