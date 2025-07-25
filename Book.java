package library;

public class Book {
    
    // Book Attributes
    /**
     * The unique identifier (ISBN) of the book.
     */
    private String ISBN;
    /**
     * The title of the book.
     */
    private String title;
    /**
     * The author of the book.
     */
    private String author;
    /**
     * The publication year of the book.
     */
    private int publicationYear;
    /**
     * Denote availability of the book ("available", "borrowed")
     */
    private String availabilityStatus;
    /**
     * The readerId associated with the book. "no association" if the book is available
     */
    private String association;

    /**
     * Constructs a Book object with the specified information.
     *
     * @param title           the title of the book
     * @param author          the author of the book
     * @param ISBN            the ISBN of the book
     * @param publicationYear the publication year of the book
     */
    public Book(String title, String author, String ISBN, int publicationYear) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publicationYear = publicationYear;
        this.availabilityStatus = "available"; // Default available in library
        this.association = "no association"; // Default no one borrows
    }

    /**
     * Updates the information of the book.
     *
     * @param title           the new title of the book
     * @param author          the new author of the book
     * @param publicationYear the new publication year of the book
     */
    public void updateInfo(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    /**
     * Displays the information of the book.
     */
    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + ISBN);
        System.out.println("Publication Year: " + publicationYear);
        System.out.println("Availability Status: " + availabilityStatus);
        System.out.println("Association: " + association);
    }

    /**
     * Returns the ISBN (International Standard Book Number) of the book.
     *
     * @return the ISBN of the book
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * Returns the availability status of the book.
     *
     * @return the availability status of the book
     */
    public String getAvailabilityStatus() {
        return availabilityStatus;
    }

    /**
     * Sets the availability status of the book.
     *
     * @param availabilityStatus the new availability status of the book
     */
    public void setAvailabilityStatus(String availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    /**
     * Returns the association of the book.
     *
     * @return the association of the book
     */
    public String getAssociation() {
        return association;
    }

    /**
     * Sets the association of the book.
     *
     * @param association the new association of the book
     */
    public void setAssociation(String association) {
        this.association = association;
    }
}
