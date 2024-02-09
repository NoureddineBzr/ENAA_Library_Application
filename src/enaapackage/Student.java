package enaapackage;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Student {
    private String name;
    private String address;
    private String studentId;
    private List<Book> borrowedBooks;

    public Student(String name, String address, String studentId) {
        this.name = name;
        this.address = address;
        this.studentId = studentId;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getStudentId() {
        return studentId;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Address: " + address + ", Student ID: " + studentId;
    }
}





