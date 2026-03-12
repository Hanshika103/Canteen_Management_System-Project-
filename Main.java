package app;
import dao.StudentDAO;
import model.Student;

public class Main {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        Student s = new Student(9, "Durgs", "durga@gmail.com", "111");
        dao.addStudent(s);
        System.out.println("Student inserted successfully!");
    }
}
