
public class Book {
	private String title;
	private String author;
	private String genre;
	private int numberOfPages;
	private String year;
	private String isbn;
	private final static String PATTERN = "^[A-Z][a-z]&{2-25}";

	public Book() {

	}

	public Book(String bookTitle, String bookAuthor, String bookGenre, int numberOfPages, String year, String isbn) {
		setTitle(bookTitle);
		setAuthor(bookAuthor);
		setGenre(bookGenre);
		setPages(numberOfPages);
		setYear(year);
		setISBN(isbn);
	}

	public void setTitle(String bookTitle) {
		if (bookTitle.matches(PATTERN)) {
			this.title = bookTitle;
		}
	}

	public void setAuthor(String bookAuthor) {
		if (bookAuthor.matches(PATTERN)) {
			this.author = bookAuthor;
		}
	}

	public void setGenre(String bookGenre) {
		if (bookGenre.matches(PATTERN)) {
			this.genre = bookGenre;
		}
	}

	public void setPages(int bookPages) {
		if (bookPages > 0) {
			this.numberOfPages = bookPages;
		}
	}

	public void setYear(String year) {
		if (year.matches("[1900-2015]")) {
			this.year = year;
		}
	}

	public void setISBN(String isbn) {
		if (isbn.matches(PATTERN)) {
			this.isbn = isbn;
		}
	}

	@Override
	public String toString() {
		return title + "***" + author + "***" + genre + "***" + numberOfPages + "***" + year + "***" + isbn;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + numberOfPages;
		result = prime * result + ((year == null) ? 0 : year.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (numberOfPages != other.numberOfPages)
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}

}
