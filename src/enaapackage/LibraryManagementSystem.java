package enaapackage;


import java.util.Scanner;
public class LibraryManagementSystem {
	public static void main(String[] args) {
        Library library = new Library();
        Menu menu = new Menu(library);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            menu.displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consommer le saut de ligne
            menu.processChoice(choice);
        }
    }

}