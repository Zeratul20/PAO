import java.util.List;

public class StudentBuget extends Student {
    public StudentBuget(int id, String nume, int varsta, String telefon, int grupa, List<Materie> materii, List<Integer> note) {
        super(id, nume, varsta, telefon, grupa, materii, note);
    }

    public StudentBuget() {
    }

    @Override
    int puncteCredit() {
        int puncte = 0;
        for(int i = 0; i < this.materii.size(); i++) {
            int nota = this.note.get(i);
            if(nota < 5)
                continue;
            puncte += this.materii.get(i).credite() * nota;
        }
        return puncte;
    }

    @Override
    public String toString() {
        return "StudentBuget{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", varsta=" + varsta +
                ", telefon='" + telefon + '\'' +
                ", grupa=" + grupa +
                ", materii=" + materii +
                ", note=" + note +
                '}';
    }

    @Override
    public int compareTo(Student s) {
        return this.puncteCredit() - s.puncteCredit();
    }
}
