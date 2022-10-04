package com.shopping.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "order_user")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private long orderId;

	@Column(name = "buy_date")
	private Date buyDate;

	@Column(name = "status")
	private String status;

	@Column(name = "price_total")
	private float priceTotal;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User buyer;

	@OneToMany(mappedBy = "order")
	private List<Item> items;

	public Order() {
		super();
	}

	public Order(long orderId, Date buyDate, String status, float priceTotal, User buyer, List<Item> items) {
		super();
		this.orderId = orderId;
		this.buyDate = buyDate;
		this.status = status;
		this.priceTotal = priceTotal;
		this.buyer = buyer;
		this.items = items;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public Date getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public float getPriceTotal() {
		return priceTotal;
	}

	public void setPriceTotal(float priceTotal) {
		this.priceTotal = priceTotal;
	}

	public User getBuyer() {
		return buyer;
	}

	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

}