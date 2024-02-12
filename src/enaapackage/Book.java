package enaapackage;


public class Book {
    private String title;
    private String author;
    private String isbn;
    private String publicationDate;
    private boolean reserved;
    private Student currentBorrower;

    public Book(String title, String author, String isbn, String publicationDate) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationDate = publicationDate;
        this.reserved = false;
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
    
    public boolean isReserved() {
        return reserved;
    }
    
    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    // Other methods
}