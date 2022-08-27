package com.revature.services;

import com.revature.daos.ReimbursementStatusDAO;
import com.revature.daos.ReimbursementStatusHibernate;
import com.revature.exceptions.ReimbursementStatusNotFoundException;
import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;

public class ReimbursementStatusService {
	ReimbursementStatusDAO rh = new ReimbursementStatusHibernate();
	public ReimbursementStatus getReimbursementStatusById(int id) throws ReimbursementStatusNotFoundException { 
		ReimbursementStatus status = rh.getReimbursementStatusById(id);
		return status;
	}
}
