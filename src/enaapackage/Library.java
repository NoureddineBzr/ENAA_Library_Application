package enaapackage;


import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<Student> students;

    public Library() {
        this.books = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public Book searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public void displayAllBooks() {
        System.out.println("Library Catalog:");
        for (Book book : books) {
            System.out.println(book.getTitle() + " by " + book.getAuthor());
        }
    }

    public void displayAllStudents() {
        System.out.println("Students:");
        for (Student student : students) {
            System.out.println(student.getName());
        }
    }
    
    public ArrayList<Student> getStudents() {
        return students;
    }


    public void checkForOverdueBooks() {
        System.out.println("Checking for overdue books...");
        for (Student student : students) {
            for (Book book : student.getBorrowedBooks()) {
                // Assume due date is 30 days after borrowing
                // For simplicity, we'll just print a message for demonstration
                System.out.println("Reminder: Return '" + book.getTitle() + "' to the library.");
            }
        }
    }
    
    public void reserveBook(Student student, Book book) {
        if (books.contains(book) && !book.isReserved()) {
            book.setReserved(true);
            student.reserveBook(book);
            System.out.println("Book '" + book.getTitle() + "' reserved successfully.");
        } else {
            System.out.println("Book cannot be reserved.");
        }
    }
    
    public void displayReservedBooks() {
        System.out.println("Reserved Books:");
        for (Student student : students) {
            for (Book book : student.getReservedBooks()) {
                System.out.println(book.getTitle() + " by " + book.getAuthor() + " - Reserved by " + student.getName());
            }
        }
    }
}