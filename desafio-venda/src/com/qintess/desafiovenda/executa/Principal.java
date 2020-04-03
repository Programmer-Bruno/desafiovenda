package com.qintess.desafiovenda.executa;

import com.qintess.desafiovenda.dao.DAO;
import com.qintess.desafiovenda.model.Fornecedor;
import com.qintess.desafiovenda.model.Fornecedor_Produto;
import com.qintess.desafiovenda.model.Produto;
import com.qintess.desafiovenda.model.Venda;
import com.qintess.desafiovenda.model.VendaItens;

public class Principal {

	public static void main(String[] args) {

//		Produto produto = new Produto(5.00, 100, "Candida");
//		DAO<Produto> produtoDAO = new DAO<Produto>();
//		produtoDAO.insere(produto);
//		produtoDAO.buscaTodos(produto).forEach(s -> System.out.println(s));
//		produto.setPreco_venda(6.00);
//		produtoDAO.atualiza(produto);
//
//		Produto produto2 = new Produto();
//		produtoDAO.buscaTodos(produto2).forEach(s -> System.out.println(s));
//
//		System.out.println(produtoDAO.buscaPorID(produto, 1));
		
		Fornecedor italac = new Fornecedor("ITALAC", "11976536329", "1142678541");
		
		Produto leiteIntItalac = new Produto(2.50, 100, "LEITE INTEGRAL ITALAC");
		
		Fornecedor_Produto forpro = new Fornecedor_Produto(italac, leiteIntItalac, 100, 1.99);
		
		DAO<Fornecedor> fornecedorDao = new DAO<Fornecedor>();
		DAO<Produto> produtoDao = new DAO<Produto>();
		DAO<Fornecedor_Produto> forproDao = new DAO<Fornecedor_Produto>();
		DAO<Venda> vendaDao = new DAO<Venda>();
		DAO<VendaItens> vendaItens = new DAO<VendaItens>();
		produtoDao.insere(leiteIntItalac);
		fornecedorDao.insere(italac);
		forproDao.insere(forpro);
		
		Venda venda = new Venda(1, 10, "CC");
		VendaItens vendaI = new VendaItens(leiteIntItalac, venda, 2, forpro.getPreco_custo(), 
															leiteIntItalac.getPreco_venda());
		
		venda.setItem(vendaI);
		vendaDao.insere(venda);
		vendaItens.insere(vendaI);
		
	}
}
