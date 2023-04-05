import java.util.Set;

public class Laborant extends Profesor{
    public Laborant(int id, String nume, int salariu, Set<Materie> materii) {
        super(id, nume, salariu / 2, materii);
    }

    public Laborant() {
    }

    @Override
    public String toString() {
        return "Laborant{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", salariu=" + salariu +
                ", materii=" + materii +
                '}';
    }
}
