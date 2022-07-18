import com.revature.daos.UserDAO;
import com.revature.daos.UserHibernate;
import com.revature.models.User;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDAO uh = new UserHibernate();
		User u = uh.getUserByUsername("manager1");
		System.out.println(u.toString());
	}

}
