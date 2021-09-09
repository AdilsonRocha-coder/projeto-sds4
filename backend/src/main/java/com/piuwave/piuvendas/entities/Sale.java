package com.piuwave.piuvendas.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//abaixo com a annotation Entity nos faremos o
//mapeamento objeto relacional, mapearemos as tabelas
//do banco de dados h2 e o postgresql
@Entity
@Table(name = "tb_sales") //continuando com o mapemento
public class Sale {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //mapeando o sale_id
	private Long id;
	private Integer visited;
	private Integer deals;
	private Double amount;
	private LocalDate date;
	
	//abaixo dizemos que o Sale tem apenas
	//um Seller - (conforme o diagrama UML que diz
	//que um vendedor pode ter muitas vendas e 
	//uma venda pode ter apenas um vendedor
	
	@ManyToOne //mapeando a ligacao "muitos para um" entre as tabelas
	@JoinColumn(name = "seller_id")
	private Seller seller;
	
	public Sale() {
	}

	public Sale(Long id, Integer visited, Integer deals, Double amount, LocalDate date, Seller seller) {
		this.id = id;
		this.visited = visited;
		this.deals = deals;
		this.amount = amount;
		this.date = date;
		this.seller = seller;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVisited() {
		return visited;
	}

	public void setVisited(Integer visited) {
		this.visited = visited;
	}

	public Integer getDeals() {
		return deals;
	}

	public void setDeals(Integer deals) {
		this.deals = deals;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}
}
