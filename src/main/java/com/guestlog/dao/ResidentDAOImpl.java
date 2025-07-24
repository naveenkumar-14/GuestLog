package com.guestlog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

}
