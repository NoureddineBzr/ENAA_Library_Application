package enaapackage;

import java.util.ArrayList;

public class Student {
    private String name;
    private String address;
    private String id;
    private ArrayList<Book> borrowedBooks;
    private ArrayList<Book> reservedBooks;

    public Student(String name, String address, String id) {
        this.name = name;
        this.address = address;
        this.id = id;
        this.borrowedBooks = new ArrayList<>();
        this.reservedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
    
    public ArrayList<Book> getReservedBooks() {
        return reservedBooks;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }
    
    public void reserveBook(Book book) {
        reservedBooks.add(book);
    }

    // Other methods
}