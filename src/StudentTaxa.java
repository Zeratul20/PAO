import java.util.List;

public class StudentTaxa extends Student implements Comparable<Student>{
    int taxa;
    public StudentTaxa(int id, String nume, int varsta, String telefon, int grupa, List<Materie> materii, List<Integer> note, int taxa) {
        super(id, nume, varsta, telefon, grupa, materii, note);
        this.taxa = taxa;
    }

    public int getTaxa() {
        return taxa;
    }

    @Override
    int puncteCredit() {
        int puncte = 0;
        for (int i = 0; i < this.materii.size(); i++) {
            int nota = this.note.get(i);
            if (nota < 5)
                continue;
            puncte += (this.materii.get(i).credite() - 1) * nota;
        }
        return puncte;
    }

    @Override
    public String toString() {
        return "StudentTaxa{" +
                "taxa=" + taxa +
                ", id=" + id +
                ", nume='" + nume + '\'' +
                ", varsta=" + varsta +
                ", telefon='" + telefon + '\'' +
                ", grupa=" + grupa +
                ", materii=" + materii +
                ", note=" + note +
                '}';
    }


    //order descending by puncteCredit() and ascending by taxa

    @Override
    public int compareTo(Student s) {
        if(this.puncteCredit() == s.puncteCredit()) {
            return this.taxa - ((StudentTaxa)s).taxa;
        }
        return s.puncteCredit() - this.puncteCredit();
    }
}
