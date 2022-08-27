package com.revature.daos;

import org.hibernate.Session;

import com.revature.models.ReimbursementStatus;
import com.revature.util.HibernateUtil;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class ReimbursementStatusHibernate implements ReimbursementStatusDAO {

	@Override
	public ReimbursementStatus getReimbursementStatusById(int id) {
		// TODO Auto-generated method stub
		ReimbursementStatus status = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession();){
			status = s.get(ReimbursementStatus.class, id);
		}
		
		return status;
	}

	@Override
	public ReimbursementStatus getByName(String reimb_status) {
		// TODO Auto-generated method stub
		ReimbursementStatus status = null;
		try(Session s = HibernateUtil.getSessionFactory().openSession();){
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<ReimbursementStatus> cq = cb.createQuery(ReimbursementStatus.class);
			// define entity to be searched
			Root<ReimbursementStatus> root = cq.from(ReimbursementStatus.class);
			
			//define conditions
			Predicate predicateForReimbursementStatusname = cb.equal(root.get("reimb_status"), reimb_status);
 
			cq.select(root).where(predicateForReimbursementStatusname);
 			
			status = (ReimbursementStatus) s.createQuery(cq).getSingleResult();
		}	
		return status;
	}

}
