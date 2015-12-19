import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Menu implements IFileManager, IRoleChecker, IBookManager, IBookRegistry, IMenuManager, IEmployeeManager, IClientsManager{
	private Scanner input = new Scanner(System.in);
	private final static String usersPath = "file.txt";
	private final static String bookPath = "books.txt";
	private final static String employeePath = "employees.txt";
	private final static String clientPath = "clients.txt";
	
	public void menu() throws Exception{
		System.out.println("Enter username");
		String username = input.nextLine();
		System.out.println("Enter password");
		String password = input.nextLine();
		if(isInRole(username, password) && isUserInRole(username).equals("ADMINISTRATOR")){
			adminMenu();
		}else if(isInRole(username, password) && isUserInRole(username).equals("EMPLOYEE")){
			employeesMenu();
		}
	}

	@Override
	public String readFile(String fileName) {
		StringBuilder sb = new StringBuilder();
		try {
			
			FileReader fileReader = new FileReader(usersPath);
			
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			while (bufferedReader.ready()) {
					String line = bufferedReader.readLine();
					sb.append(line);
					sb.append("\n");
			}
			bufferedReader.close();			
			
		} catch (Exception e) {
			System.out.println("Error while reading a file.");
			System.out.println(e.getMessage());
			System.exit(0);
		}
		return sb.toString();
	}

	@Override
	public void writeToFile(String fileName, String line) {
		try {			
			FileWriter fileStream = new FileWriter(usersPath, true);
			
			BufferedWriter writer = new BufferedWriter(fileStream);		
			
			writer.write(line);
			writer.newLine();
			writer.close();
			
		} catch (Exception e) {
			System.out.println("Error while writing a file.");
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}

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
				/*
				 * employeeMenu();
				 */
				break;
				default:
					System.out.println("Press a key 1 - 3");
			}

		}while(choice != 3);
		Runtime.getRuntime().exec("cls"); // and "clear" too  
		menu();
	}
	public void bookMenu() throws Exception{
		int choice;
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
				addBook(new Book(title, author, genre, pages, year, ISBN));
				System.out.println("Done");
				Runtime.getRuntime().exec("cls");
				bookMenu();
				break;
			case 2:
				System.out.println("Enter title");
				String bookTitle = input.nextLine();
				System.out.println(getBook(bookTitle).toString());
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
				updateBook(btitle, b1);
				System.out.println("Done!");
				Runtime.getRuntime().exec("cls");
				bookMenu();
				break;
			case 4:
				System.out.println("Enter title");
				String _title = input.nextLine();
				deleteBook(_title);
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
	public void addBook(Book book) throws IOException{
		//String[] splitter = book.toString().split("[*]+");
		File file = new File(bookPath);
		Scanner fileReader = new Scanner(new FileReader(file));
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		try{
			while(!fileReader.hasNextLine()){
//				for(int i = 0; i < splitter.length; i++){
//					writer.write(book);
//				}
				writer.write(book.toString());
			}
			fileReader.close();
			writer.close();
		}catch(IOException e){
			System.out.println("file" + bookPath + "cannot be written");
		}
	}

	@Override
	public void updateBook(String title, Book book) {
		String allData = readFile(bookPath);
		String[] splitter = allData.split("[*\n]+");
		String[] spl = book.toString().split("[*]+");
		StringBuilder b = new StringBuilder();
		try{
			@SuppressWarnings("resource")
			BufferedWriter writer = new BufferedWriter(new FileWriter(bookPath));
			for(int i = 0; i < splitter.length; i++){
				if(!splitter[i].equals(title)){
					for(String spltr:spl){
						b.append(spltr);
					}
					writer.write(b.toString());
				}
			}
			writer.close();
		}catch(IOException e){
			System.out.println("File" + bookPath + " cannot be writter");
		}
	}

	@Override
	public void deleteBook(String title) {
		String allData = readFile(bookPath);
		String[] splitter = allData.split("[*\n]+");
		StringBuilder strb = new StringBuilder();
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter(bookPath));
			for(int i = 0; i < splitter.length; i++){
				if(!splitter[i].equals(title)){
					for(String spl : splitter){
						strb.append(spl);
					}
					writer.append(strb.toString());
				}
			}
			writer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public Book getBook(String title) {
		String allData = readFile(bookPath);// TODO Auto-generated method stub
		String[] splitter = allData.split("[*\n]+");
		Book book = null;
		for(int i = 0; i < splitter.length; i++){
			book = new Book(splitter[i], splitter[i+1], splitter[i+2], Integer.parseInt(splitter[i+3]), splitter[i+4], splitter[i+5]);
		}
		return book;
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
				getEmployee();
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
				updateEmployee(uName, u1);
				System.out.println("Done!");
				Runtime.getRuntime().exec("cls");
				employeeMenu();
				break;
			case 4:
				System.out.println("Enter username");
				String _username = input.nextLine();
				deleteEmployee(_username);
				Runtime.getRuntime().exec("cls");
				employeeMenu();
				break;
			}	
		}while(choice != 5);
	}

	@Override
	public void addEmployee(User user) {
		String[] splitter = user.toString().split("[*]+");
		try{
			Scanner reader = new Scanner(new FileReader(employeePath));
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(employeePath)));
			StringBuilder bld = new StringBuilder();
			while(!reader.hasNextLine()){
				for(int i = 0; i < splitter.length; i++){
					writer.write(
							bld.append(splitter[i])
							+ "\n");
				}
			}
			reader.close();
			writer.close();
		}catch(IOException ioe){
			System.out.println("File "  + employeePath + " cannot be writen");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void getEmployee() {
		String allData = readFile(employeePath);
		String[] splitter = allData.split("[*\n]+");
		for(int i = 0; i < splitter.length; i++){
			System.out.printf("%d %s",i, splitter[i].trim());
		}
	}

	@Override
	public void updateEmployee(String username, User user) {
		String line = null;
		StringBuilder bld = new StringBuilder();
		try{
			Scanner fileRead = new Scanner(new FileReader(employeePath));
			BufferedWriter writer = new BufferedWriter(new FileWriter(employeePath));
			while(fileRead.hasNextLine()){
				line = fileRead.nextLine();
				String[] splitter = line.split("[*]+");
				for(int i = 0; i < splitter.length; i++){
					if(splitter[i].trim().equals(username)){
						continue;
					}
				}bld.append(line);
				bld.append("\n");
				writer.write(bld.toString());
			}
			writer.append(user.toString());
			fileRead.close();
			writer.close();
		}catch(IOException ioe){
			System.out.println("File "  + employeePath + " cannot be written");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteEmployee(String username) {
		String line = null;
		StringBuilder bld = new StringBuilder();
		try{
			Scanner fileRead = new Scanner(new FileReader(employeePath));
			@SuppressWarnings("resource")
			BufferedWriter writer = new BufferedWriter(new FileWriter(employeePath));
			while(fileRead.hasNextLine()){
				line = fileRead.nextLine();
				String[] splitter = line.split("[*]+");
				for(int i = 0; i < splitter.length; i++){
					if(splitter[i].trim().equals(username)){
						continue;
					}
				}bld.append(line);
				bld.append("\n");
				writer.write(bld.toString());
			}
			fileRead.close();
			fileRead.close();
		}catch(IOException ioe){
			System.out.println("File " + employeePath + " could not be opened for I/O");
		}catch(Exception e){
			e.printStackTrace();
		}
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
				readBook();
				System.out.println("Enter title");
				String title = input.nextLine();
				getBook(title);
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
	public void readBook() {
		String allData = readFile(bookPath);
		String[] splitter = allData.split("[*]+");
		for(int i = 0; i < splitter.length; i++){
			System.out.printf("%d %s", i, splitter[i].trim());
		}
	}

	@Override
	public void addClient(String username) {
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter(clientPath));
			Scanner fileRead = new Scanner(new FileReader(clientPath));
			while(!fileRead.hasNext()){
				writer.append(username);
			}
			writer.close();
			fileRead.close();
		}catch(IOException ioe){
			System.out.println("File " + clientPath + " cannot be opened");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void readClients() {
		String[] allData = readFile(clientPath)
				.split("[*\n]+");
		for(int i = 0; i < allData.length; i++){
			System.out.printf("%d %s", i, allData[i].trim());
		}
		
	}

	@Override
	public void updateClient(String username, String newUsername) {
		String line = null;
		StringBuilder bld = new StringBuilder();
		try{
			Scanner fileRead = new Scanner(new FileReader(clientPath));
			BufferedWriter writer = new BufferedWriter(new FileWriter(clientPath));
			while(fileRead.hasNextLine()){
				line = fileRead.nextLine();
				String[] splitter = line.split("[*]+");
				for(int i = 0; i < splitter.length; i++){
					if(splitter[i].trim().equals(username)){
						continue;
					}
				}bld.append(line);
				bld.append("\n");
				writer.write(bld.toString());
			}
			writer.append(username);
			fileRead.close();
			writer.close();
		}catch(IOException ioe){
			System.out.println("File "  + clientPath + " cannot be written");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void deleteClient(String username) {
		String line = null;
		StringBuilder bld = new StringBuilder();
		try{
			Scanner fileRead = new Scanner(new FileReader(clientPath));
			@SuppressWarnings("resource")
			BufferedWriter writer = new BufferedWriter(new FileWriter(clientPath));
			while(fileRead.hasNextLine()){
				line = fileRead.nextLine();
				String[] splitter = line.split("[*]+");
				for(int i = 0; i < splitter.length; i++){
					if(splitter[i].trim().equals(username)){
						continue;
					}
				}bld.append(line);
				bld.append("\n");
				writer.write(bld.toString());
			}
			fileRead.close();
			fileRead.close();
		}catch(IOException ioe){
			System.out.println("File " + employeePath + " could not be opened for I/O");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void clientsMenu() throws InvalidCreditentialsException,
			IOException, Exception {
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
				addClient(uName);
				System.out.println("Done!");
				Runtime.getRuntime().exec("cls");
				clientsMenu();
				break;
			case 2:
				readClients();
				System.out.println("Done");
				Runtime.getRuntime().exec("cls");
				clientsMenu();
				break;
			case 3:
				System.out.println("Enter username");
				String _1name = input.nextLine();
				System.out.println("Enter new username");
				String _2name = input.nextLine();
				updateClient(_1name, _2name);
				Runtime.getRuntime().exec("cls");
				System.out.println("Done!");
				clientsMenu();
				break;
			case 4:
				System.out.println("Enter username");
				String username = input.nextLine();
				deleteClient(username);
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
