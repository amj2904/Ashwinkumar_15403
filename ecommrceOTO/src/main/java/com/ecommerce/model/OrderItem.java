package com.ecommerce.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class OrderItem {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private int itemId;
	    @OneToOne(cascade = CascadeType.ALL)
	    private Product product;
	    private int quantity;
		
	    private OrderItem() {
			super();
			
		}

		public OrderItem(Product product, int quantity) {
			super();
			this.product = product;
			this.quantity = quantity;
		}

		private OrderItem(int itemId, Product product, int quantity) {
			super();
			this.itemId = itemId;
			this.product = product;
			this.quantity = quantity;
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
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + itemId;
			return result;
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