package br.com.farmacia.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


import br.com.farmacia.DAO.FornecedoresDAO;
import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.util.JSFUtil;

@ManagedBean(name = "MBFornecedores")
@ViewScoped
public class FornecedoresBean {

	
	private Fornecedores fornecedores;
	private ArrayList<Fornecedores> itens;
	private ArrayList<Fornecedores> itensfiltrados;
	
	

	public Fornecedores getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(Fornecedores fornecedores) {
		this.fornecedores = fornecedores;
	}
	
	public ArrayList<Fornecedores> getItens() {
		return itens;
	}
	
	public void setItens(ArrayList<Fornecedores> itens) {
		this.itens = itens;
	}
	
	public ArrayList<Fornecedores> getItensfiltrados() {
		return itensfiltrados;
	}
	
	public void setItensfiltrados(ArrayList<Fornecedores> itensfiltrados) {
		this.itensfiltrados = itensfiltrados;
	}

	

	

	@PostConstruct
	public void prepararPesquisa() {

		try {
			FornecedoresDAO fdao = new FornecedoresDAO();
			itens = fdao.listar();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JSFUtil.adicionarMensagemErro("ex.getMessage");
			e.printStackTrace();
		}
	}

	public void prepararNovo() {
		fornecedores = new Fornecedores();
	}

	public void novo() {

		try {
			FornecedoresDAO fdao = new FornecedoresDAO();
			fdao.salvar(fornecedores);

			itens = fdao.listar();
			

			JSFUtil.adicionarMensagemSucesso("Fornecedor salvo com sucesso!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro! O preenchimento do campo é necessário!");
		}
	}

	//public void prepararExcluir() {
		//fornecedores = itens.getRowData();
	//}

	public void excluir() {

		try {
			FornecedoresDAO fdao = new FornecedoresDAO();
			fdao.excluir(fornecedores);

			itens = fdao.listar();			

			JSFUtil.adicionarMensagemSucesso("Fornecedor excluído com sucesso!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JSFUtil.adicionarMensagemErro("Não é possível excluir um fornecedor que possua um produto associado");
			e.printStackTrace();
		}

	}

	/*public void prepararEditar() {
		fornecedores = itens.getRowData();
	}*/
	
	

	public void editar() {

		try {
			FornecedoresDAO fdao = new FornecedoresDAO();
			fdao.editar(fornecedores);

			itens = fdao.listar();
			
			JSFUtil.adicionarMensagemSucesso("Fornecedor editado com sucesso!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}

	}

}
