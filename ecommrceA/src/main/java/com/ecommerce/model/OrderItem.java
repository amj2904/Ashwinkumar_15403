package com.ecommerce.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.criteria.Order;

@Entity
public class OrderItem {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private int itemId;
	 	@OneToOne(cascade = CascadeType.ALL)
	    private Product product;
	 	private int quantity;
	   // private double total;
	    @ManyToOne(cascade = CascadeType.ALL)
	    private Orders orders;
		
	   

		public OrderItem() {
			super();
			
		}

		
		 public OrderItem(Product product, int quantity, Orders orders) {
			super();
			this.product = product;
			this.quantity = quantity;
			//this.total = total;
			this.orders = orders;
		}


		private OrderItem(int itemId, Product product, int quantity, Orders orders) {
				super();
				this.itemId = itemId;
				this.product = product;
				this.quantity = quantity;
				//this.total = total;
				this.orders = orders;
			}
		

	


		public Orders getOrders() {
			return orders;
		}

		public void setOrders(Orders orders) {
			this.orders = orders;
		}

		
		

		public int getItemId() {
			return itemId;
		}

		public void setItemId(int itemId) {
			this.itemId = itemId;
		}

		public Product getProduct() {
			return product;
		}

		public void setProduct(Product product) {
			this.product = product;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		
		
		

		@Override
		public String toString() {
			return "OrderItem [itemId=" + itemId + ", product=" + product + ", quantity=" + quantity + "]";
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			OrderItem other = (OrderItem) obj;
			if (itemId != other.itemId)
				return false;
			return true;
		}
	    

	 
}