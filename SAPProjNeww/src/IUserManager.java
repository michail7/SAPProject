
public interface IUserManager {
	
	boolean loginUser(String name, String password);
	void readUser(String username);
	void registerUser(String name, String password, String role) throws Exception;
	void deleteUser(String name, String password);
	void updateUser(String name, String password, String newUsername, String newPassword, String role);
}
