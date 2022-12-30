package com.training.WebsiteEcommerce.model;

public class Customer {
	

	private int id;
	private String CustName;
	private String Phone;
	private String email;
	
	public Customer(int id, String custName, String phone, String email) {
		super();
		this.id = id;
		CustName = custName;
		Phone = phone;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustName() {
		return CustName;
	}

	public void setCustName(String custName) {
		CustName = custName;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Customer() {
		
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", CustName=" + CustName + ", Phone=" + Phone + ", email=" + email + "]";
	}

}
