import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Service {
    public static void case1(List<Student> studenti) {
        Collections.sort(studenti);
        for (Student student : studenti) {
            System.out.println(student);
        }
    }

    public static void case2(List<Profesor>profesori) {
        for (Profesor profesor : profesori) {
            System.out.println(profesor);
        }
    }

    public static void case3(List<Student>studenti) {
        for (Student student : studenti)
            if (student.calculeazaMedie() > 5) {
                System.out.println(student);
            }
    }

    public static void case4(List<Student>studenti) {
        for (Student student : studenti) {
            if (student.calculeazaMedie() > 5 && student instanceof StudentBuget) {
                System.out.println(student);
            }
        }
    }

    public static void case5(List<Student>studenti) {
        List<StudentTaxa> studentiTaxa = new ArrayList<StudentTaxa>();
        for (Student student : studenti) {
            if (student.calculeazaMedie() > 5 && student instanceof StudentTaxa) {
                studentiTaxa.add((StudentTaxa) student);
            }
        }
        studentiTaxa.sort((s1, s2) -> s1.getTaxa() - s2.getTaxa());

        for (StudentTaxa studentTaxa : studentiTaxa) {
            System.out.println(studentTaxa);
        }
    }

    public static void case6(List<Profesor>profesori) {
        Scanner input = new Scanner(System.in);
        System.out.println(">>> Introduceti salariul: ");
        int salariu = input.nextInt();
        List<Profesor> profesoriSalariu = new ArrayList<Profesor>();
        for (Profesor profesor : profesori) {
            if (profesor.getSalariu() > salariu) {
                profesoriSalariu.add(profesor);
            }
        }
        profesoriSalariu.sort((p1, p2) -> p2.getSalariu() - p1.getSalariu());
        for (Profesor profesor : profesoriSalariu) {
            System.out.println(profesor);
        }
    }

    public static void case7(List<Profesor>profesori, List<Student>studenti) {
        List<Profesor> profesoriMaterii = new ArrayList<Profesor>();
        for (Profesor profesor : profesori) {
            for (Student student : studenti) {
                if (profesor.getMaterii().containsAll(student.getMaterii())) {
                    profesoriMaterii.add(profesor);
                }
            }
        }
        profesori.removeAll(profesoriMaterii);
        for (Profesor profesor : profesori) {
            System.out.println(profesor);
        }
    }

    public static void case8(List<Student>studenti) {
        int sumaTaxe = 0;
        for (Student student : studenti) {
            if (student instanceof StudentTaxa) {
                sumaTaxe += ((StudentTaxa) student).getTaxa();
            }
        }
        System.out.println("Suma taxelor studentilor care sunt repartizati la taxa este: " + sumaTaxe);
    }

    public static void case9(List<Student>studenti) {
        Scanner input = new Scanner(System.in);
        System.out.println(">>> Introduceti id-ul studentului: ");
        int id = input.nextInt();
        System.out.println(">>> Introduceti noul nume: ");
        String nume = input.next();
        for (Student student : studenti) {
            if (student.getId() == id) {
                student.setNume(nume);
            }
        }
        for (Student student : studenti) {
            System.out.println(student);
        }
    }

    public static void case10(List<Student>studenti) {
        double medieStudenti = 0;
        for (Student student : studenti) {
            medieStudenti += student.calculeazaMedie();
        }
        medieStudenti /= studenti.size();
        for (Student student : studenti) {
            if (student.calculeazaMedie() > medieStudenti) {
                System.out.println(student);
            }
        }
    }
}
