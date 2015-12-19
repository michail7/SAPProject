
public class Book{
	private String bookTitle;
	private String bookAuthor;
	private String bookGenre;
	private int numberOfPages;
	private String year;
	private String isbn;
	private final static String PATTERN = "^[A-Z][a-z]&{2-25}";
	
	public Book(){
		
	}
	public Book(String bookTitle, String bookAuthor, String bookGenre, int numberOfPages, String year, String isbn){
		setTitle(bookTitle);
		setAuthor(bookAuthor);
		setGenre(bookGenre);
		setPages(numberOfPages);
		setYear(year);
		setISBN(isbn);
	}
	public void setTitle(String bookTitle){
		if(bookTitle.matches(PATTERN)){
			this.bookTitle = bookTitle;
		}
	}
	public void setAuthor(String bookAuthor){
		if(bookAuthor.matches(PATTERN)){
			this.bookAuthor = bookAuthor;
		}
	}
	public void setGenre(String bookGenre){
		if(bookGenre.matches(PATTERN)){
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
	public void setISBN(String isbn){
		if(isbn.matches(PATTERN)){
			this.isbn = isbn;
		}
	}
	
	@Override
	public String toString(){
		return bookTitle + "***" + bookAuthor + "***" + bookGenre + "***" + numberOfPages + "***" + year + "***" + isbn;
	}
}
