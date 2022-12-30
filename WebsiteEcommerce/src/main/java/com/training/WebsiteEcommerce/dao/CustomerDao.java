package com.training.WebsiteEcommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.training.WebsiteEcommerce.model.Customer;

import com.training.WebsiteEcommerce.dao.Dbconnection;

public class CustomerDao implements IDao<Customer> {
	
	private Dbconnection db;
	private static CustomerDao customerDao;
	
	private CustomerDao() {
		super();	
	}

	public CustomerDao(Dbconnection db) {
		super();
		this.db = db;
	}
	
	public static CustomerDao getCustomerDao() {
		if(customerDao==null) {
			synchronized (CustomerDao.class) {
				if(customerDao==null) {
					customerDao=new CustomerDao(Dbconnection.getDb());
				}
			}
		}
		return customerDao;
	}


	public List<Customer> findAll() throws SQLException {
		final List<Customer> list=new ArrayList<Customer>();
		Connection connect=db.getConnection();
		Statement statement=connect.createStatement();
		final String sql="select id,custName,phone,email from customer";
		ResultSet resultSet=statement.executeQuery(sql);
		while(resultSet.next()) {
			list.add(new Customer(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4)));			
		}
		return list;
	}

	public Customer findOne(int id) throws SQLException {
		Connection connect=db.getConnection();
		Statement statement=connect.createStatement();
		final String sql="select id,custname,phone,email from customer where id="+id;
		ResultSet resultSet=statement.executeQuery(sql);
		if(resultSet.next()) {
			final Customer customer=new Customer(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4));
			return customer;
		}
		return null;
	}

	public boolean createNew(Customer customer) throws SQLException {
		Connection connect=db.getConnection();		
		final String sql="insert into customer values(?,?,?,?)";
		final PreparedStatement pStatement=connect.prepareStatement(sql);
		pStatement.setInt(1,customer.getId());
		pStatement.setString(2,customer.getCustName());
		pStatement.setString(3, customer.getEmail());
		pStatement.setString(4, customer.getPhone());
		if(pStatement.executeUpdate()>0) {
			return true;
		}
		return false;
	}



	public boolean findOneAndDelete(int id) throws SQLException {
		final Connection connect=db.getConnection();
		final String sql="delete from customer where id=?";
		final PreparedStatement pStatement=connect.prepareStatement(sql);
		pStatement.setInt(1, id);
		if(pStatement.executeUpdate()>0) {
			return true;
		}		
		return false;
	}

	public boolean findOneAndUpdate(int id, Customer c) throws SQLException {
		{
			final Connection connect=db.getConnection();
			final String sql="update customer set custname=? where id=?";
			final PreparedStatement pStatement=connect.prepareStatement(sql);
			pStatement.setString(1, c.getCustName());
			pStatement.setInt(2, c.getId());
			if(pStatement.executeUpdate()>0) {
				return true;
			}		
			return false;
		}
	}
}