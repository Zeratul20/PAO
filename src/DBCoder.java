import java.sql.*;
import java.sql.Connection;
import java.util.*;

public class DBCoder {
    Audit audit = new Audit("C:\\Users\\Vlad Andries\\IdeaProjects\\proiect\\src\\audit.csv");
    public Connection connect() {
        Connection con;
        try {
            //Class.forName("com.postgresql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/catalog", "postgres", "1234");
            if (con != null)
                System.out.println("Connected to the database");
            else
                System.out.println("Failed to make connection!");
            return con;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createTableStudent() {
        Connection con = connect();
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS student (id serial PRIMARY KEY, nume varchar(200), varsta int, telefon varchar(200), grupa int, numeMaterii Varchar(255)[], crediteMaterii int[], note int[], taxa int)");
            stmt.close();
            con.close();
            audit.writeActionToCsv("createTableStudent");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createTableProfesor() {
        Connection con = connect();
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS profesor (id serial PRIMARY KEY, nume varchar(200), salariu int, numeMaterii Varchar(255)[], crediteMaterii int[], tip varchar(200))");
            stmt.close();
            con.close();
            audit.writeActionToCsv("createTableProfesor");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertStudentBuget(int id, String nume, int varsta, String telefon, int grupa, String[] numeMaterii, Integer[] crediteMaterii, Integer[] note) {
        Connection con = connect();
        try {
            String sql = "INSERT INTO student (id, nume, varsta, telefon, grupa, numeMaterii, crediteMaterii, note) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(2, nume);
            pstmt.setInt(3, varsta);
            pstmt.setString(4, telefon);
            pstmt.setInt(5, grupa);
            pstmt.setArray(6, con.createArrayOf("varchar", numeMaterii));
            pstmt.setArray(7, con.createArrayOf("int", crediteMaterii));
            pstmt.setArray(8, con.createArrayOf("int", note));
            pstmt.executeUpdate();

            con.close();
            audit.writeActionToCsv("insertStudentBuget");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertStudentTaxa(int id, String nume, int varsta, String telefon, int grupa, String[] numeMaterii, Integer[] crediteMaterii, Integer[] note, int taxa) {
        Connection con = connect();
        try {
            String sql = "INSERT INTO student (id, nume, varsta, telefon, grupa, numeMaterii, crediteMaterii, note, taxa) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(2, nume);
            pstmt.setInt(3, varsta);
            pstmt.setString(4, telefon);
            pstmt.setInt(5, grupa);
            pstmt.setArray(6, con.createArrayOf("varchar", numeMaterii));
            pstmt.setArray(7, con.createArrayOf("int", crediteMaterii));
            pstmt.setArray(8, con.createArrayOf("int", note));
            pstmt.setInt(9, taxa);
            pstmt.executeUpdate();

            con.close();
            audit.writeActionToCsv("insertStudentTaxa");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertProfesor(int id, String nume, int salariu, String[] numeMaterii, Integer[] crediteMaterii) {
        Connection con = connect();
        try {
            String sql = "INSERT INTO profesor (id, nume, salariu, numeMaterii, crediteMaterii, tip) VALUES (?, ?, ?, ?, ?, 'profesor')";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(2, nume);
            pstmt.setInt(3, salariu);
            pstmt.setArray(4, con.createArrayOf("varchar", numeMaterii));
            pstmt.setArray(5, con.createArrayOf("int", crediteMaterii));
//            pstmt.setString(6, tip);
            pstmt.executeUpdate();

            con.close();
            audit.writeActionToCsv("insertProfesor");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertLaborant(int id, String nume, int salariu, String[] numeMaterii, Integer[] crediteMaterii) {
        Connection con = connect();
        try {
            String sql = "INSERT INTO profesor (id, nume, salariu, numeMaterii, crediteMaterii, tip) VALUES (?, ?, ?, ?, ?, 'laborant')";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(2, nume);
            pstmt.setInt(3, salariu);
            pstmt.setArray(4, con.createArrayOf("varchar", numeMaterii));
            pstmt.setArray(5, con.createArrayOf("int", crediteMaterii));
//            pstmt.setString(6, tip);
            pstmt.executeUpdate();

            con.close();
            audit.writeActionToCsv("insertLaborant");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Student getStudentBuget(int id) {
        Connection con = connect();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM student WHERE id = " + id);
            while (rs.next()) {
                String nume = rs.getString("nume");
                int varsta = rs.getInt("varsta");
                String telefon = rs.getString("telefon");
                int grupa = rs.getInt("grupa");
                String[] numeMaterii = (String[]) rs.getArray("numeMaterii").getArray();
                Integer[] crediteMaterii = (Integer[]) rs.getArray("crediteMaterii").getArray();
                List<Materie> materii= new ArrayList<>();

                for (int i = 0; i < numeMaterii.length; i++) {
                    materii.add(new Materie(numeMaterii[i], crediteMaterii[i]));
                }

                Integer[] noteRaw = (Integer[]) rs.getArray("note").getArray();

                List<Integer> note = new ArrayList<>();

                for (Integer nota : noteRaw) {
                    note.add(nota);
                }

                return new StudentBuget(id, nume, varsta, telefon, grupa, materii, note);

            }
            stmt.close();
            con.close();
            audit.writeActionToCsv("getStudentBuget");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return new StudentBuget();
    }

    public Student getStudentTaxa(int id) {
        Connection con = connect();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM student WHERE id = " + id);
            while (rs.next()) {
                String nume = rs.getString("nume");
                int varsta = rs.getInt("varsta");
                String telefon = rs.getString("telefon");
                int grupa = rs.getInt("grupa");
                String[] numeMaterii = (String[]) rs.getArray("numeMaterii").getArray();
                Integer[] crediteMaterii = (Integer[]) rs.getArray("crediteMaterii").getArray();
                List<Materie> materii= new ArrayList<>();

                for (int i = 0; i < numeMaterii.length; i++) {
                    materii.add(new Materie(numeMaterii[i], crediteMaterii[i]));
                }

                Integer[] noteRaw = (Integer[]) rs.getArray("note").getArray();

                List<Integer> note = new ArrayList<>();

                for (Integer nota : noteRaw) {
                    note.add(nota);
                }

                int taxa = rs.getInt("taxa");

                return new StudentTaxa(id, nume, varsta, telefon, grupa, materii, note, taxa);

            }
            stmt.close();
            con.close();
            audit.writeActionToCsv("getStudentTaxa");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return new StudentTaxa();
    }

    public Profesor getProfesor(int id) {
        Connection con = connect();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM profesor WHERE id = " + id);
            while (rs.next()) {
                String nume = rs.getString("nume");
                int salariu = rs.getInt("salariu");
                String[] numeMaterii = (String[]) rs.getArray("numeMaterii").getArray();
                Integer[] crediteMaterii = (Integer[]) rs.getArray("crediteMaterii").getArray();
                Set<Materie> materii= new HashSet<>();

                for (int i = 0; i < numeMaterii.length; i++) {
                    materii.add(new Materie(numeMaterii[i], crediteMaterii[i]));
                }

                return new Profesor(id, nume, salariu, materii);

            }
            stmt.close();
            con.close();
            audit.writeActionToCsv("getProfesor");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return new Profesor();
    }

    public Profesor getLaborant(int id) {
        Connection con = connect();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM profesor WHERE id = " + id);
            while (rs.next()) {
                String nume = rs.getString("nume");
                int salariu = rs.getInt("salariu");
                String[] numeMaterii = (String[]) rs.getArray("numeMaterii").getArray();
                Integer[] crediteMaterii = (Integer[]) rs.getArray("crediteMaterii").getArray();
                Set<Materie> materii= new HashSet<>();

                for (int i = 0; i < numeMaterii.length; i++) {
                    materii.add(new Materie(numeMaterii[i], crediteMaterii[i]));
                }

                return new Laborant(id, nume, salariu, materii);

            }
            stmt.close();
            con.close();
            audit.writeActionToCsv("getLaborant");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return new Laborant();
    }

    public void updateStudent(int id, String nume) {
        Connection con = connect();
        try {
            String sql = "UPDATE student SET nume = ? WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, nume);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();

            con.close();
            audit.writeActionToCsv("updateStudent");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteProfesor(int id) {
        Connection con = connect();
        try {
            String sql = "DELETE FROM profesor WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

            con.close();
            audit.writeActionToCsv("deleteProfesor");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Student> getStudenti() {
        Connection con = connect();
        try {
            List<Student> studenti = new ArrayList<>();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM student");
            while (rs.next()) {
                int id = rs.getInt("id");
                String nume = rs.getString("nume");
                int varsta = rs.getInt("varsta");
                String telefon = rs.getString("telefon");
                int grupa = rs.getInt("grupa");
                String[] numeMaterii = (String[]) rs.getArray("numeMaterii").getArray();
                Integer[] crediteMaterii = (Integer[]) rs.getArray("crediteMaterii").getArray();
                List<Materie> materii= new ArrayList<>();

                for (int i = 0; i < numeMaterii.length; i++) {
                    materii.add(new Materie(numeMaterii[i], crediteMaterii[i]));
                }

                Integer[] noteRaw = (Integer[]) rs.getArray("note").getArray();

                List<Integer> note = new ArrayList<>();

                Collections.addAll(note, noteRaw);

                int taxa = rs.getInt("taxa");

                if(taxa != 0)
                    studenti.add(new StudentTaxa(id, nume, varsta, telefon, grupa, materii, note, taxa));
                else
                    studenti.add(new StudentBuget(id, nume, varsta, telefon, grupa, materii, note));
            }
            stmt.close();
            con.close();
            audit.writeActionToCsv("getStudenti");
            return studenti;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Profesor> getProfesori() {
        Connection con = connect();
        try {
            List<Profesor> profesori = new ArrayList<>();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM profesor");
            while (rs.next()) {
                int id = rs.getInt("id");
                String nume = rs.getString("nume");
                int salariu = rs.getInt("salariu");
                String[] numeMaterii = (String[]) rs.getArray("numeMaterii").getArray();
                Integer[] crediteMaterii = (Integer[]) rs.getArray("crediteMaterii").getArray();
                Set<Materie> materii= new HashSet<>();

                for (int i = 0; i < numeMaterii.length; i++) {
                    materii.add(new Materie(numeMaterii[i], crediteMaterii[i]));
                }

                String tip = rs.getString("tip");

                if(tip.equals("laborant"))
                    profesori.add(new Laborant(id, nume, salariu, materii));
                else if(tip.equals("profesor"))
                    profesori.add(new Profesor(id, nume, salariu, materii));
            }
            stmt.close();
            con.close();
            audit.writeActionToCsv("getProfesori");
            return profesori;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}