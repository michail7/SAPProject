import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
class CheckClient extends ClientManager{
	private String username;
	private String newUsername;
	public CheckClient(){
		
	}
	public CheckClient(String username){
		this.username = username;
	}
	public CheckClient(String username, String newUsername){
		this.username = username;
		this.newUsername = newUsername;
	}
	void addCl(String username){
		addClient(username);
	}
	void readCls(){
		readClients();
	}
	void updateCl(String username, String newUsername){
		updateClient(username, newUsername);
	}
	void deleteCl(String username){
		deleteClient(username);
	}
}

class CheckBook extends BookManager{
	String title;
	String author;
	String genre;
	int pages;
	String year;
	String isbn;
	public CheckBook(){
		
	}
	public CheckBook(String title, String author, String genre, int pages, String year, String isbn){
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.pages = pages;
		this.year = year;
		this.isbn = isbn;
	}
	public void createBook(){
		try {
			addBook(new Book(title, author, genre, pages, year, isbn));
		} catch (BookNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void readBook(String title){
		try{
			getBook(title);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void update(String title, Book b1){
		try{
			updateBook(title, b1);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void delete(String title){
		try{
			deleteBook(title);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public String toString(){
		return title;
	}
}
class EmployeeChecker extends EmployeeManager{
	private User employee;
	
	public EmployeeChecker(){
	}
	
	public EmployeeChecker(User employee){
		this.employee = employee;
	}
	void addEmpl(User employee){
		addEmployee(employee);
	} 
	void getEmpl(String username){
		getEmployee(username);
	}
	void updateEmpl(String username, User employee){
		updateEmployee(username, employee);
	}
	void deleteEmpl(String username){
		deleteEmployee(username);
	}
}

public class Menu implements IMenuManager{
	private Scanner input = new Scanner(System.in);
	

	public void menu() throws Exception{
		System.out.println("Enter username");
		String username = input.nextLine();
		System.out.println("Enter password");
		String password = input.nextLine();
		
		class CheckRoles extends RoleChecker{
			private String username;
			private String password;
			
			public CheckRoles(String username, String password){
				this.username = username;
				this.password = password;
			}
			
			void Checker(){
				try {
					if((isInRole(username, password) == true) && isUserInRole(username).equals("ADMINISTRATOR")){
						try {
							adminMenu();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}else if(isInRole(username, password) && isUserInRole(username).equals("EMPLOYEE")){
						try {
							employeesMenu();
						} catch (InvalidCreditentialsException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				} catch (InvalidCreditentialsException e) {
					e.printStackTrace();
				}
			}
			
		}
		CheckRoles p = new CheckRoles(username, password);
		p.Checker();
	}
	
	
	public void adminMenu() throws Exception{
		int choice;
		System.out.println("1. Books");
		System.out.println("2. Employees");
		System.out.println("3. Exit");
		choice = input.nextInt();
		
		do{
			switch(choice){
			case 1:
				bookMenu();
				break;
			case 2:
				employeeMenu();
				break;
				default:
					System.out.println("Press a key 1 - 3");
			}

		}while(choice != 3);
		Runtime.getRuntime().exec("cls"); 
		menu();
	}
	public void bookMenu() throws Exception{
		int choice;
		CheckBook ch = new CheckBook();
		System.out.println("1. Create book");
		System.out.println("2. Read book");
		System.out.println("3. Update book");
		System.out.println("4. Delete book");
		System.out.println("5. Back");
		choice = input.nextInt();
		do{
			switch(choice){
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
				ch = new CheckBook(title, author, genre, pages, year, ISBN);
				ch.createBook();
				System.out.println("Done");
				Runtime.getRuntime().exec("cls");
				bookMenu();
				break;
			case 2:
				System.out.println("Enter title");
				String bookTitle = input.nextLine();
				ch.readBook(bookTitle);
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
				for(int i = 0; i < split.length; i++){
					b1 = new Book(split[i], split[i+1], split[i+2], Integer.parseInt(split[i+3]), split[i+4], split[i+5]);
				}
				ch.updateBook(btitle, b1);
				System.out.println("Done!");
				Runtime.getRuntime().exec("cls");
				bookMenu();
				break;
			case 4:
				System.out.println("Enter title");
				String _title = input.nextLine();
				ch.deleteBook(_title);
				System.out.println("Done!");
				Runtime.getRuntime().exec("cls");
				bookMenu();
				break;
			case 5: adminMenu();
			break;
			}
		}while(true);
	}

	

	@Override
	public void employeeMenu() throws Exception {
		int choice;
		System.out.println("1. Create employee");
		System.out.println("2. Read employee");
		System.out.println("3. Update employee");
		System.out.println("4. Delete employee");
		System.out.println(" 5. Back");
		choice = input.nextInt();
		do{
			switch(choice){
			case 1:
				System.out.println("Enter username and password");
				String creditentials = input.nextLine();
				String[] splitter = creditentials.split("[ ]");
				@SuppressWarnings("unused")
				User emp = null;
				for(int i = 0; i < splitter.length; i++){
					emp = new User(splitter[i], splitter[i+1]);
				}
				System.out.println("Done!");
				Runtime.getRuntime().exec("cls");
				employeeMenu();
				break;
			case 2:
				int ch;
				EmployeeChecker empCh = new EmployeeChecker();
				empCh.getEmpl(EmployeeManager.employeePath);
				System.out.println("1. Go back");
				ch = input.nextInt();
					if(ch == 1){
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
				for(int i = 0; i < userNPass.length; i++){
					u1 = new User(userNPass[i].trim(), userNPass[i+1].trim());
				}
				EmployeeChecker empl = new EmployeeChecker();
				empl.updateEmpl(uName, u1);
				System.out.println("Done!");
				Runtime.getRuntime().exec("cls");
				employeeMenu();
				break;
			case 4:
				System.out.println("Enter username");
				String _username = input.nextLine();
				EmployeeChecker emplC = new EmployeeChecker();
				emplC.deleteEmpl(_username);
				Runtime.getRuntime().exec("cls");
				employeeMenu();
				break;
			}	
		}while(choice != 5);
	}

	

	@Override
	public void employeesMenu() throws InvalidCreditentialsException,
			IOException, Exception {
		System.out.println("1. Books");
		System.out.println("2. Client");
		System.out.println("3. Exit");
		int choice = input.nextInt();
		do{
			switch(choice){
			case 1:
				CheckBook ch = new CheckBook();
				ch.readBook();
				System.out.println("Enter title");
				String title = input.nextLine();
				ch.getBook(title);
				Runtime.getRuntime().exec("cls");
				System.out.println("Done!");
				Runtime.getRuntime().exec("cls");
				employeesMenu();
				break;
			case 2:
				clientsMenu();
				break;
			}
		}while(!(choice == 3));
		
		
	}
	

	@Override
	public void clientsMenu() throws InvalidCreditentialsException,
			IOException, Exception {
		CheckClient ch = new CheckClient();
		System.out.println("1. Add client");
		System.out.println("2. List of clients");
		System.out.println("3. Update client");
		System.out.println("4. Delete client");
		System.out.println("5. Exit");
		int choice = input.nextInt();
		do{
			switch(choice){
			case 1:
				System.out.println("Enter username");
				String uName = input.nextLine();
				ch = new CheckClient(uName);
				ch.addCl(uName);
				System.out.println("Done!");
				Runtime.getRuntime().exec("cls");
				clientsMenu();
				break;
			case 2:
				ch = new CheckClient();
				ch.readCls();
				System.out.println("Done");
				Runtime.getRuntime().exec("cls");
				clientsMenu();
				break;
			case 3:
				System.out.println("Enter username");
				String _1name = input.nextLine();
				System.out.println("Enter new username");
				String _2name = input.nextLine();
				ch = new CheckClient(_1name, _2name);
				ch.updateCl(_1name, _2name);
				Runtime.getRuntime().exec("cls");
				System.out.println("Done!");
				clientsMenu();
				break;
			case 4:
				System.out.println("Enter username");
				String username = input.nextLine();
				ch = new CheckClient(username);
				ch.deleteCl(username);
				Runtime.getRuntime().exec("cls");
				System.out.println("Done!");
				clientsMenu();
				break;
			}
		}while(choice != 5);
		Runtime.getRuntime().exec("cls");
		employeesMenu();
	}
}
