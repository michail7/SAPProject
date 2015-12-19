import java.io.IOException;


public interface IBookManager {
	public void addBook(Book book) throws IOException;
	public void readBook();
	public void updateBook(String title, Book book);
	public void deleteBook(String title);
}
