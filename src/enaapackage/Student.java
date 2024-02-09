package enaapackage;

class Student {
    private String nom;
    private String adresse;
    private String id;
    private List<Book> livresEmpruntes;

    public Student(String nom, String adresse, String id) {
        this.nom = nom;
        this.adresse = adresse;
        this.id = id;
        this.livresEmpruntes = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getId() {
        return id;
    }

    public List<Book> getLivresEmpruntes() {
        return livresEmpruntes;
    }

    public void emprunterLivre(Book livre) {
        livresEmpruntes.add(livre);
        livre.setBorrower(this);
    }

    public void retournerLivre(Book livre) {
        livresEmpruntes.remove(livre);
        livre.setBorrower(null);
    }
}
