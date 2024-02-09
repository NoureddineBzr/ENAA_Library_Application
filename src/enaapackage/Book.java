package enaapackage;
public class Book {
    private String title;
    private String author;
    private String isbn;
    private String publicationDate;
    private Student borrower;

    public Book(String title, String author, String isbn, String publicationDate) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationDate = publicationDate;
        this.borrower = null;
    }

    public void updateDetails(String title, String author, String isbn, String publicationDate) {
        if (title != null) {
            this.title = title;
        }
        if (author != null) {
            this.author = author;
        }
        if (isbn != null) {
            this.isbn = isbn;
        }
        if (publicationDate != null) {
            this.publicationDate = publicationDate;
        }
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public Student getBorrower() {
        return borrower;
    }

    public void setBorrower(Student borrower) {
        this.borrower = borrower;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn + ", Publication Date: " + publicationDate;
    }
}
