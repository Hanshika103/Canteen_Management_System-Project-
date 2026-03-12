package servlet;

import java.io.IOException;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.StudentDAO;
import model.Student;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int studentId = 1; // Replace with session-stored student_id if available
        StudentDAO dao = new StudentDAO();
        Student student = null;

        // Use your existing method to get all students
        for (Student s : dao.getAllStudents()) {
            if (s.getStudentId() == studentId) {
                student = s;
                break;
            }
        }

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new Gson().toJson(student));
    }
}