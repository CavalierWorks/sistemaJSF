package br.com.farmacia.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.domain.Produtos;
import br.com.farmacia.factory.ConexaoFactory;

public class ProdutoDAO {
	
	public void salvar(Produtos p) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO produtos" );
		sql.append("(description, preco, quantidade, fornecedores_codigo )");
		sql.append("VALUES (?, ?, ?, ? )");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, p.getDescription());
		comando.setDouble(2, p.getPreco());
		comando.setLong(3, p.getQuantidade());
		comando.setLong(4, p.getFornecedores().getCodigo());
		comando.executeUpdate();

	}
	
	public void excluir(Produtos p) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM produtos ");
		sql.append("WHERE codigo = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, p.getCodigo());
		comando.executeUpdate();

	}
	
	public void editar(Produtos p) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE produtos " );
		sql.append("SET description = ?, preco = ?, quantidade = ?, fornecedores_codigo = ? ");
		sql.append("WHERE codigo = ? " );

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, p.getDescription());
		comando.setDouble(2, p.getPreco());
		comando.setLong(3, p.getQuantidade());
		comando.setLong(4, p.getFornecedores().getCodigo());
		comando.setLong(5, p.getCodigo());
		comando.executeUpdate();

	}
	
	public ArrayList<Produtos> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT p.codigo, p.description, p.preco, p.quantidade, f.codigo, f.description ");
		sql.append("FROM produtos p ");// prestar atenção a esse espaço no final. Me fudeu!
		sql.append("INNER JOIN fornecedores f ON f.codigo = p.fornecedores_codigo ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<Produtos> lista = new ArrayList<Produtos>();

		while (resultado.next()) {
			Fornecedores f = new Fornecedores();
			f.setCodigo(resultado.getLong("f.codigo"));
			f.setDescription(resultado.getString("f.description"));
			
			Produtos p = new Produtos();
			
			p.setCodigo(resultado.getLong("p.codigo"));
			p.setDescription(resultado.getString("p.description"));
			p.setPreco(resultado.getLong("p.preco"));
			p.setQuantidade(resultado.getLong("p.quantidade"));
			p.setFornecedores(f);

			lista.add(p);

		}

		return lista;
	}
	
	public static void main(String[] args) throws SQLException {
		
		/*Produtos p = new Produtos();
		p.setDescription("Super Droguinha!");
		p.setPreco(99.90);
		p.setQuantidade(154);
		
		Fornecedores f = new Fornecedores();
		f.setCodigo(5);
		p.setFornecedores(f);	
		
		
		ProdutoDAO fdao = new ProdutoDAO();
		//FornecedoresDAO fdao = new FornecedoresDAO();
		
		try {
			fdao.salvar(p);
			System.out.println(" Salvo com Sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		
		/*ProdutoDAO pdao = new ProdutoDAO();
		ArrayList<Produtos> lista = pdao.listar();	

		
		for(Produtos p : lista) {
			System.out.println("--------------------------------------");
			System.out.println("Código do Produto: " + p.getCodigo());
			System.out.println("Descrição do Produto: " + p.getDescription());
			System.out.println("Valor do Produto: " + p.getPreco());
			System.out.println("Quantidade do Produto: " + p.getQuantidade());
			System.out.println("Codigo do Fornecedor: " + p.getFornecedores().getCodigo());
			System.out.println("Descrição do Fornecedor: " + p.getFornecedores().getDescription());
			System.out.println("--------------------------------------");
		}*/
		
		/*Produtos p = new Produtos();
		p.setCodigo(7);
		
		ProdutoDAO pdao = new ProdutoDAO();
		pdao.excluir(p);*/
		
		Produtos p = new Produtos();
		p.setCodigo(1);
		p.setDescription("SALSICHAO");
		p.setPreco(35);
		p.setQuantidade(1574);
		
		Fornecedores f = new Fornecedores();
		f.setCodigo(1);
		p.setFornecedores(f);
		
		
		ProdutoDAO pdao = new ProdutoDAO();
		pdao.editar(p);
		
		
	}

}
