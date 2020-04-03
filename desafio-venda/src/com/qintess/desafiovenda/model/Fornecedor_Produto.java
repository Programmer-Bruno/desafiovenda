package com.qintess.desafiovenda.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Fornecedor_Produto {

	@EmbeddedId
	private FornecedorProdutoID id;
	private  int estoque;
	@Column(precision=10, scale=2)
	private double preco_custo;
	
	public Fornecedor_Produto() {
	}
	
	public Fornecedor_Produto(Fornecedor fornecedor, Produto produto, int estoque, double preco_custo) {
		this.id = new FornecedorProdutoID(fornecedor, produto);
		this.estoque = estoque;
		this.preco_custo = preco_custo;
	}

	public FornecedorProdutoID getId() {
		return id;
	}
	public void setId(FornecedorProdutoID id) {
		this.id = id;
	}
	public int getEstoque() {
		return estoque;
	}
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	public double getPreco_custo() {
		return preco_custo;
	}
	public void setPreco_custo(double preco_custo) {
		this.preco_custo = preco_custo;
	}
	
	
}
