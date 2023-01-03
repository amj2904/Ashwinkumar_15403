package com.ecommerce.model;




import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Orders {
	@Id
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;
	private Date orderDate;

	@OneToOne(cascade = CascadeType.ALL)
	private Customer customer;
	@OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)	
	private List<OrderItem> orderItem = new ArrayList<OrderItem>();
	private Orders(int orderId, Date orderDate, Customer customer, List<OrderItem> orderItem) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.customer = customer;
		this.orderItem = orderItem;
	}

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders (Date ts , Customer customer2) {
		this.orderDate=(Date)ts;
		this.customer=customer2;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderItem> getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(List<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}
	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", orderDate=" + orderDate + ", customer=" + customer + ", orderItem="
				+ orderItem + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		if (orderItem == null) {
			if (other.orderItem != null)
				return false;
		} else if (!orderItem.equals(other.orderItem))
			return false;
		return true;
	}

	

	
	
	
}
