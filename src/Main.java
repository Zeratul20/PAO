import java.sql.Connection;
import java.util.*;

public class Main {
    Audit audit = new Audit("C:\\Users\\Vlad Andries\\IdeaProjects\\proiect\\src\\audit.csv");

    public static void main(String[] args) {

        DBCoder dbCoder = new DBCoder();
        Connection con = dbCoder.connect();

        dbCoder.createTableStudent();

        String[] numeMateriiAn1 = {"ASC", "POO", "BD"};
        Integer[] credite1 = {5, 6, 4};
        Integer[] note10 = {10, 7, 3};
        Integer[] note11 = {9, 8, 10};
        Integer[] note12 = {5, 3, 7};

        String[] numeMateriiAn2 = {"SD", "PA", "CDI"};
        Integer[] credite2 = {4, 3, 6};
        Integer[] note13 = {10, 10, 10};

        String[] numeMateriiAn3 = {"Engleza", "AA", "AF"};
        Integer[] credite3 = {2, 4, 5};


//        dbCoder.insertStudentBuget(1, "Ion", 20, "0745", 151, numeMateriiAn1, credite1, note10);
//        dbCoder.insertStudentBuget(2, "Vasile", 20, "0746", 252, numeMateriiAn2, credite2, note10);
//        dbCoder.insertStudentBuget(3, "Gheorghe", 21, "0745", 351, numeMateriiAn3, credite3, note10);
//        dbCoder.insertStudentTaxa(4, "Ion", 20, "0745", 152, numeMateriiAn1, credite1, note10, 2000);
//        dbCoder.insertStudentTaxa(5, "Vasile", 20, "0746", 252, numeMateriiAn2, credite2, note11, 3000);
//        dbCoder.insertStudentTaxa(6, "Gheorghe", 21, "0745", 353, numeMateriiAn3, credite3, note11, 4000);
//        dbCoder.insertStudentBuget(7, "Ion", 20, "0745", 153, numeMateriiAn1, credite1, note12);
//        dbCoder.insertStudentBuget(8, "Vasile", 20, "0746", 233, numeMateriiAn2, credite2, note12);
//        dbCoder.insertStudentTaxa(9, "Gheorghe", 21, "0745", 353, numeMateriiAn3, credite3, note12, 2000);
//        dbCoder.insertStudentTaxa(10, "Ion", 20, "0745", 154, numeMateriiAn1, credite1, note13, 3000);

        dbCoder.createTableProfesor();

        // m1 m2 m7
        String[] numeMateriiProf1 = {"ASC", "POO", "Engleza"};
        Integer[] crediteProf1 = {5, 6, 2};
        // m2 m3 m7
        String[] numeMateriiProf2 = {"POO", "BD", "Engleza"};
        Integer[] crediteProf2 = {6, 4, 2};
        // m2 m3 m7
        String[] numeMateriiProf3 = {"POO", "BD", "Engleza"};
        Integer[] crediteProf3 = {6, 4, 2};
        // m5 m7
        String[] numeMateriiProf4 = {"PA", "Engleza"};
        Integer[] crediteProf4 = {3, 2};
        // m5 m7
        String[] numeMateriiProf5 = {"PA", "Engleza"};
        Integer[] crediteProf5 = {3, 2};
        // m1 m9
        String[] numeMateriiProf6 = {"ASC", "AF"};
        Integer[] crediteProf6 = {5, 5};

//        dbCoder.insertProfesor(1, "Popescu", 4000, numeMateriiProf1, crediteProf1);
//        dbCoder.insertProfesor(2, "Ionescu", 5000, numeMateriiProf2, crediteProf2);
//        dbCoder.insertProfesor(3, "Georgescu", 3000, numeMateriiProf3, crediteProf3);
//        dbCoder.insertLaborant(4, "Vasilescu", 4000, numeMateriiProf4, crediteProf4);
//        dbCoder.insertLaborant(5, "Gigescu", 5000, numeMateriiProf5, crediteProf5);
//        dbCoder.insertLaborant(6, "Horescu", 7000, numeMateriiProf6, crediteProf6);


        Student student11 = dbCoder.getStudentBuget(1);
        Student student12 = dbCoder.getStudentBuget(2);
        Student student13 = dbCoder.getStudentBuget(3);
        Student student14 = dbCoder.getStudentTaxa(4);
        Student student15 = dbCoder.getStudentTaxa(5);
        Student student16 = dbCoder.getStudentTaxa(6);
        Student student17 = dbCoder.getStudentBuget(7);
        Student student18 = dbCoder.getStudentBuget(8);
        Student student19 = dbCoder.getStudentTaxa(9);
        Student student20 = dbCoder.getStudentTaxa(10);

        List<Student> studenti = new ArrayList<>();

        studenti.add(student11);
        studenti.add(student12);
        studenti.add(student13);
        studenti.add(student14);
        studenti.add(student15);
        studenti.add(student16);
        studenti.add(student17);
        studenti.add(student18);
        studenti.add(student19);
        studenti.add(student20);

        Profesor profesor11 = dbCoder.getProfesor(1);
        Profesor profesor12 = dbCoder.getProfesor(2);
        Profesor profesor13 = dbCoder.getProfesor(3);
        Profesor profesor14 = dbCoder.getLaborant(4);
        Profesor profesor15 = dbCoder.getLaborant(5);
        Profesor profesor16 = dbCoder.getLaborant(6);

        List<Profesor> profesori = new ArrayList<>();

        profesori.add(profesor11);
        profesori.add(profesor12);
        profesori.add(profesor13);
        profesori.add(profesor14);
        profesori.add(profesor15);
        profesori.add(profesor16);


        System.out.println(">>> Variantele pentru care doriti sa afisati datele: ");

        System.out.println("1. Afisare studenti sortati in functie de punctele de credit");
        System.out.println("2. Afisare profesori");
        System.out.println("3. Afisare studenti cu media mai mare decat 5");
        System.out.println("4. Afisare studenti cu media mai mare decat 5 si care sunt repartizati la buget");
        System.out.println("5. Afisare studenti cu media mai mare decat 5 si care sunt repartizati la taxa, precum si taxa, ordonati crescator dupa taxa");
        System.out.println("6. Afisare profesori care au salariul mai mare de x lei (x de la tastatura) in ordinea descrescatoare a salariului");
        System.out.println("7. Afisare profesori care nu au nicio materie in comun cu vreun student");
        System.out.println("8. Afisare suma taxelor studentilor care sunt repartizati la taxa");
        System.out.println("9. Schimbati numele unui student cu id-ul dat de la tastatura");
        System.out.println("10. Afisati studentii care au media mai mare decat media tuturor studentilor");
        System.out.println("11. Actualizati numele unui student cu id-ul dat de la tastatura");
        System.out.println("12. Stergeti un profesor cu id-ul dat de la tastatura");

        System.out.println(">>> Alege intrebarea dorita (sau 0 daca vreti sa iesiti din meniu): ");
        Scanner in = new Scanner(System.in);
        int optiune = in.nextInt();
        while (optiune != 0) {
            switch (optiune) {
                case 1 -> Service.case1(studenti);
                case 2 -> Service.case2(profesori);
                case 3 -> Service.case3(studenti);
                case 4 -> Service.case4(studenti);
                case 5 -> Service.case5(studenti);
                case 6 -> Service.case6(profesori);
                case 7 -> Service.case7(profesori, studenti);
                case 8 -> Service.case8(studenti);
                case 9 -> Service.case9(studenti);
                case 10 -> Service.case10(studenti);
                case 11 -> {
                    System.out.println(">>> Introduceti id-ul studentului pe care doriti sa il actualizati: ");
                    int id = in.nextInt();
                    System.out.println(">>> Introduceti noul nume al studentului: ");
                    String nume = in.next();
                    dbCoder.updateStudent(id, nume);
                    studenti = dbCoder.getStudenti();
                }
                case 12 -> {
                    System.out.println(">>> Introduceti id-ul profesorului pe care doriti sa il stergeti: ");
                    int id = in.nextInt();
                    dbCoder.deleteProfesor(id);
                    profesori = dbCoder.getProfesori();
                }
            }
            System.out.println(">>> Alege intrebarea dorita (sau 0 daca vreti sa iesiti din meniu): ");
            optiune = in.nextInt();
        }

    }

}