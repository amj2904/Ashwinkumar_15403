package com.training.WebsiteEcommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.training.WebsiteEcommerce.model.Product;

import com.training.WebsiteEcommerce.dao.Dbconnection;

public class ProductDao implements IDao<Product> {
	
	private Dbconnection db;
	private static ProductDao productDao;
	
	private ProductDao() {
		super();	
	}

	public ProductDao(Dbconnection db) {
		super();
		this.db = db;
	}
	
	public static ProductDao getProductDao() {
		if(productDao==null) {
			synchronized (ProductDao.class) {
				if(productDao==null) {
					productDao=new ProductDao(Dbconnection.getDb());
				}
			}
		}
		return productDao;
	}


	public List<Product> findAll() throws SQLException {
		final List<Product> list=new ArrayList<Product>();
		Connection connect=db.getConnection();
		Statement statement=connect.createStatement();
		final String sql="select pid,pname,unitprice from Product";
		ResultSet resultSet=statement.executeQuery(sql);
		while(resultSet.next()) {
			list.add(new Product(resultSet.getInt(1),resultSet.getString(2),resultSet.getDouble(3)));			
		}
		return list;
	}

	public Product findOne(int id) throws SQLException {
		Connection connect=db.getConnection();
		Statement statement=connect.createStatement();
		final String sql="select pid,pname,unitprice from Product where pid="+id;
		ResultSet resultSet=statement.executeQuery(sql);
		if(resultSet.next()) {
			final Product product=new Product(resultSet.getInt(1),resultSet.getString(2),resultSet.getDouble(3));
			return product;
		}
		return null;
	}

	public boolean createNew(Product product) throws SQLException {
		Connection connect=db.getConnection();		
		final String sql="insert into Product values(?,?,?)";
		final PreparedStatement pStatement=connect.prepareStatement(sql);
		pStatement.setInt(1,product.getPid());
		pStatement.setString(2,product.getPname());
		pStatement.setDouble(3, product.getUnitprice());
		
		if(pStatement.executeUpdate()>0) {
			return true;
		}
		return false;
	}



	public boolean findOneAndDelete(int id) throws SQLException {
		final Connection connect=db.getConnection();
		final String sql="delete from Product where pid=?";
		final PreparedStatement pStatement=connect.prepareStatement(sql);
		pStatement.setInt(1, id);
		if(pStatement.executeUpdate()>0) {
			return true;
		}		
		return false;
	}

	public boolean findOneAndUpdate(int id, Product c) throws SQLException {
		{
			final Connection connect=db.getConnection();
			final String sql="update Product set pname=? where pid=?";
			final PreparedStatement pStatement=connect.prepareStatement(sql);
			pStatement.setString(1, c.getPname());
			pStatement.setInt(2,c.getPid());
			if(pStatement.executeUpdate()>0) {
				return true;
			}		
			return false;
		}
	}
}