import java.util.*;

public class Main {
    public static void main(String[] args) {
        int nrStudenti = 10;
        List<Student> studenti = new ArrayList<Student>();
        List<Materie> materiiAn1 = new ArrayList<Materie>();
        List<Materie> materiiAn2 = new ArrayList<Materie>();
        List<Materie> materiiAn3 = new ArrayList<Materie>();

        Materie m1 = new Materie("ASC", 5);
        Materie m2 = new Materie("POO", 6);
        Materie m3 = new Materie("BD", 4);
        Materie m4 = new Materie("SD", 4);
        Materie m5 = new Materie("PA", 3);
        Materie m6 = new Materie("CDI", 6);
        Materie m7 = new Materie("Engleza", 2);
        Materie m8 = new Materie("AA", 4);
        Materie m9 = new Materie("AF", 5);

        materiiAn1.add(m1);
        materiiAn1.add(m2);
        materiiAn1.add(m3);
        materiiAn2.add(m4);
        materiiAn2.add(m5);
        materiiAn2.add(m6);
        materiiAn3.add(m7);
        materiiAn3.add(m8);
        materiiAn3.add(m9);

        List<Integer> note1 = new ArrayList<Integer>();
        note1.add(10);
        note1.add(7);
        note1.add(3);

        Student student1 = new StudentBuget(1, "Ion", 20, "0745", 151, materiiAn1, note1);
        Student student2 = new StudentBuget(2, "Vasile", 21, "0746", 251, materiiAn2, note1);
        Student student3 = new StudentBuget(3, "Gheorghe", 22, "0745", 352, materiiAn3, note1);
        Student student4 = new StudentTaxa(4, "Mihai", 20, "0746", 152, materiiAn1, note1, 2000);

        studenti.add(student1);
        studenti.add(student2);
        studenti.add(student3);
        studenti.add(student4);

        List<Integer> note2 = new ArrayList<Integer>();
        note2.add(9);
        note2.add(8);
        note2.add(10);

        Student student5 = new StudentTaxa(5, "Gheorghe", 21, "0745", 252, materiiAn2, note2, 3000);
        Student student6 = new StudentTaxa(6, "Vasile", 22, "0746", 353, materiiAn3, note2, 4000);

        studenti.add(student5);
        studenti.add(student6);

        List<Integer> note3 = new ArrayList<Integer>();
        note3.add(5);
        note3.add(3);
        note3.add(7);
        Student student7 = new StudentBuget(7, "Ion", 20, "0745", 153, materiiAn1, note3);
        Student student8 = new StudentBuget(8, "Mihai", 21, "0746", 233, materiiAn2, note3);
        Student student9 = new StudentTaxa(9, "Gheorghe", 22, "0745", 354, materiiAn3, note3, 2000);

        studenti.add(student7);
        studenti.add(student8);
        studenti.add(student9);

        List<Integer> note4 = new ArrayList<Integer>();
        note4.add(10);
        note4.add(10);
        note4.add(10);
        Student student10 = new StudentTaxa(10, "Vasile", 20, "0746", 144, materiiAn1, note4, 3000);

        studenti.add(student10);

        List<Profesor> profesori = new ArrayList<Profesor>();

        Set<Materie> materiiProfesor1 = new HashSet<Materie>();
        materiiProfesor1.add(m1);
        materiiProfesor1.add(m2);
        materiiProfesor1.add(m7);

        Set<Materie> materiiProfesor2 = new HashSet<Materie>();
        materiiProfesor2.add(m2);
        materiiProfesor2.add(m3);
        materiiProfesor2.add(m7);

        Set<Materie> materiiProfesor3 = new HashSet<Materie>();
        materiiProfesor3.add(m2);
        materiiProfesor3.add(m3);
        materiiProfesor3.add(m7);

        Set<Materie> materiiProfesor4 = new HashSet<Materie>();
        materiiProfesor4.add(m5);
        materiiProfesor4.add(m7);

        Set<Materie> materiiProfesor5 = new HashSet<Materie>();
        materiiProfesor5.add(m5);
        materiiProfesor5.add(m7);

        Set<Materie> materiiProfesor6 = new HashSet<Materie>();
        materiiProfesor6.add(m1);
        materiiProfesor6.add(m9);

        Profesor profesor1 = new Profesor(1, "Popescu", 4000, materiiProfesor1);
        Profesor profesor2 = new Profesor(2, "Ionescu", 5000, materiiProfesor2);
        Profesor profesor3 = new Profesor(3, "Georgescu", 3000, materiiProfesor3);
        Profesor profesor4 = new Laborant(4, "Vasilescu", 4000, materiiProfesor4);
        Profesor profesor5 = new Laborant(5, "Gigescu", 5000, materiiProfesor5);
        Profesor profesor6 = new Laborant(6, "Horescu", 7000, materiiProfesor6);

        profesori.add(profesor1);
        profesori.add(profesor2);
        profesori.add(profesor3);
        profesori.add(profesor4);
        profesori.add(profesor5);
        profesori.add(profesor6);

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
            }
            System.out.println(">>> Alege intrebarea dorita (sau 0 daca vreti sa iesiti din meniu): ");
            optiune = in.nextInt();
        }

    }
}