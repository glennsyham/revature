package com.revature.services;

import java.util.List;

import com.revature.daos.ReimbursementTypeDAO;
import com.revature.daos.ReimbursementTypeHibernate;
import com.revature.exceptions.ReimbursementTypeNotFoundException;
import com.revature.models.ReimbursementType;

public class ReimbursementTypeService {
	ReimbursementTypeDAO rt = new ReimbursementTypeHibernate()  ;
	
	public ReimbursementType getReimbursementTypeById(int id) throws ReimbursementTypeNotFoundException {
		ReimbursementType type = rt.getReimbursementTypeById(id);
		return type;
	}
	
	public List<ReimbursementType> getReimbursementType() {
		return rt.getReimbursementType();
	} 
}

