import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class BookManager extends FileManager implements IBookManager{
	private final static String bookPath = "books.txt";

	@Override
	public void addBook(Book book) throws BookNotFoundException, IOException{
		//String[] splitter = book.toString().split("[*]+");
		File file = new File(bookPath);
		Scanner fileReader = new Scanner(new FileReader(file));
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		try{
			while(!fileReader.hasNextLine()){
				writer.write(book.toString());
			}
			fileReader.close();
			writer.close();
		}catch(IOException e){
			System.out.println("file" + bookPath + "cannot be written");
		}catch(Exception e){
			e.printStackTrace();
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
		String allData = readFile(bookPath);
		String[] splitter = allData.split("[*\n]+");
		Book book = null;
		for(int i = 0; i < splitter.length; i++){
			book = new Book(splitter[i], splitter[i+1], splitter[i+2], Integer.parseInt(splitter[i+3]), splitter[i+4], splitter[i+5]);
		}
		return book;
	}

	@Override
	public void readBook() {
		String allData = readFile(bookPath);
		String[] splitter = allData.split("[*]+");
		for(int i = 0; i < splitter.length; i++){
			System.out.printf("%d %s", i, splitter[i].trim());
		}
	}
}
