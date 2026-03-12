/*package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.StudentDAO;
import model.Student;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        BufferedReader reader = request.getReader();
        Gson gson = new Gson();
        JsonObject data = gson.fromJson(reader, JsonObject.class);

        String email = data.get("email").getAsString();
        String password = data.get("password").getAsString();

        StudentDAO dao = new StudentDAO();
        Student student = null;

        // Use your existing method to get all students
        for (Student s : dao.getAllStudents()) {
            if (s.getEmail().equals(email)) {
                student = s;
                break;
            }
        }

        JsonObject res = new JsonObject();
        if (student != null && student.getPassword().equals(password)) {
            res.addProperty("success", true);
            res.addProperty("student_id", student.getStudentId());
            res.addProperty("student_name", student.getStudentName());
        } else {
            res.addProperty("success", false);
        }

      response.setContentType("application/json");
PrintWriter out = response.getWriter();

if(student != null){
    out.print("{\"success\":true,\"student_id\":"+student.getStudentId()+"}");
}else{
    out.print("{\"success\":false}");
}
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(res.toString());
    }
}
*/
package servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if(email != null && password != null) {

            if(email.equals("hanshika@gmail.com") && password.equals("123")) {

                response.sendRedirect("frontend/home.html");

            } else {

                response.getWriter().println("Invalid Email or Password");

            }

        }
    }
}