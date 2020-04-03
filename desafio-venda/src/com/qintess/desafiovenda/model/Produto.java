package com.qintess.desafiovenda.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Produto implements GETTINTEGER{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(precision = 10, scale =2)
	private double preco_venda;
	private int min_estoque;
	@Column(length = 45)
	private String nome;
	private String foto;

	@OneToMany(mappedBy = "produto")
	List<VendaItens> produtos = new ArrayList<VendaItens>();
	
	@Override
	public String toString() {
		return "Produto [id=" + id + ", preco_venda=" + preco_venda + ", min_estoque=" + min_estoque + ", nome=" + nome
				+ ", foto=" + foto + "]";
	}
	
	public Produto () {}
	public Produto(double preco_venda, int min_estoque, String nome) {
		this.preco_venda = preco_venda;
		this.min_estoque = min_estoque;
		this.nome = nome;
		this.foto = null;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public double getPreco_venda() {
		return preco_venda;
	}
	public void setPreco_venda(double preco_venda) {
		this.preco_venda = preco_venda;
	}
	public int getMin_estoque() {
		return min_estoque;
	}
	public void setMin_estoque(int min_estoque) {
		this.min_estoque = min_estoque;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = null;
	}
	
	public List<VendaItens> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<VendaItens> produtos) {
		this.produtos = produtos;
	}
	
	
}
