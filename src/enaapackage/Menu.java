package enaapackage;


import java.util.ArrayList;
import java.util.Scanner;


public class Menu {
    private Library library;
    private Scanner scanner;

    public Menu(Library library) {
        this.library = library;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("\nMenu du Système de Gestion de Bibliothèque :");
        System.out.println("1. Ajouter un Livre");
        System.out.println("2. Supprimer un Livre");
        System.out.println("3. Rechercher un Livre");
        System.out.println("4. Afficher Tous les Livres");
        System.out.println("5. Ajouter un Étudiant");
        System.out.println("6. Supprimer un Étudiant");
        System.out.println("7. Afficher Tous les Étudiants");
        System.out.println("8. Vérifier les Livres en Retard");
        System.out.println("9. Réserver un Livre");
        System.out.println("10. Afficher les Livres Réservés");
        System.out.println("11. Quitter");
        System.out.print("Entrez votre choix : ");
    }

    public void processChoice(int choice) {
        switch (choice) {
            case 1:
                addBook();
                break;
            case 2:
                removeBook();
                break;
            case 3:
                searchBook();
                break;
            case 4:
                library.displayAllBooks();
                break;
            case 5:
                addStudent();
                break;
            case 6:
                removeStudent();
                break;
            case 7:
                library.displayAllStudents();
                break;
            case 8:
                library.checkForOverdueBooks();
                break;
            case 9:
                reserveBook();
                break;
            case 10:
                library.displayReservedBooks();
                break;
            case 11:
                System.out.println("Exiting...");
                System.exit(0);
            default:
                System.out.println("Choix invalide");
        }
    }

    private void addBook() {
        System.out.println("Entrez les détails du livre :");
        System.out.print("Titre : ");
        String title = scanner.nextLine();
        System.out.print("Auteur : ");
        String author = scanner.nextLine();
        System.out.print("ISBN : ");
        String isbn = scanner.nextLine();
        System.out.print("Date de publication : ");
        String publicationDate = scanner.nextLine();
        Book book = new Book(title, author, isbn, publicationDate);
        library.addBook(book);
        System.out.println("Livre ajouté avec succès.");
    }

    private void removeBook() {
        System.out.println("Entrez le titre du livre à supprimer :");
        String title = scanner.nextLine();
        Book book = library.searchBook(title);
        if (book != null) {
            library.removeBook(book);
            System.out.println("Livre supprimé avec succès.");
        } else {
            System.out.println("Livre non trouvé.");
        }
    }

    private void searchBook() {
        System.out.println("Entrez le titre du livre à rechercher :");
        String title = scanner.nextLine();
        Book book = library.searchBook(title);
        if (book != null) {
            System.out.println("Livre trouvé :");
            System.out.println("Titre : " + book.getTitle());
            System.out.println("Auteur : " + book.getAuthor());
            // Ajouter plus de détails si nécessaire
        } else {
            System.out.println("Livre non trouvé.");
        }
    }

    private void addStudent() {
        System.out.println("Entrez les détails de l'étudiant :");
        System.out.print("Nom : ");
        String name = scanner.nextLine();
        System.out.print("Adresse : ");
        String address = scanner.nextLine();
        System.out.print("ID : ");
        String id = scanner.nextLine();
        Student student = new Student(name, address, id);
        library.addStudent(student);
        System.out.println("Étudiant ajouté avec succès.");
    }

    private void removeStudent() {
        System.out.println("Entrez le nom de l'étudiant à supprimer :");
        String name = scanner.nextLine();
        // Implémenter la logique de suppression
        System.out.println("Étudiant supprimé avec succès.");
    }
    
    private void reserveBook() {
        System.out.println("Entrez le titre du livre à réserver :");
        String title = scanner.nextLine();
        Book book = library.searchBook(title);
        if (book != null) {
            System.out.print("Entrez le nom de l'étudiant : ");
            String studentName = scanner.nextLine();
            Student student = null;
            for (Student s : library.getStudents()) {
                if (s.getName().equalsIgnoreCase(studentName)) {
                    student = s;
                    break;
                }
            }
            if (student != null) {
                library.reserveBook(student, book);
            } else {
                System.out.println("Étudiant non trouvé.");
            }
        } else {
            System.out.println("Livre non trouvé.");
        }
    }

}