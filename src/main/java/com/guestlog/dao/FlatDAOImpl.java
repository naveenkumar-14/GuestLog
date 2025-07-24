package com.guestlog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.guestlog.connection.Connector;

public class FlatDAOImpl implements FlatDAO{
	private int count;
	private Connection con;
	PreparedStatement ps;
	public FlatDAOImpl() {
		this.con=Connector.getConnection();
	}
	@Override

	public int countFlats() {
	    int count = 0;
	    String query = "SELECT COUNT(*) FROM flats";
	    try {
	        ps = con.prepareStatement(query);
	        ResultSet rs = ps.executeQuery(); 
	        if (rs.next()) {
	            count = rs.getInt(1); 
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return count;
	}
	@Override
	public int toRent() {
		int count = 0;
	    String query = "SELECT COUNT(*) FROM flats where status='rent'";
	    try {
	        ps = con.prepareStatement(query);
	        ResultSet rs = ps.executeQuery(); 
	        if (rs.next()) {
	            count = rs.getInt(1); 
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return count;
	}
	@Override
	public int toSale() {
		int count = 0;
	    String query = "SELECT COUNT(*) FROM flats where status='sale'";
	    try {
	        ps = con.prepareStatement(query);
	        ResultSet rs = ps.executeQuery(); 
	        if (rs.next()) {
	            count = rs.getInt(1); 
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return count;
	}


}
