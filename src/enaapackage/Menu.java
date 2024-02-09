package enaapackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private Library library;
    private Scanner scanner;

    public Menu(Library library) {
        this.library = library;
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Bienvenue dans la bibliothèque !");
        System.out.println("1. Ajouter un livre");
        System.out.println("2. Supprimer un livre");
        System.out.println("3. Rechercher un livre par titre");
        System.out.println("4. Rechercher un livre par auteur");
        System.out.println("5. Ajouter un étudiant");
        System.out.println("6. Supprimer un étudiant");
        System.out.println("7. Quitter");
    }

    public void runMenu() {
        while (true) {
            displayMenu();
            System.out.print("Veuillez choisir une option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    searchBookByTitle();
                    break;
                case 4:
                    searchBookByAuthor();
                    break;
                case 5:
                    addStudent();
                    break;
                case 6:
                    removeStudent();
                    break;
                case 7:
                    System.out.println("Merci d'avoir utilisé la bibliothèque ! Au revoir.");
                    return;
                default:
                    System.out.println("Option invalide. Veuillez entrer un numéro d'option valide.");
            }
        }
    }

    public void addBook() {
        System.out.print("Entrez le titre du livre: ");
        String title = scanner.nextLine();
        System.out.print("Entrez l'auteur du livre: ");
        String author = scanner.nextLine();
        System.out.print("Entrez l'ISBN du livre: ");
        String isbn = scanner.nextLine();
        System.out.print("Entrez la date de publication du livre: ");
        String publicationDate = scanner.nextLine();
        Book book = new Book(title, author, isbn, publicationDate);
        library.addBook(book);
        System.out.println("Livre ajouté avec succès.");
    }

    public void removeBook() {
        System.out.print("Entrez le titre du livre à supprimer: ");
        String title = scanner.nextLine();
        List<Book> books = library.searchBookByTitle(title);
        if (books.isEmpty()) {
            System.out.println("Aucun livre trouvé avec ce titre.");
            return;
        }
        System.out.println("Livres trouvés:");
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
        System.out.print("Entrez le numéro du livre à supprimer: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        if (choice >= 1 && choice <= books.size()) {
            library.removeBook(books.get(choice - 1));
            System.out.println("Livre supprimé avec succès.");
        } else {
            System.out.println("Choix invalide.");
        }
    }

    public void searchBookByTitle() {
        System.out.print("Entrez le titre du livre à rechercher: ");
        String title = scanner.nextLine();
        List<Book> books = library.searchBookByTitle(title);
        if (books.isEmpty()) {
            System.out.println("Aucun livre trouvé avec ce titre.");
            return;
        }
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void searchBookByAuthor() {
        System.out.print("Entrez l'auteur du livre à rechercher: ");
        String author = scanner.nextLine();
        List<Book> books = library.searchBookByAuthor(author);
        if (books.isEmpty()) {
            System.out.println("Aucun livre trouvé avec cet auteur.");
            return;
        }
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void addStudent() {
        System.out.print("Entrez le nom de l'étudiant: ");
        String name = scanner.nextLine();
        System.out.print("Entrez l'adresse de l'étudiant: ");
        String address = scanner.nextLine();
        System.out.print("Entrez l'identifiant de l'étudiant: ");
        String studentId = scanner.nextLine();
        Student student = new Student(name, address, studentId);
        library.addStudent(student);
        System.out.println("Étudiant ajouté avec succès.");
    }

    public void removeStudent() {
        System.out.print("Entrez l'identifiant de l'étudiant à supprimer: ");
        String studentId = scanner.nextLine();
        List<Student> students = new ArrayList<>();
        for (Student student : library.getStudents()) {
            if (student.getStudentId().equals(studentId)) {
                students.add(student);
            }
        }
        if (students.isEmpty()) {
            System.out.println("Aucun étudiant trouvé avec cet identifiant.");
            return;
        }
        System.out.println("Étudiants trouvés:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i));
        }
        System.out.print("Entrez le numéro de l'étudiant à supprimer: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        if (choice >= 1 && choice <= students.size()) {
            library.removeStudent(students.get(choice - 1));
            System.out.println("Étudiant supprimé avec succès.");
        } else {
            System.out.println("Choix invalide.");
        }
    }
}