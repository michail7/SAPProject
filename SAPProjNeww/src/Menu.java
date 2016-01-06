
import java.io.IOException;
import java.util.Scanner;

public class Menu implements IMenuManager {
	private Scanner input = new Scanner(System.in);

	public void menu() throws Exception {
		System.out.println("Enter username");
		String username = input.nextLine();
		System.out.println("Enter password");
		String password = input.nextLine();

		IRoleChecker roleCheck = new RoleChecker();
		try {
			if ((roleCheck.isInRole(username, password) == true)
					&& roleCheck.isUserInRole(username).equals("ADMINISTRATOR")) {
				adminMenu();
			} else if (roleCheck.isInRole(username, password) && roleCheck.isUserInRole(username).equals("EMPLOYEE")) {
				employeesMenu();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void adminMenu() throws Exception {
		int choice;
		System.out.println("1. Books");
		System.out.println("2. Employees");
		System.out.println("3. Exit");
		choice = input.nextInt();

		do {
			switch (choice) {
			case 1:
				bookMenu();
				break;
			case 2:
				employeeMenu();
				break;
			case 3:
				break;
			default:
				System.out.println("Press a key 1 - 3");
			}

		} while (choice != 3);
		Runtime.getRuntime().exec("cls");
		menu();
	}

	public void bookMenu() throws Exception {
		int choice;
		IBookManager bookManager = new BookManager();
		System.out.println("1. Create book");
		System.out.println("2. Read book");
		System.out.println("3. Update book");
		System.out.println("4. Delete book");
		System.out.println("5. Back");
		choice = input.nextInt();
		do {
			switch (choice) {
			case 1:
				System.out.println("Enter title");
				String title = input.nextLine();
				System.out.println("Enter author");
				String author = input.nextLine();
				System.out.println("Enter genre");
				String genre = input.nextLine();
				System.out.println("Enter number of pages");
				int pages = input.nextInt();
				System.out.println("Enter year");
				String year = input.nextLine();
				System.out.println("Enter ISBN");
				String ISBN = input.nextLine();
				bookManager.addBook(new Book(title, author, genre, pages, year, ISBN));
				System.out.println("Done");
				Runtime.getRuntime().exec("cls");
				bookMenu();
				break;
			case 2:
				System.out.println("Enter title");
				String bookTitle = input.nextLine();
				bookManager.readBook();
				System.out.printf("%s", bookTitle);
				Runtime.getRuntime().exec("cls");
				bookMenu();
				break;
			case 3:
				System.out.println("Enter the title of the book");
				String btitle = input.nextLine();
				System.out.println("Enter new title. author, genre, pages, year and ISBN separatet with intervals ");
				String book = input.nextLine();
				String[] split = book.split("[ ]");
				Book b1 = null;
				for (int i = 0; i < split.length; i++) {
					b1 = new Book(split[i], split[i + 1], split[i + 2], Integer.parseInt(split[i + 3]), split[i + 4],
							split[i + 5]);
				}
				bookManager.updateBook(btitle, b1);
				System.out.println("Done!");
				Runtime.getRuntime().exec("cls");
				bookMenu();
				break;
			case 4:
				System.out.println("Enter title");
				String _title = input.nextLine();
				bookManager.deleteBook(_title);
				System.out.println("Done!");
				Runtime.getRuntime().exec("cls");
				bookMenu();
				break;
			case 5:
				adminMenu();
				break;
			}
		} while (true);
	}

	@Override
	public void employeeMenu() throws Exception {
		int choice;
		IEmployeeManager empManager = new EmployeeManager();
		System.out.println("1. Create employee");
		System.out.println("2. Read employee");
		System.out.println("3. Update employee");
		System.out.println("4. Delete employee");
		System.out.println(" 5. Back");
		choice = input.nextInt();
		do {
			switch (choice) {
			case 1:
				System.out.println("Enter username and password");
				String creditentials = input.nextLine();
				String[] splitter = creditentials.split("[ ]");
				@SuppressWarnings("unused")
				User emp = null;
				for (int i = 0; i < splitter.length; i++) {
					emp = new User(splitter[i], splitter[i + 1]);
				}
				System.out.println("Done!");
				Runtime.getRuntime().exec("cls");
				employeeMenu();
				break;
			case 2:
				int ch;
				empManager.getEmployee(EmployeeManager.employeePath);
				System.out.println("1. Go back");
				ch = input.nextInt();
				if (ch == 1) {
					Runtime.getRuntime().exec("cls");
					employeeMenu();
				}
				break;
			case 3:
				System.out.println("Enter username");
				String uName = input.nextLine();
				System.out.println("Enter username and password to update");
				String[] userNPass = input.nextLine().split("[ ]");
				User u1 = null;
				for (int i = 0; i < userNPass.length; i++) {
					u1 = new User(userNPass[i].trim(), userNPass[i + 1].trim());
				}
				empManager.updateEmployee(uName, u1);
				System.out.println("Done!");
				Runtime.getRuntime().exec("cls");
				employeeMenu();
				break;
			case 4:
				System.out.println("Enter username");
				String _username = input.nextLine();
				// EmployeeChecker emplC = new EmployeeChecker();
				// emplC.deleteEmpl(_username);
				empManager.deleteEmployee(_username);
				Runtime.getRuntime().exec("cls");
				employeeMenu();
				break;
			}
		} while (choice != 5);
	}

	@Override
	public void employeesMenu() throws InvalidCreditentialsException, IOException, Exception {
		System.out.println("1. Books");
		System.out.println("2. Client");
		System.out.println("3. Exit");
		int choice = input.nextInt();
		do {
			switch (choice) {
			case 1:
				IBookManager bookManager = new BookManager();
				bookManager.readBook();
				System.out.println("Enter title");
				String title = input.nextLine();
				bookManager.getBook(title);
				Runtime.getRuntime().exec("cls");
				System.out.println("Done!");
				Runtime.getRuntime().exec("cls");
				employeesMenu();
				break;
			case 2:
				clientsMenu();
				break;
			case 3:
				break;
			}
		} while (!(choice == 3));
	}

	@Override
	public void clientsMenu() throws InvalidCreditentialsException, IOException, Exception {
		IClientsManager clManager = new ClientManager();
		System.out.println("1. Add client");
		System.out.println("2. List of clients");
		System.out.println("3. Update client");
		System.out.println("4. Delete client");
		System.out.println("5. Exit");
		int choice = input.nextInt();
		do {
			switch (choice) {
			case 1:
				System.out.println("Enter username");
				String uName = input.nextLine();
				clManager.addClient(uName);
				System.out.println("Done!");
				Runtime.getRuntime().exec("cls");
				clientsMenu();
				break;
			case 2:
				clManager.readClients();
				System.out.println("Done");
				Runtime.getRuntime().exec("cls");
				clientsMenu();
				break;
			case 3:
				System.out.println("Enter username");
				String _1name = input.nextLine();
				System.out.println("Enter new username");
				String _2name = input.nextLine();
				clManager.updateClient(_1name, _2name);
				Runtime.getRuntime().exec("cls");
				System.out.println("Done!");
				clientsMenu();
				break;
			case 4:
				System.out.println("Enter username");
				String username = input.nextLine();
				clManager.deleteClient(username);
				Runtime.getRuntime().exec("cls");
				System.out.println("Done!");
				clientsMenu();
				break;
			}
		} while (choice != 5);
		Runtime.getRuntime().exec("cls");
		employeesMenu();
	}
}
