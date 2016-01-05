
public interface IRoleChecker {
	String isUserInRole(String username) throws InvalidCreditentialsException;

	boolean isInRole(String username, String password);
}
