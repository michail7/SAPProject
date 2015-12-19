import java.io.IOException;


public interface IBookManager {
	Book getBook(String title);
	void addBook(Book book) throws BookNotFoundException, IOException;
	void updateBook(String title, Book book);
	void deleteBook(String title);
	void readBook();
}
