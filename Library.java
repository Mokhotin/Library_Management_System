package library;

import java.util.ArrayList;

public class Library {
    /**
     * The book list of the library.
     */
    private ArrayList<Book> books;
    /**
     * The reader list of the library.
     */
    private ArrayList<Reader> readers;
    
    /**
     * Constructs a Library object.
     * Initializes the books and readers lists.
     */
    public Library() {
    	books = new ArrayList<Book>();
    	readers = new ArrayList<Reader>();
    }
    
    // Book-related Methods
    
    /**
     * Searches for a book in the library based on its ISBN.
     *
     * @param ISBN the ISBN of the book to search for
     * @return the book with the specified ISBN, or null if not found
     */
    public Book searchBookByISBN(String ISBN) {
    	// Iterate books
        for (Book book : books) {
        	// Return the book if found
            if (book.getISBN().equals(ISBN)) {
            	return book;
            }
        }
        // Return null if not found
        return null;
    }
    
    /**
     * Adds a book to the library.
     * Shows an error message if a book with the same ISBN already exists.
     *
     * @param ISBN            the ISBN of the book
     * @param title           the title of the book
     * @param author          the author of the book
     * @param publicationYear the publication year of the book
     */
    public void addBook(String ISBN, String title, String author, int publicationYear) {
    	Book book = searchBookByISBN(ISBN);
    	if (book != null) {
        	System.out.printf("Book ISBN %s failed to add. There is the same book in the system.\n", ISBN);
        	return;
    	}
        book = new Book(title, author, ISBN, publicationYear);
        books.add(book);
        System.out.printf("Book ISBN %s added successfully.\n", ISBN);
    }
    
    /**
     * Removes a book from the library based on its ISBN.
     * Shows an error message if the book is not found.
     *
     * @param ISBN the ISBN of the book to remove
     */
    public void removeBook(String ISBN) {
        Book book = searchBookByISBN(ISBN);
        if (book == null) {
        	System.out.printf("Book ISBN %s not found.\n", ISBN);
        	return;
        }
        books.remove(book);
        System.out.printf("Book ISBN %s removed successfully.\n", ISBN);
    }

    /**
     * Updates the information of a book in the library based on its ISBN.
     * Shows an error message if the book is not found.
     *
     * @param ISBN              the ISBN of the book to update
     * @param title             the updated title of the book
     * @param author            the updated author of the book
     * @param publicationYear   the updated publication year of the book
     */
    public void updateBook(String ISBN, String title, String author, int publicationYear) {
        Book book = searchBookByISBN(ISBN);
        if (book == null) {
        	System.out.printf("Book ISBN %s not found.\n", ISBN);
        	return;
        }
        book.updateInfo(title, author, publicationYear);
        System.out.printf("Book ISBN %s updated successfully.", ISBN);
    }

    /**
     * Displays information for all books in the library.
     * Shows an error message if there are no books in the library.
     */
    public void displayAllBooksInfo() {
    	System.out.println("--------------------");
        if (books.isEmpty()) {
            System.out.println("No books in the system.");
            return;
        }
        for (Book book : books) {
            book.displayInfo();
            System.out.println("--------------------");
        }
    }

    /**
     * Displays information for a book in the library based on its ISBN.
     * Shows an error message if the book is not found.
     *
     * @param ISBN the ISBN of the book to display information for
     */
    public void displayBookInfo(String ISBN) {
        Book book = searchBookByISBN(ISBN);
        if (book == null) {
        	System.out.printf("Book ISBN %s not found.\n", ISBN);
        	return;
        }
        book.displayInfo();
    }
    
    // Reader-related methods
    
    /**
     * Searches for a reader in the library based on their ID.
     *
     * @param readerId the ID of the reader to search for
     * @return the reader with the specified ID, or null if not found
     */
    public Reader searchReaderById(String readerId) {
        for (Reader reader : readers) {
            if (reader.getId().equals(readerId)) {
                return reader;
            }
        }
        return null;
    }

