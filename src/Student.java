import java.util.List;

public abstract class Student implements Comparable<Student>{
    protected int id;
    protected String nume;
    protected int varsta;
    protected String telefon;
    protected int grupa;
    protected List<Materie> materii;

    protected List<Integer> note;

    public Student() {
    }

    public Student(int id, String nume, int varsta, String telefon, int grupa, List<Materie> materii, List<Integer> note) {
        this.id = id;
        this.nume = nume;
        this.varsta = varsta;
        this.telefon = telefon;
        this.grupa = grupa;
        this.materii = materii;
        this.note = note;
    }

    abstract int puncteCredit();

    abstract public int compareTo(Student s);

    public int calculeazaMedie() {
        int puncte = this.puncteCredit();
        int credite = 0;
        for(Materie m : materii) {
            credite += m.credite();
        }
        return puncte / credite;
    }

    public List<Materie> getMaterii() {
        return materii;
    }

    public String getNume() {
        return nume;
    }

    public int getVarsta() {
        return varsta;
    }

    public String getTelefon() {
        return telefon;
    }

    public int getGrupa() {
        return grupa;
    }

    public List<Integer> getNote() {
        return note;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public void setGrupa(int grupa) {
        this.grupa = grupa;
    }

    public void setMaterii(List<Materie> materii) {
        this.materii = materii;
    }

    public void setNote(List<Integer> note) {
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void adaugaMaterie(Materie m) {
        this.materii.add(m);
    }
}
