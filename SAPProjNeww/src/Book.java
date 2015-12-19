
public class Book{
	private String bookTitle;
	private String bookAuthor;
	private String bookGenre;
	private int numberOfPages;
	private String year;
	private String ISBN;
	
	public Book(){
		
	}
	public Book(String bookTitle, String bookAuthor, String bookGenre, int numberOfPages, String year, String ISBN){
		setTitle(bookTitle);
		setAuthor(bookAuthor);
		setGenre(bookGenre);
		setPages(numberOfPages);
		setYear(year);
		setISBN(ISBN);
	}
	public void setTitle(String bookTitle){
		if(bookTitle.matches("^[A-Z][a-z]&{2-25}")){
			this.bookTitle = bookTitle;
		}
	}
	public void setAuthor(String bookAuthor){
		if(bookAuthor.matches("^[A-Z][a-z]&{2-25}")){
			this.bookAuthor = bookAuthor;
		}
	}
	public void setGenre(String bookGenre){
		if(bookGenre.matches("^[A-Z][a-z]&{2-25}")){
			this.bookGenre = bookGenre;
		}
	}
	public void setPages(int bookPages){
		if(bookPages > 0){
			this.numberOfPages = bookPages;
		}
	}
	public void setYear(String year){
		if(year.matches("[1900-2015]")){
			this.year = year;
		}
	}
	public void setISBN(String ISBN){
		if(ISBN.matches("[0-9-]{10-13}")){
			this.ISBN = ISBN;
		}
	}
	
	@Override
	public String toString(){
		return bookTitle + "***" + bookAuthor + "***" + bookGenre + "***" + numberOfPages + "***" + year + "***" + ISBN;
	}
}
