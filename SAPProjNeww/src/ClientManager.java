import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ClientManager extends FileManager implements IClientsManager {
	private final static String clientPath = "clients.txt";

	@Override
	public void addClient(String username) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(clientPath));
			Scanner fileRead = new Scanner(new FileReader(clientPath));
			while (!fileRead.hasNext()) {
				writer.append(username);
			}
			writer.close();
			fileRead.close();
		} catch (IOException ioe) {
			System.out.println("File " + clientPath + " cannot be opened");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void readClients() {
		String[] allData = readFile(clientPath).split("[*\n]+");
		for (int i = 0; i < allData.length; i++) {
			System.out.printf("%d %s", i, allData[i].trim());
		}

	}

	@Override
	public void updateClient(String username, String newUsername) {
		String line = null;
		StringBuilder bld = new StringBuilder();
		try {
			Scanner fileRead = new Scanner(new FileReader(clientPath));
			BufferedWriter writer = new BufferedWriter(new FileWriter(clientPath));
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
			writer.append(username);
			fileRead.close();
			writer.close();
		} catch (IOException ioe) {
			System.out.println("File " + clientPath + " cannot be written");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteClient(String username) {
		String line = null;
		StringBuilder bld = new StringBuilder();
		try {
			Scanner fileRead = new Scanner(new FileReader(clientPath));
			@SuppressWarnings("resource")
			BufferedWriter writer = new BufferedWriter(new FileWriter(clientPath));
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
			System.out.println("File " + clientPath + " could not be opened for I/O");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
