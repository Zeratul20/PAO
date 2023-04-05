import java.util.Set;

public class Profesor implements Comparable<Profesor>{
    protected int id;
    protected String nume;
    protected int salariu;
    protected Set<Materie> materii;

    public Profesor(int id, String nume, int salariu, Set<Materie> materii) {
        this.id = id;
        this.nume = nume;
        this.salariu = salariu;
        this.materii = materii;
    }

    public Profesor() {
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setSalariu(int salariu) {
        this.salariu = salariu;
    }

    public String getNume() {
        return nume;
    }

    public int getSalariu() {
        return salariu;
    }

    public Set<Materie> getMaterii() {
        return materii;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", salariu=" + salariu +
                ", materii=" + materii +
                '}';
    }

    public int compareTo(Profesor prof) {
        int result = Integer.compare(prof.salariu, salariu);
        if (result == 0) {
            result = nume.compareTo(prof.nume);
        }
        return result;
    }
}
