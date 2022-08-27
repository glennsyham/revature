import java.util.List;

import com.revature.exceptions.ReimbursementNotFoundException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.services.ReimbursementService;
import com.revature.services.UserService;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
 
public class Driver {
 
	/**
	 * @param args
	 */
	private static Logger log = LogManager.getLogger(Driver.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ReimbursementService rs = new ReimbursementService();
//		List<Reimbursement> reim = rs.getReimburse();
		UserService us = new UserService();
		
//		List<User> users = us.getUsers(); 
//		AuthService as = new AuthService();
//		try {
//			User principal = as.login("mike", "12345");
//			System.out.println(principal);
//
//		} catch (UserNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (LoginException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		List<Reimbursement> reimburse = rs.getReimburse(); 
//		System.out.println(reimburse);

//		try {
//			User u = us.getUserById(12);
//			List<Reimbursement> reimburse = rs.getByAuthor(u);
			
//			users.forEach(u -> usersDTO.add(new UserDTO(u)));

//			System.out.println(reimburse);
//		} catch (ReimbursementNotFoundException | UserNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        String regex = "[0-9]/[\breim]";
//
//		String patString = "23/task";
//         Pattern pattern = Pattern.compile(regex);
//         Matcher matcher = pattern.matcher(patString);
//         if(matcher.find()) {
//            System.out.println("Match occurred");
//         } else {
//            System.out.println("Match not occurred");
//         }         
//		UserDAO uh = new UserHibernate();
//
//		User u = new User();
//		u.setId(1);
//		u.setFirst_name("firstname");
//		u.setLast_name("lastname");
//		u.setEmail("miketest@rrrr.om");
//		uh.updatetUser(u) ;
//		ReimbursementTypeDAO rthDao = new ReimbursementTypeHibernate();
//		ReimbursementType rt = rthDao.getByName("lodging");
//		System.out.println(rt);
		
//		RoleDAO rh = new RoleHibernate();
//		Role r = rh.getByName("employee");
//		System.out.println(r);
		
//		
//		List<User> users = us.getByRole("employee");
//		System.out.println(users);
//		ReimbursementStatusDAO rsh = new ReimbursementStatusHibernate();
//		ReimbursementStatus rs = rsh.getByName("approved");
//		System.out.println(rs);
		
 
		
//		try {
//			rs.setStatusByID(2,32,"approved") ;
//		} catch (ReimbursementNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		User u = new User();
		try {
			u = us.getUserById(1);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(u);
//		log.warn("fdsfsddfdsfs");
//		log.info("info");
 	}

}
