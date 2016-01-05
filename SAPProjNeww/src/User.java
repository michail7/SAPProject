
public class User {

	private final static String REGEX = "[a-z0-9]";

	private String username;
	private String password;
	private String role;

	public User() {
		super();

	}

	public User(String username, String password) throws Exception {
		setUsername(username);
		setPassword(password);
	}

	public User(String username, String password, String role) throws Exception {
		setUsername(username);
		setPassword(password);
		setRole(role);
	}

	public void setUsername(String username) throws InvalidCreditentialsException {
		if (username.matches(REGEX)) {
			this.username = username;
		} else {
			throw new InvalidCreditentialsException("Invalid username!!!");
		}

	}

	public void setPassword(String password) throws Exception {
		if (password.matches(REGEX)) {
			this.password = AESencrp.encrypt(password);
		} else
			throw new InvalidCreditentialsException("Wrong password!!!");
	}

	public void setRole(String role) throws InvalidCreditentialsException {
		if (role.equals("ADMINISTRATOR") || role.equals("EMPLOYEE") || role.equals("CUSTOMER")) {
			this.role = role;
		} else {
			throw new InvalidCreditentialsException("Invalid role!!!");
		}
	}

	public String toString() {
		return username + "***" + password + "***" + role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
