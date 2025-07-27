package com.guestlog.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.guestlog.connection.Connector;
import com.guestlog.dto.Admin;

public class AdminDAOImpl implements AdminDAO{

	private Connection con;
	public AdminDAOImpl() {
		this.con=Connector.getConnection();
	}
	@Override
	public boolean insertAdmin(Admin a) {
	    String query = "insert into admin values(0, ?, ?, ?, ?, ?)";
	    try {
	        PreparedStatement ps = con.prepareStatement(query);
	        ps.setString(1, a.getFullName());
	        ps.setString(2, a.getUsername());
	        ps.setString(3, a.getPassword());
	        ps.setString(4, a.getEmail());
	        ps.setString(5, a.getRole());

	        if (ps.executeUpdate() > 0) {
	            return true;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace(); 
	    }
	    return false;
	}

	@Override
	public Admin getAdmin(String username, String password) {
		Admin a=null;
		String query="select * from admin where username=? and password=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				a=new Admin();
				a.setAdminId(Integer.parseInt(rs.getString(1)));
				a.setFullName(rs.getString(2));
				a.setUsername(rs.getString(3));
				a.setPassword(rs.getString(4));
				a.setEmail(rs.getString(5));
				a.setRole(rs.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	@Override
	public ArrayList<Admin> getAdmins() {
		String query="select * from admin where admin_id!=1";
		ArrayList<Admin> al=new ArrayList<Admin>();
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Admin a=new Admin();
				a.setAdminId(rs.getInt(1));
				a.setFullName(rs.getString(2));
				a.setUsername(rs.getString(3));
				a.setPassword(rs.getString(4));
				a.setEmail(rs.getString(5));
				a.setRole(rs.getString(6));
				al.add(a);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
	}
	

}
