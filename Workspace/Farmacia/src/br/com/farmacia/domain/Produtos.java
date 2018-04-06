package br.com.farmacia.domain;

public class Produtos {
	
	private long codigo;
	private String description;
	private long quantidade;
	private double preco;
	private Fornecedores fornecedores = new Fornecedores();
	
	
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
	public long getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(long quantidade) {
		this.quantidade = quantidade;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public Fornecedores getFornecedores() {
		return fornecedores;
	}
	public void setFornecedores(Fornecedores fornecedores) {
		this.fornecedores = fornecedores;
	}
	
	@Override
	public String toString() {
		String saida = "Código = " + codigo + " - Descrição= " + description +
				" - Quantidade= " + quantidade + " / " ;
		return saida;
	}
	
	
	

}
