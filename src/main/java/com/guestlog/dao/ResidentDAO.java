package com.guestlog.dao;

import java.util.ArrayList;

import com.guestlog.dto.Resident;

public interface ResidentDAO {
	public boolean insertResident(Resident res);
	public ArrayList<Resident> viewResidents();
}
