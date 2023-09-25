package project;

import javax.swing.JOptionPane;

/**
 * The GUI class the user will interact with. The user will have three options
 * to choose from: Display, Check Out, and Quit.
 *
 */

public class LibraryView {

	String[] buttons;
	String options;
	Library library;

	public LibraryView() {
		buttons = new String[] { "Display", "Check Out", "Quit" };
		this.options = (String) JOptionPane.showInputDialog(null, "Please pick an option : ", "Library Catalogue",
				JOptionPane.QUESTION_MESSAGE, null, buttons, buttons[2]);
		this.library = new Library();
	}

	public void chooseOptions() {

		while (options != null && !options.equals("quit")) {
			try {

				if (options.equals("Display")) {

					//Will display the information of everything that is stored inside the Library.
					String displayingMaterials = library.displayMaterials();
					JOptionPane.showMessageDialog(null, displayingMaterials);

					options = (String) JOptionPane.showInputDialog(null, "Please pick an option : ",
							"Library Catalogue", JOptionPane.QUESTION_MESSAGE, null, buttons, buttons[2]);

				} else if (options.equals("Check Out")) {

					//Allows the user to check out using a call number
					String userInput = JOptionPane.showInputDialog("Please enter the Call Number :").toUpperCase();
					LibraryMaterial specificItem = library.searchCallNumber(userInput);

					//Will look into the check out status of the item the user has searched.
					//Will either check out the item, tell the user the item has been checked out, or 
					//if the user inputs a value that does not match to any of the items it will show an error.
					Boolean materialStatus = specificItem.isCheckedOut();
					if (materialStatus == false) {

						String message = specificItem.displayInformation();
						JOptionPane.showMessageDialog(null, message + "\n" + specificItem.checkOut());

						options = (String) JOptionPane.showInputDialog(null, "Please pick an option : ",
								"Library Catalogue", JOptionPane.QUESTION_MESSAGE, null, buttons, buttons[2]);

					} else if (materialStatus == true) {
						JOptionPane.showMessageDialog(null, "The item you have searched is currently checked out.");

						options = (String) JOptionPane.showInputDialog(null, "Please pick an option : ",
								"Library Catalogue", JOptionPane.QUESTION_MESSAGE, null, buttons, buttons[2]);
					}
				}
			}
			catch (PrimaryError e) {
				JOptionPane.showMessageDialog(null, "Invalid input.", "Alert", JOptionPane.WARNING_MESSAGE);
				options = (String) JOptionPane.showInputDialog(null, "Please pick an option : ", "Library Catalogue",
						JOptionPane.QUESTION_MESSAGE, null, buttons, buttons[2]);
			}
		}
	}
}
