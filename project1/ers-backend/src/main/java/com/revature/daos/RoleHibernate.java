package com.revature.daos;

import org.hibernate.Session;

import com.revature.models.Role;
import com.revature.util.HibernateUtil;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class RoleHibernate implements RoleDAO{

	@Override
	public Role getByName(String user_role) {
		// TODO Auto-generated method stub
		Role role = null;
		try(Session s = HibernateUtil.getSessionFactory().openSession();){
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Role> cq = cb.createQuery(Role.class);
			// define entity to be searched
			Root<Role> root = cq.from(Role.class);
			
			//define conditions
			Predicate predicateForRolename = cb.equal(root.get("user_role"), user_role);
 
			cq.select(root).where(predicateForRolename);
 			
			role = (Role) s.createQuery(cq).getSingleResult();
		}	
		return role;
	}

}