    /**
     * Adds a reader to the library.
     * Shows an error message if a reader with the same ID already exists.
     *
     * @param readerId  the ID of the reader
     * @param name  	the name of the reader
     * @param contact 	the contact of the reader
     */
    public void addReader(String readerId, String name, String contact) {
    	Reader reader = searchReaderById(readerId);
    	if (reader != null) {
        	System.out.printf("Reader ID %s failed to add. There is the same reader in the system.\n", readerId);
        	return;
    	}
        reader = new Reader(readerId, name, contact);
        readers.add(reader);
        System.out.printf("Reader ID %s added successfully.\n", readerId);
    }

    /**
     * Removes a reader from the library based on their ID.
     * Shows an error message if the reader is not found.
     *
     * @param readerId the ID of the reader to remove
     */
    public void removeReader(String readerId) {
    	Reader reader = searchReaderById(readerId);
        if (reader == null) {
        	System.out.printf("Reader ID %s not found.\n", readerId);
        	return;
        }
        readers.remove(reader);
        System.out.printf("Reader ID %s removed successfully.\n", readerId);
    }

    /**
     * Displays information for all readers in the library.
     * Shows an error message if there are no readers in the library.
     */
    public void displayAllReadersInfo() {
        if (readers.isEmpty()) {
            System.out.println("No readers in the system.");
        } else {
            for (Reader reader : readers) {
                reader.displayInfo();
                System.out.println("--------------------");
            }
        }
    }

    /**
     * Displays information for a reader in the library based on their ID.
     * Shows an error message if the reader is not found.
     *
     * @param readerId the ID of the reader to display information for
     */
    public void displayReaderInfo(String readerId) {
    	Reader reader = searchReaderById(readerId);
        if (reader == null) {
        	System.out.printf("Reader ID %s not found.\n", readerId);
        	return;
        }
        reader.displayInfo();
    }

    // Borrow and Return Methods
    
    /**
     * Borrows a book from the library.
     * Shows an error message if the book or reader is not found, or if the book is not available.
     *
     * @param readerId the ID of the reader returning the book
     * @param ISBN the ISBN of the book to return
     */
    public void borrowBook(String readerId, String ISBN) {
    	
    	// Search the corresponding reader and book by input
        Reader reader = searchReaderById(readerId);
        Book book = searchBookByISBN(ISBN);
        
        // Show error message if reader not found
        if (reader == null) {
            System.out.printf("Reader ID %s not found.\n", readerId);
            
        // Show error message if book not found
        } else if (book == null) {
            System.out.printf("Book ISBN %s not found.\n", ISBN);
            
        // Show error message if the book is being borrowed 
        } else if (book.getAvailabilityStatus().equals("borrowed")) {
            System.out.printf("Book ISBN %s is not available for borrowing.\n", ISBN);
            
        // Otherwise, update book status and association, and show successful message
        } else {
            book.setAvailabilityStatus("borrowed");
            book.setAssociation(readerId);
            System.out.printf("Book ISBN %s is now borrowed by Reader ID %s\n", ISBN, readerId);
        }
    }
    
    /**
     * Returns a borrowed book to the library.
     * Shows an error message if the book or reader is not found, or if the book is already available.
     *
     * @param readerId the ID of the reader returning the book
     * @param ISBN the ISBN of the book to return
     */
    public void returnBook(String readerId, String ISBN) {
    	
    	// Search the corresponding reader and book by input
    	Reader reader = searchReaderById(readerId);
        Book book = searchBookByISBN(ISBN);
        
        // Show error message if reader not found
        if (reader == null) {
        	System.out.printf("Reader ID %s not found.\n", readerId);
        	
        // Show error message if book not found
        } else if (book == null) {
            System.out.printf("Book ISBN %s not found.\n", ISBN);
            
        // Show error message if the book is not being borrowed 
        } else if (book.getAvailabilityStatus().equals("available")) {
            System.out.printf("Book ISBN %s is already returned.\n", ISBN);
            
        // Show error message if the book is not being borrowed by another person            	
        } else if (book.getAvailabilityStatus().equals("borrowed") && !book.getAssociation().equals(readerId)) {
        	System.out.printf("Book ISBN %s is not borrowed by %s.\n", ISBN, readerId);
        	
        // Otherwise, update book status and association, and show successful message
        } else {
            book.setAvailabilityStatus("available");
            book.setAssociation("no association");
            System.out.printf("Reader ID %s returned Book ISBN %s successfully.\n", readerId, ISBN);
        }
        
    }    
}
