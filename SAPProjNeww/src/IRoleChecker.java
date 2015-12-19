
public interface IRoleChecker {
	String isUserInRole(String username) throws InvalidCreditentialsException;
	public boolean isInRole(String username, String password);
}
