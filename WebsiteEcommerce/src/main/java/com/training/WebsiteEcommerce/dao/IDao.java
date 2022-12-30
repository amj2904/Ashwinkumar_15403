package com.training.WebsiteEcommerce.dao;
import java.util.List;

import java.sql.SQLException;


public interface IDao <T> {

	abstract List<T> findAll() throws SQLException;
	T findOne(int id) throws SQLException;
	boolean createNew(T t) throws SQLException;
	boolean findOneAndDelete(int id) throws SQLException;
	boolean findOneAndUpdate(int id,T t) throws SQLException;
}
