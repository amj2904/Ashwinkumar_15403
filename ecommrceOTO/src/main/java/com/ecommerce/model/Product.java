package com.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pid;
	 private String pName;
	 private Double unitPrice;


	 public Product(int pid, String pName, Double unitPrice) {
		super();
		this.pid = pid;
		this.pName = pName;
		this.unitPrice = unitPrice;
	}


	private Product() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getPid() {
		return pid;
	}


	public void setPid(int pid) {
		this.pid = pid;
	}


	public String getpName() {
		return pName;
	}


	public void setpName(String pName) {
		this.pName = pName;
	}


	public Double getUnitPrice() {
		return unitPrice;
	}


	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}


	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pName=" + pName + ", unitPrice=" + unitPrice + "]";
	}


	


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (pid != other.pid)
			return false;
		return true;
	}
	
}