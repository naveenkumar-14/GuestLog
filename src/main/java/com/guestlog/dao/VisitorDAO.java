package com.guestlog.dao;

import java.util.ArrayList;

import com.guestlog.dto.Visitor;

public interface VisitorDAO {
	public boolean insertVisitor(Visitor v);
	public boolean updateVisitor(Visitor v);
	public ArrayList<Visitor> getVisitors();
	public Visitor getVisitor(int vid);
}
