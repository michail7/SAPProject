import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class User{
	
//	private final static String REGEX = "[a-z0-9]";
	
//	private static enum Role{
//		ADMINISTRATOR, EMPLOYEE
//	}
	
	private String username;
	private String password;
	private String role;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String username, String password) throws Exception{
		setUsername(username);
		setPassword(password);
	}
	
	public User(String username, String password, String role) throws Exception{
		setUsername(username);
		setPassword(password);
		setRole(role);
	}

	public void setUsername(String username) throws InvalidCreditentialsException {
//		if(username.matches(REGEX)){
			this.username = username;
	//	} else{
		//	throw new InvalidCreditentialsException("Invalid username!!!");
		//}
		
	}

	public void setPassword(String password) throws Exception {
//		if(password.matches(REGEX)){
			this.password = AESencrp.encrypt(password);
//		}
//		else throw new InvalidCreditentialsException("Wrong password!!!");
	}

	public void setRole(String role) throws InvalidCreditentialsException {
//		if(role.equals(Role.ADMINISTRATOR) || role.equals(Role.EMPLOYEE) || role.equals(Role.CUSTOMER)){
			this.role = role;
//		} else{
//			throw new InvalidCreditentialsException("Invalid role!!!");
//		}
	}


	public String toString(){
		return username + "***" + password + "***" + role;
	}

	
}
