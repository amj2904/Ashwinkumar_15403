package com.training.WebsiteEcommerce.model;

public class Product {
	private int pid;
	private String pname;
	private double unitprice;
	

	public Product(int pid, String pname, double unitprice) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.unitprice = unitprice;
	}


	


	public int getPid() {
		return pid;
	}


	public void setPid(int pid) {
		this.pid = pid;
	}


	public String getPname() {
		return pname;
	}


	public void setPname(String pname) {
		this.pname = pname;
	}


	public double getUnitprice() {
		return unitprice;
	}


	public void setUnitprice(double unitprice) {
		this.unitprice = unitprice;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", unitprice=" + unitprice + "]";
	}
	
}