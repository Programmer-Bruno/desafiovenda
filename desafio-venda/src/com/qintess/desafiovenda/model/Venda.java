package com.qintess.desafiovenda.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Venda {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int cliente_id;
	private int desconto;
	private int forma_pagamento;
	private Date data;
	@OneToMany(mappedBy = "venda")
	List<VendaItens> itens = new ArrayList<VendaItens>();
	
	
		
	
	public Venda() {}
	public Venda(int cliente_id, int desconto, String forma_pagamento) {
		this.cliente_id = cliente_id;
		this.desconto = desconto;
		if (forma_pagamento.equals("CD")) {this.forma_pagamento = 1;}
		if (forma_pagamento.equals("CC")) {this.forma_pagamento = 2;}
		if (forma_pagamento.equals("BO")) {this.forma_pagamento = 3;}
		LocalDate vData = LocalDate.now();
		this.data = Date.valueOf(vData);
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCliente_id() {
		return cliente_id;
	}
	public void setCliente_id(int cliente_id) {
		this.cliente_id = cliente_id;
	}
	public double getDesconto() {
		return desconto;
	}
	public void setDesconto(int desconto) {
		this.desconto = desconto;
	}
	public int getForma_pagamento() {
		return forma_pagamento;
	}
	public void setForma_pagamento(int forma_pagamento) {
		this.forma_pagamento = forma_pagamento;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public List<VendaItens> getItens() {
		return itens;
	}
	public void setItens(List<VendaItens> itens) {
		this.itens = itens;
	}
	public void setItem(VendaItens item) {
		this.itens.add(item);
	}
	
	
}
