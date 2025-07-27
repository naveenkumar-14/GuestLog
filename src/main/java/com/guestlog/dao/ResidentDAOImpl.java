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
		String query ="insert into residents values(?,?,?,?,?,?,?,?)";
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

}
