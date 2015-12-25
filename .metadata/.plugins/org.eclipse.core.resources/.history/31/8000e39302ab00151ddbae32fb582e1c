
public class RoleChecker extends FileManager implements IRoleChecker{
	private final static String usersPath = "users.txt";
	
	@Override
	public boolean isInRole(String username, String password) {
		String allData = readFile(usersPath);
		String[] splitter = allData.split("[*\n]+");
		for(int i = 0; i < splitter.length; i++){
			if(splitter[i].equals(username) && splitter[i+1].equals(password)){
				return true;
			}
		}
		return false;
	}


	@Override
	public String isUserInRole(String username)
			throws InvalidCreditentialsException {
		String allData = readFile(usersPath);
		String[] splitter = allData.split("[*\n]");
		for(int i = 0; i < splitter.length; i++){
			if(splitter[i].equals(username)){
				return splitter[3];
			}
		}
		return null;
	}
	
}
