package com.pmt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.pmt.database.DatabaseConnection;
import com.pmt.model.ProductionOrderModel;
import com.pmt.util.Common;



public class ProductionOrderUpdateDeleteDao {
	ProductionOrderModel  product = null;
	
	public ProductionOrderUpdateDeleteDao(ProductionOrderModel product )
	{
		this.product = product;
	}
	
	public int excute() throws SQLException
	{
		int result = 0;
		
		DatabaseConnection conn = new DatabaseConnection();
		Connection connectString = conn.getConnection();
		PreparedStatement sqlStatement = connectString.prepareStatement(getSQL());
		System.out.println(getSQL());
		result = sqlStatement.executeUpdate();
		
		return result;
	}
	
	public String getSQL()
	{
		StringBuilder sql = new StringBuilder();
		
		sql.append(" UPDATE ");
		sql.append(" PRODUCTION_ORDER ");
		sql.append(" SET ");
		sql.append(" 	 DELETE_FG ='1' ");
		sql.append(" WHERE ");
		sql.append(" 	 ORDER_CD=").append("'"+product.getOrderCd()+"'");
		
		
		return sql.toString();
	}
}
