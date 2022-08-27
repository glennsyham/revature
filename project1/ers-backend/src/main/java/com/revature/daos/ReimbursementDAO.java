/**
 * 
 */
package com.revature.daos;

import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.models.User;

 
 
public interface ReimbursementDAO {
	List<Reimbursement> getReimbursements();
	List<Reimbursement>  getByAuthor(User u);
	Reimbursement insertReimbursement(Reimbursement r);
	Reimbursement getByID(int id);
	boolean setStatusByID(int id,User approverUser, ReimbursementStatus status);
 
}
