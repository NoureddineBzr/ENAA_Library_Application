package enaapackage;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Menu menu = new Menu(library);
        menu.runMenu();
    }
}
