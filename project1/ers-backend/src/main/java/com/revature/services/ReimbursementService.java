package com.revature.services;

import java.util.List;

import com.revature.daos.ReimbursementDAO;
import com.revature.daos.ReimbursementHibernate;
import com.revature.daos.ReimbursementStatusDAO;
import com.revature.daos.ReimbursementStatusHibernate;
import com.revature.daos.UserDAO;
import com.revature.daos.UserHibernate;
import com.revature.exceptions.ReimbursementNotCreatedException;
import com.revature.exceptions.ReimbursementNotFoundException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.models.User;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReimbursementService {
	private ReimbursementDAO rd = new ReimbursementHibernate();
	private ReimbursementStatusDAO rsh = new ReimbursementStatusHibernate();
	private UserDAO ud = new UserHibernate();
	private static Logger log = LogManager.getLogger(ReimbursementService.class);

	public List<Reimbursement> getReimburse() {
		List<Reimbursement> reimburse = rd.getReimbursements();
		return reimburse;
	}
	
	public List<Reimbursement>  getByAuthor(User u) throws ReimbursementNotFoundException {
		List<Reimbursement> reimburse = rd.getByAuthor(u);
		return reimburse;
	}
	
	public Reimbursement insertReimbursement(Reimbursement r) throws ReimbursementNotCreatedException {
		Reimbursement reimburse =  rd.insertReimbursement(r);
		return reimburse;
	}
	
	public Reimbursement getByID(int id) throws ReimbursementNotFoundException {
		log.info(id);
		Reimbursement reimburse =  rd.getByID(id);
		if (reimburse == null) {
			throw new ReimbursementNotFoundException();
		}		
		return reimburse;
	}
	
	public boolean setStatusByID(int id, int user_id, String status_txt) throws ReimbursementNotUpdatedException {
		ReimbursementStatus rs = rsh.getByName(status_txt);
		User user = ud.getUserById(user_id);
		 boolean checkUpdate = rd.setStatusByID(id, user, rs);
		if (checkUpdate == false) {
			throw new ReimbursementNotUpdatedException();
		}		 
		return checkUpdate;
	}
}
