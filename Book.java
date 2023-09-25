package project;

/**
 * An extension of the LibraryMaterial class. Is a book and stores specific
 * information related to books.
 *
 */
public class Book extends LibraryMaterial {

	private String author, genre;
	private static int checkOutLength = 21;

	/**
	 * Constructs the book object, using a call to the superclass to 
	 * do this.  
	 * 
	 * @param callNumber
	 * @param title
	 * @param author
	 * @param genre
	 */
	public Book(String callNumber, String title, String author, String genre) {
		super(callNumber, title, checkOutLength);

		this.author = author;
		this.genre = genre;
	}

	/**
	 * Calls the super method display information and adds on its own specific information
	 */
	public String displayInformation() {
		return super.displayInformation() + author + ", " + genre;
	}

	/**
	 * Returns the author
	 * @return
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Returns the genre
	 * @return
	 */
	public String getGenre() {
		return genre;
	}
	
	/**
	 * Returns how long the book can be checked out for
	 */
	public int getCheckOutLength() {
		return checkOutLength;
	}

	
}
