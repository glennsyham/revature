package com.revature;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HashirasBackApplication {
	@Autowired
	public static void main(String[] args) {
		SpringApplication.run(HashirasBackApplication.class, args);
	}

}
//@Component
//class AppStartupRunner implements ApplicationRunner {
//
//	@Autowired
//	private AnimeListService as;
//	@Autowired
//	private UserService us;
//	@Autowired
//	private UserRepository ur;
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//    	us.updateInfo("charles", "galbert","galbert@galbert.com", 1);
//    	us.updatePassword("12345", 1);
//
//		List<AnimeList> al = as.getAnimeList();
//		System.out.println(al.toString());
//    	User user = new User();
//  	
//    	user = us.getUserById(1);
//     	AnimeList animeList = new AnimeList();
//    	animeList.setAnimeId(20);
//    	animeList.setUser(user);
//    	animeList.setStatus(ListStatus.CURRENTLY);
//    	as.addAnimeList(animeList);
//    	
//    	user = us.getUserById(1);
//    	AnimeList animeList = as.findAnimeListByUserAndAnimeId(user, 16099);
//    	System.out.println(animeList.getAnimeId());
//    	List<User> users = us.getUsers();
//    	System.out.println(users.toString());
//    	user.setUsername("charles");;
//    	user.setEmail("charles@charles.com");
//    	user.setPassword("12345");
//    	user.setFname("charles");
//    	user.setLname("albert");
//    	user.setStatus(1);
//    	us.addUser(user);
//    	User principal = ur.findUserByUsername("LaneM123");
//    	
//    	System.out.println(principal);

//    	long lg = as.deleteAnimeListById(20);
//    	System.out.println(lg);
//    }
//}
