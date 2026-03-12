package servlet;

import java.io.IOException;
import java.util.List;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.MenuDAO;
import model.MenuItem;

@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        MenuDAO dao = new MenuDAO();
        List<MenuItem> menu = dao.getAllMenuItems(); // existing method

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new Gson().toJson(menu));
    }
}