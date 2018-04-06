package br.com.farmacia.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.farmacia.DAO.FornecedoresDAO;
import br.com.farmacia.DAO.ProdutoDAO;
import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.domain.Produtos;
import br.com.farmacia.util.JSFUtil;

@ManagedBean(name = "MBProduto")
@ViewScoped
public class ProdutoBean {

	
	private Produtos produtos;
	private ArrayList<Produtos> itens;
	private ArrayList<Produtos> itensfiltrados;
	
	private ArrayList<Fornecedores>comboFornecedores;
	
	
	
	
	
	

	public ArrayList<Fornecedores> getComboFornecedores() {
		return comboFornecedores;
	}

	public void setComboFornecedores(ArrayList<Fornecedores> comboFornecedores) {
		this.comboFornecedores = comboFornecedores;
	}

	public Produtos getProdutos() {
		return produtos;
	}

	public void setProdutos(Produtos produtos) {
		this.produtos = produtos;
	}
	
	public ArrayList<Produtos> getItens() {
		return itens;
	}
	
	public void setItens(ArrayList<Produtos> itens) {
		this.itens = itens;
	}
	
	public ArrayList<Produtos> getItensfiltrados() {
		return itensfiltrados;
	}
	
	public void setItensfiltrados(ArrayList<Produtos> itensfiltrados) {
		this.itensfiltrados = itensfiltrados;
	}	

	

	@PostConstruct
	public void prepararPesquisa() {

		try {
			ProdutoDAO pdao = new ProdutoDAO();
			itens = pdao.listar();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JSFUtil.adicionarMensagemErro("ex.getMessage");
			e.printStackTrace();
		}
	}
	
	public void prepararNovo() {
		
		try {
			produtos = new Produtos();			
			FornecedoresDAO dao = new FornecedoresDAO();
			comboFornecedores = dao.listar();
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage");
			e.printStackTrace();
		}
	}
	
	public void novo() {

		try {
			ProdutoDAO pdao = new ProdutoDAO();
			pdao.salvar(produtos);

			itens = pdao.listar();
			

			JSFUtil.adicionarMensagemSucesso("Produto salvo com sucesso!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void excluir() {

		try {
			ProdutoDAO pdao = new ProdutoDAO();
			pdao.excluir(produtos);

			itens = pdao.listar();			

			JSFUtil.adicionarMensagemSucesso("Produto excluído com sucesso!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}

	}
	
	public void editar() {

		try {
			ProdutoDAO pdao = new ProdutoDAO();
			pdao.editar(produtos);

			itens = pdao.listar();
			
			JSFUtil.adicionarMensagemSucesso("Produto editado com sucesso!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}

	}
	
public void prepararEditar() {
		
		try {
			produtos = new Produtos();			
			FornecedoresDAO dao = new FornecedoresDAO();
			comboFornecedores = dao.listar();
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage");
			e.printStackTrace();
		}
	}
	
}