package library;

public class Reader {
    
    // Reader Attributes
    /**
     * The unique identifier of the reader.
     */
    private String id;
    /**
     * The name of the reader.
     */
    private String name;
    /**
     * The email contact of the reader.
     */
    private String contact;

    /**
     * Constructs a Reader object with the specified information.
     *
     * @param id      the ID of the reader
     * @param name    the name of the reader
     * @param contact the email contact of the reader
     */
    public Reader(String id, String name, String contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }

    /**
     * Displays the information of the reader.
     */
    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Contact: " + contact);
    }

    /**
     * Returns the ID of the reader.
     *
     * @return the ID of the reader
     */
    public String getId() {
        return id;
    }
}
