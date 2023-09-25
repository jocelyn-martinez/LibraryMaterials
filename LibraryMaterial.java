package project;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * This is an abstract class which shares characteristics between the classes
 * Book and Periodical.
 */
public abstract class LibraryMaterial {
	private String callNumber;
	private boolean checkedOut = false;
	private GregorianCalendar dateDue;
	private String title;
	private int checkOutLength;

	/**
	 * Constructs the Library material object with 3 parameters
	 * @param callNumber The call number of the LibraryMaterial
	 * @param title The title of the material
	 * @param checkOutLength How long the material can be checked out for
	 */
	public LibraryMaterial(String callNumber, String title, int checkOutLength) {
		this.callNumber = callNumber;
		this.title = title;
		this.checkOutLength = checkOutLength;
	}

	/**
	 * Sets the checkedOut field to true and returns the date it was checked
	 * out and the date it is due back
	 * @return
	 */
	public String checkOut() {
		checkedOut = true;
		
		GregorianCalendar dateCheckedOut = new GregorianCalendar();
		dateDue = (GregorianCalendar) dateCheckedOut.clone();
		dateDue.add(Calendar.DAY_OF_YEAR, checkOutLength);
		String dateOut = String.format("Date Out: %tD\n", dateCheckedOut);
		String dueDate = String.format("Due Date: %tD\n", dateDue);

		return dateOut + dueDate;
	}

	/**
	 * Returns the information that this class has for the material
	 * @return
	 */
	public String displayInformation() {
		return callNumber + ", " + title + ", ";
	}

	/**
	 * Returns the material's call number
	 * @return
	 */
	public String getCallNumber() {
		return callNumber;
	}

	/**
	 * Returns whether or not the material is checked out
	 * @return
	 */
	public boolean isCheckedOut() {
		return checkedOut;
	}

	/**
	 * Returns YES if the material is checked out and NO if it isn't
	 * @return
	 */
	public String checkOutToString() {
		if (isCheckedOut() == true) {
			return "YES";
		}
		return "NO";
	}

	/**
	 * Returns the title of the material
	 * @return
	 */
	public String getTitle() {
		return title;
	}

	public abstract int getCheckOutLength();
	
	public GregorianCalendar getDueDate() {
		return dateDue;
	}

}
