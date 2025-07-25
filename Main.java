package library;

import java.util.Scanner;

public class Main {
	
    /**
     * Prompts the user for an integer input within a specified range.
     * Repeats the prompt until a valid input is provided.
     *
     * @param scanner     the Scanner object for user input
     * @param modifier    the modifier for the input prompt
     * @param rangeStart  the starting value of the input range (inclusive)
     * @param rangeEnd    the ending value of the input range (inclusive)
     * @return the valid integer input provided by the user
     */
	public static int getUserInput(Scanner scanner, String modifier, int rangeStart, int rangeEnd) {
		// repeat until the input is an acceptable integer
		while (true) {
			// Prompt user input, accept string
			System.out.printf("Enter %s: ", modifier);
			String strInput = scanner.nextLine();
			try {
				// try to convert string input to integer
				int intInput = Integer.parseInt(strInput);
				// check if the input integer is in range  
				if (intInput < rangeStart || intInput > rangeEnd) {
					// show error message if not in range
					System.out.printf("Invalid %s. Please enter again.\n", modifier);
					continue;
				}
				// return the input if everything is ok
				return intInput;
				
			// show error message if the input is not string
			} catch (NumberFormatException e) {
				System.out.println("Inappropriate input. Please enter again.");
			}
		}
	}
	
    /**
     * Prompts the user for a non-empty string input.
     * Repeats the prompt until a non-empty string is provided.
     *
     * @param scanner   the Scanner object for user input
     * @param modifier  the modifier for the input prompt
     * @return the non-empty string input provided by the user
     */
	public static String getUserInput(Scanner scanner, String modifier) {
		// repeat until the input is an acceptable integer
		while (true) {
			// Prompt user input, accept string
			System.out.printf("Enter %s: ", modifier);
			String strInput = scanner.nextLine();
			
			// Check if the string is an empty string
			if (strInput.length() == 0) {
				// Show error message if it is empty string
				System.out.printf("The %s cannot be empty. Please enter again.\n", modifier);
				continue;
			}
			// return the input if passes all the test
			return strInput;
		}
	}
	
    // Main menu method
    /**
     * Displays the main menu and handles user input for the main menu options.
     * Calls other methods based on the user's choice.
     *
     * @param library  the Library object
     * @param scanner  the Scanner object for user input
     */
	public static void displayMainMenu(Library library, Scanner scanner) {
		// Initialize choice
		int choice = -1;
		
		// Repeat showing menu until the user exits
		while (choice != 0) {
			
			// Display menu
			System.out.println("Hello Librarian! Welcome to Library Management System!");
			System.out.println("                       Main Menu");
			System.out.println("-------------------------------------------------------");
			System.out.println("1. Book Management");
			System.out.println("2. Reader Management");
			System.out.println("3. Borrowing and Returning");
			System.out.println("0. Exit");
			System.out.println("-------------------------------------------------------");
			
			// Get user input between 0 and 3
			choice = getUserInput(scanner, "choice", 0, 3);
			
			// Get into sub-menu per choice
			switch (choice) {
			case 1:
				displayBookMenu(library, scanner);
				break;
			case 2:
				displayReaderMenu(library, scanner);
				break;
			case 3:
				displayBorrowReturnMenu(library, scanner);
				break;
			}
			
			System.out.println();
		}
	}
	
    // Book menu method
    /**
     * Displays the book management menu and handles user input for book-related operations.
     * Calls library methods to perform the requested operations.
     *
     * @param library  the Library object
     * @param scanner  the Scanner object for user input
     */
	public static void displayBookMenu(Library library, Scanner scanner) {
		// Initialize choice
		int choice = -1;
		
		// Repeat showing menu until the user back to main menu
		while (choice != 0) {
			
			// Initialize variables
			String title, author, ISBN;
			int publicationYear;
			
			// Display menu
			System.out.println("                    Book Management");
			System.out.println("-------------------------------------------------------");
			System.out.println("1. Add a new book");
			System.out.println("2. Remove book by ISBN");
			System.out.println("3. Update book details by ISBN");
			System.out.println("4. Display all books information");
			System.out.println("5. Search book information by ISBN");
			System.out.println("0. Back to Main Menu");
			System.out.println("-------------------------------------------------------");
			
			// Get user input between 0 and 4
			choice = getUserInput(scanner, "choice", 0, 5);
			
			// Call library methods per choice
			switch (choice) {
			case 1:
				title = getUserInput(scanner, "title");
				author = getUserInput(scanner, "author");
				ISBN = getUserInput(scanner, "ISBN");
				publicationYear = getUserInput(scanner, "publication year", 1900, 2024);
				library.addBook(ISBN, title, author, publicationYear);
				break;
			case 2:
				ISBN = getUserInput(scanner, "ISBN");
				library.removeBook(ISBN);
				break;
			case 3:
				ISBN = getUserInput(scanner, "ISBN");
				title = getUserInput(scanner, "title");
				author = getUserInput(scanner, "author");
				publicationYear = getUserInput(scanner, "publication year", 1900, 2024);
				library.updateBook(ISBN, title, author, publicationYear);
				break;
			case 4:
				library.displayAllBooksInfo();
				break;
			case 5:
				ISBN = getUserInput(scanner, "ISBN");
				library.displayBookInfo(ISBN);
				break;
			}
			
			System.out.println();
		}
	}
	
