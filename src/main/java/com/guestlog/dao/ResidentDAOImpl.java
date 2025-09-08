package com.guestlog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.guestlog.connection.Connector;
import com.guestlog.dto.Resident;

public class ResidentDAOImpl implements ResidentDAO{
	Connection con=null;
	public ResidentDAOImpl() {
		this.con=Connector.getConnection();
	}

	@Override
	public boolean insertResident(Resident res) {
		String query ="insert into residents values(Null,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, res.getFullName());
			ps.setString(2, res.getFlatNumber());
			ps.setString(3, res.getMobileNumber());
			ps.setString(4, res.getEmail());
			ps.setString(5, res.getGender());
			ps.setString(6, res.getResidentType());
			ps.setString(7, res.getMoveInDate());
			ps.setBoolean(8, res.isActive());
			if(ps.executeUpdate()>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<Resident> viewResidents() {

		String query="select * from residents";
		ArrayList<Resident> al=new ArrayList<Resident>();
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Resident r=new Resident();
				r.setResidentId(rs.getInt(1));
				r.setFullName(rs.getString(2));
				r.setFlatNumber(rs.getString(3));
				r.setMobileNumber(rs.getString(4));//mobile
				r.setEmail(rs.getString(5));//email
				r.setGender(rs.getString(6));//gender
				r.setResidentType(rs.getString(7));//resident type
				r.setMoveInDate(rs.getString(8));//movein date
				r.setActive(rs.getBoolean(9));//is active
				al.add(r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
	}

	@Override
	public Resident getResidentById(int id) {

		Resident r=null;
		String query="select * from residents where resident_id=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				r=new Resident();
				r.setResidentId(rs.getInt(1));
				r.setFullName(rs.getString(2));
				r.setFlatNumber(rs.getString(3));
				r.setMobileNumber(rs.getString(4));
				r.setEmail(rs.getString(5));
				r.setGender(rs.getString(6));
				r.setResidentType(rs.getString(7));
				r.setMoveInDate(rs.getString(8));
				r.setActive(rs.getBoolean(9));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}
	
	

	@Override
	public boolean updateResident(Resident r) {
		 try {
		        String query = "UPDATE residents SET fullName=?, flatNumber=?, mobileNumber=?, email=?, gender=?, residentType=?, moveInDate=?, isActive=? WHERE resident_id=?";
		        PreparedStatement ps = con.prepareStatement(query);
		        ps.setString(1, r.getFullName());
		        ps.setString(2, r.getFlatNumber());
		        ps.setString(3, r.getMobileNumber());
		        ps.setString(4, r.getEmail());
		        ps.setString(5, r.getGender());
		        ps.setString(6, r.getResidentType());
		        ps.setString(7, r.getMoveInDate());
		        ps.setBoolean(8, r.isActive());
		        ps.setInt(9, r.getResidentId());
		        return ps.executeUpdate() > 0;
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return false;
	}

	@Override
	public boolean deleteResidentById(int id) {
		String query="Delete from residents where resident_id=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, id);
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	
		
	}

}
