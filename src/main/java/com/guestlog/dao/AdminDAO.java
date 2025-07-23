package com.guestlog.dao;

import com.guestlog.dto.Admin;

public interface AdminDAO {
	public boolean insertAdmin(Admin a);
	public Admin getAdmin(String username,String password);
}
