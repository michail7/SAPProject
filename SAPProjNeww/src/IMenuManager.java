import java.io.IOException;

public interface IMenuManager {
	public void menu() throws InvalidCreditentialsException, IOException, Exception;

	public void adminMenu() throws InvalidCreditentialsException, IOException, Exception;

	public void bookMenu() throws InvalidCreditentialsException, IOException, Exception;

	public void employeeMenu() throws InvalidCreditentialsException, IOException, Exception;

	public void employeesMenu() throws InvalidCreditentialsException, IOException, Exception;

	public void clientsMenu() throws InvalidCreditentialsException, IOException, Exception;
}
