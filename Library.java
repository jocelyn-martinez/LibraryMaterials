package project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Library extends Exception {
	private static String fileName = "librarymaterials.txt";
	private ArrayList<LibraryMaterial> catalogue = new ArrayList<LibraryMaterial>();

	/**
	 * Creates a new library object. Takes information from a file and then stores
	 * the new books and periodicals in the ArrayList catalogue
	 */
	public Library() {
		File file = new File(fileName);
		String line;

		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferReader = new BufferedReader(fileReader);

			while ((line = bufferReader.readLine()) != null) {
				String[] infoArray = line.split(",");
				if (infoArray[0].equals("B")) {
					// If the object is a book then make a new book
					Book book = new Book(infoArray[1], infoArray[2], infoArray[3], infoArray[4]);
					catalogue.add(book);

				} else if (infoArray[0].equals("P")) {
					// If the object is a periodical then make a new periodical
					Periodical periodical = new Periodical(infoArray[1], infoArray[2], infoArray[3], infoArray[4],
							infoArray[5]);
					catalogue.add(periodical);
				}
			}
			bufferReader.close();

		} catch (FileNotFoundException ex) {
			System.out.println("File cannot be found");
		} catch (IOException ex) {
			System.out.println("An error occurred when reading the file.");
		}
	}

	/**
	 * Searches threw the catalogue for a specific title and returns it if found. If a title is not found a null
	 * pointer exception is thrown
	 * @param callNumber
	 * @return LibraryMaterial or NullPointerException
	 */
	public LibraryMaterial searchCallNumber(String callNumber) throws PrimaryError {
		for (int i = 0; i < catalogue.size(); i++) {
			if (catalogue.get(i).getCallNumber().equals(callNumber)) {
				return catalogue.get(i);
			}
		}
		throw new PrimaryError("Error!");
	}

	/**
	 * Returns a string containing all the information in the catalogue
	 * 
	 * @return The information of everything in the catalogue
	 */
	public String displayMaterials() {
		String returnDisplay = "";

		for (int i = 0; i < catalogue.size(); i++) {
			returnDisplay += catalogue.get(i).displayInformation() + " \n" + "Check-Out Status: "
					+ catalogue.get(i).checkOutToString() + " \n";
			if (catalogue.get(i).isCheckedOut() == true) {
				returnDisplay += catalogue.get(i).checkOut();
			}
		}
		return returnDisplay;
	}

}
