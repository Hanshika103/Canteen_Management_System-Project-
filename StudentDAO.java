
/*import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDAO {

    // Add a new student
    public void addStudent(Student s) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "INSERT INTO Student_Details(student_name,email,password) VALUES(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getPassword());
            ps.executeUpdate();
            System.out.println("Student added successfully!");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // Validate login
    public boolean validateLogin(String email, String password) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "SELECT * FROM Student_Details WHERE email=? AND password=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}


package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Student;
import util.DBConnection;

public class StudentDAO {

    public boolean validateLogin(String email, String password) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM Student_Details WHERE email=? AND password=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void addStudent(Student s) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO Student_Details(student_name,email,password) VALUES(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getPassword());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Student getStudentById(int studentId) {
    String sql = "SELECT student_id, student_name, email FROM Student_Details WHERE student_id=?";
    try (Connection con = DBConnection.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, studentId);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Student(
                rs.getInt("student_id"),
                rs.getString("student_name"),
                rs.getString("email"),
                null // password not fetched here
            );
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}
}




package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Student;
import util.DBConnection;

public class StudentDAO {

    // Insert student and retrieve generated ID
    public void addStudent(Student s) {
        String sql = "INSERT INTO Student_Details(student_name, email, password) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getPassword());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        int generatedId = rs.getInt(1);
                        s.setStudentId(generatedId);
                        System.out.println("Student inserted successfully! Generated ID: " + generatedId);
                    }
                }
            } else {
                System.out.println("Failed to insert student.");
            }

        } catch (SQLException e) {
            System.out.println("Error inserting student into database!");
            e.printStackTrace();
        }
    }

    // Validate login
    public boolean validateLogin(String email, String password) {
        String sql = "SELECT * FROM Student_Details WHERE email=? AND password=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, email);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }

        } catch (SQLException e) {
            System.out.println("Error validating login!");
            e.printStackTrace();
            return false;
        }
    }

    // Fetch student by ID
    public Student getStudentById(int studentId) {
        String sql = "SELECT student_id, student_name, email FROM Student_Details WHERE student_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, studentId);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Student(
                        rs.getInt("student_id"),
                        rs.getString("student_name"),
                        rs.getString("email"),
                        null // password not fetched here
                    );
                }
            }

        } catch (SQLException e) {
            System.out.println("Error fetching student by ID!");
            e.printStackTrace();
        }
        return null;
    }
}
*/

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Student;
import util.DBConnection;

public class StudentDAO {

    public void addStudent(Student s) {
        String query = "INSERT INTO Student_Details(student_name, email, password) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, s.getStudentName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getPassword());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM Student_Details";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Student s = new Student(
                    rs.getInt("student_id"),
                    rs.getString("student_name"),
                    rs.getString("email"),
                    rs.getString("password")
                );
                students.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public void updateStudent(Student s) {
        String query = "UPDATE Student_Details SET student_name=?, email=?, password=? WHERE student_id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, s.getStudentName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getPassword());
            ps.setInt(4, s.getStudentId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int studentId) {
        String query = "DELETE FROM Student_Details WHERE student_id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, studentId);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
