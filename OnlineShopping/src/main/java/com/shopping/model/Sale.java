package com.shopping.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "sale")
public class Sale {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
	@Column(name = "sale_id")
	private String saleId;
	@Column(name = "sale_percent")
	private int salePercent;
	@OneToMany(mappedBy = "sale")
	private List<Product> products;

	public Sale() {
		super();
	}

	public Sale(String saleId, int salePercent, List<Product> products) {
		super();
		this.saleId = saleId;
		this.salePercent = salePercent;
		this.products = products;
	}

	public String getSaleId() {
		return saleId;
	}

	public void setSaleId(String saleId) {
		this.saleId = saleId;
	}

	public int getSalePercent() {
		return salePercent;
	}

	public void setSalePercent(int salePercent) {
		this.salePercent = salePercent;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}