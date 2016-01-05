
public interface IClientsManager {
	public void addClient(String username);

	public void readClients();

	public void updateClient(String username, String newUsername);

	public void deleteClient(String username);
}
