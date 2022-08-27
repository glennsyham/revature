package com.revature.daos;

import java.util.List;

import org.hibernate.Session;

import com.revature.models.ReimbursementType;
import com.revature.util.HibernateUtil;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class ReimbursementTypeHibernate implements ReimbursementTypeDAO{

	@Override
	public ReimbursementType getReimbursementTypeById(int id) {
		// TODO Auto-generated method stub
		ReimbursementType type = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession();){
			type = s.get(ReimbursementType.class, id);
		}
		
		return type;
	}

	@Override
	public ReimbursementType getByName(String reimb_type) {
		// TODO Auto-generated method stub
		ReimbursementType type = null;
		try(Session s = HibernateUtil.getSessionFactory().openSession();){
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<ReimbursementType> cq = cb.createQuery(ReimbursementType.class);
			// define entity to be searched
			Root<ReimbursementType> root = cq.from(ReimbursementType.class);
			
			//define conditions
			Predicate predicateForReimbursementTypename = cb.equal(root.get("reimb_type"), reimb_type);
 
			cq.select(root).where(predicateForReimbursementTypename);
 			
			type = (ReimbursementType) s.createQuery(cq).getSingleResult();
		}	
		return type;
	}

	@Override
	public List<ReimbursementType> getReimbursementType() {
		// TODO Auto-generated method stub
		List<ReimbursementType> reimburseType = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			reimburseType = s.createQuery("from ReimbursementType Order by id ASC", ReimbursementType.class).list();
 		}
		
		return reimburseType;
	}

}
