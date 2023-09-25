package project;

/**
 * An extension of the LibraryMaterial class. Is a book and stores specific
 * information related to periodicals.
 *
 */
public class Periodical extends LibraryMaterial {

	private String title, volume, issue, callNumber, subject;
	private static int checkOutLength = 7;

	/**
	 * Constructs the periodical object, using a call to the superclass to 
	 * do this.  
	 * @param callNumber
	 * @param title
	 * @param volume
	 * @param issue
	 * @param subject
	 */
	public Periodical(String callNumber, String title, String volume, String issue, String subject) {
		super(callNumber, title, checkOutLength);
		this.volume = volume;
		this.issue = issue;
		this.subject = subject;
	}
	
	/**
	 * Calls the super method display information and adds on its own specific information
	 */
	public String displayInformation() {
		return super.displayInformation() + volume + ", " + issue + ", " + subject;

	}

	/**
	 * Returns the volume
	 * @return
	 */
	public String getVolume() {
		return volume;
	}
	
	/**
	 * Returns the issue
	 * @return
	 */
	public String getIssue() {
		return issue;
	}

	/**
	 * Returns the subject
	 * @return
	 */
	public String getSubject() {
		return subject;
	}
	
	/**
	 * Returns how long the periodical can be checked out for
	 */
	public int getCheckOutLength() {
		return checkOutLength;
	}
}
