package tecno.tecnoPro;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import domin.User;

@Path("userjersey")
public class UserJersey {
	

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUser() throws SQLException {
		
		User user1 = new User();
		user1.setName("abdalluh");
		user1.setEmail("abdalluh@gamil.com");
		user1.setAge(22);
		
		User user2 = new User();
		user2.setName("ahmad");
		user2.setEmail("ahmad@gamil.com");
		user2.setAge(24);
		
//		List<User> users = Arrays.asList(user1 , user2);
		List<User> users = new ArrayList<User>();
		
		users.add(user1);
		users.add(user2);
		
		return users;
	
	}
}