    // Reader menu method
    /**
     * Displays the reader management menu and handles user input for reader-related operations.
     * Calls library methods to perform the requested operations.
     *
     * @param library  the Library object
     * @param scanner  the Scanner object for user input
     */
	public static void displayReaderMenu(Library library, Scanner scanner) {
		// Initialize choice
		int choice = -1; 
		
		// Repeat showing menu until the user back to main menu
		while (choice != 0) {
			// Initialize variables
			String readerId, name, contact;
			
			// Display menu
			System.out.println("                   Reader Management");
			System.out.println("-------------------------------------------------------");
			System.out.println("1. Add a new reader");
			System.out.println("2. Remove reader by ID");
			System.out.println("3. Display all readers information");
			System.out.println("4. Search reader information by ISBN");
			System.out.println("0. Back to Main Menu");
			System.out.println("-------------------------------------------------------");
			
			// Get user input between 0 and 4
			choice = getUserInput(scanner, "choice", 0, 4);
			
			// Call library methods per choice
			switch (choice) {
			case 1:
				readerId = getUserInput(scanner, "reader ID");
				name = getUserInput(scanner, "name");
				contact = getUserInput(scanner, "contact");
				library.addReader(readerId, name, contact);
				break;
			case 2:
				readerId = getUserInput(scanner, "reader ID");
				library.removeReader(readerId);
				break;
			case 3:
				library.displayAllReadersInfo();
				break;
			case 4:
				readerId = getUserInput(scanner, "reader ID");
				library.displayReaderInfo(readerId);
				break;
			}
			
			System.out.println();
		}
	}
	
    // Borrow and Return menu method
    /**
     * Displays the borrowing and returning menu and handles user input for borrowing and returning operations.
     * Calls library methods to perform the requested operations.
     *
     * @param library  the Library object
     * @param scanner  the Scanner object for user input
     */
	public static void displayBorrowReturnMenu(Library library, Scanner scanner) {
		// Initialize choice
		int choice = -1; 
		
		// Repeat showing menu until the user back to main menu
		while (choice != 0) {
			// Initialize variables
			String readerId, ISBN;
			
			// Display menu
			System.out.println("                Borrowing and Returning");
			System.out.println("-------------------------------------------------------");
			System.out.println("1. Borrowing");
			System.out.println("2. Returning");
			System.out.println("0. Back to Main Menu");
			System.out.println("-------------------------------------------------------");
			
			// Get user input between 0 and 2
			choice = getUserInput(scanner, "choice", 0, 2);
			
			// Call library methods per choice
			switch (choice) {
			case 1:
				readerId = getUserInput(scanner, "reader ID");
				ISBN = getUserInput(scanner, "ISBN");
				library.borrowBook(readerId, ISBN);
				break;
			case 2:
				readerId = getUserInput(scanner, "reader ID");
				ISBN = getUserInput(scanner, "ISBN");
				library.returnBook(readerId, ISBN);
				break;
			}
			
			System.out.println();
		}
	}

    // Main method
    /**
     * The entry point of the program.
     * Creates an instance of the Library class and a Scanner object.
     * Calls the displayMainMenu method to start the library management system.
     *
     * @param args  the command line arguments
     */
	public static void main(String[] args) {
		// Initialize library and scanner
		Library library = new Library();
		Scanner scanner = new Scanner(System.in);
		// Pass the library and scanner to menu methods
		displayMainMenu(library, scanner);
	}
}
