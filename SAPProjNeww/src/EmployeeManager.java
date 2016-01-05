import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EmployeeManager extends FileManager implements IEmployeeManager {
	public final static String employeePath = "employees.txt";

	@Override
	public void addEmployee(User user) {
		String[] splitter = user.toString().split("[*]+");
		try {
			Scanner reader = new Scanner(new FileReader(employeePath));
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(employeePath)));
			StringBuilder bld = new StringBuilder();
			while (!reader.hasNextLine()) {
				for (int i = 0; i < splitter.length; i++) {
					writer.write(bld.append(splitter[i]) + "\n");
				}
			}
			reader.close();
			writer.close();
		} catch (IOException ioe) {
			System.out.println("File " + employeePath + " cannot be writen");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void getEmployee(String fileName) {
		String allData = readFile(fileName);
		String[] splitter = allData.split("[*\n]+");
		for (int i = 0; i < splitter.length; i++) {
			System.out.printf("%d %s", i, splitter[i].trim());
		}
	}

	@Override
	public void updateEmployee(String username, User user) {
		String line = null;
		StringBuilder bld = new StringBuilder();
		try {
			Scanner fileRead = new Scanner(new FileReader(employeePath));
			BufferedWriter writer = new BufferedWriter(new FileWriter(employeePath));
			while (fileRead.hasNextLine()) {
				line = fileRead.nextLine();
				String[] splitter = line.split("[*]+");
				for (int i = 0; i < splitter.length; i++) {
					if (splitter[i].trim().equals(username)) {
						continue;
					}
				}
				bld.append(line);
				bld.append("\n");
				writer.write(bld.toString());
			}
			writer.append(user.toString());
			fileRead.close();
			writer.close();
		} catch (IOException ioe) {
			System.out.println("File " + employeePath + " cannot be written");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteEmployee(String username) {
		String line = null;
		StringBuilder bld = new StringBuilder();
		try {
			Scanner fileRead = new Scanner(new FileReader(employeePath));
			@SuppressWarnings("resource")
			BufferedWriter writer = new BufferedWriter(new FileWriter(employeePath));
			while (fileRead.hasNextLine()) {
				line = fileRead.nextLine();
				String[] splitter = line.split("[*]+");
				for (int i = 0; i < splitter.length; i++) {
					if (splitter[i].trim().equals(username)) {
						continue;
					}
				}
				bld.append(line);
				bld.append("\n");
				writer.write(bld.toString());
			}
			fileRead.close();
			fileRead.close();
		} catch (IOException ioe) {
			System.out.println("File " + employeePath + " could not be opened for I/O");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
