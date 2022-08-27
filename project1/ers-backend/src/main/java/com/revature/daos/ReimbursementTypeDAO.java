package com.revature.daos;

import java.util.List;

import com.revature.models.ReimbursementType;

public interface ReimbursementTypeDAO {
	ReimbursementType getReimbursementTypeById(int id);
	ReimbursementType getByName(String reimb_type);
	List<ReimbursementType> getReimbursementType();
}
