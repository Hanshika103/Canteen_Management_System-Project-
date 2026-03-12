package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.PaymentDAO;
import model.Payment;

@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        BufferedReader reader = request.getReader();
        Gson gson = new Gson();
        JsonObject data = gson.fromJson(reader, JsonObject.class);

        String method = data.get("payment_method").getAsString();
        JsonArray items = data.getAsJsonArray("items");

        double totalAmount = 0;
        int orderId = 0; // Replace with actual orderId if available
        for (int i = 0; i < items.size(); i++) {
            JsonObject item = items.get(i).getAsJsonObject();
            double price = item.get("price").getAsDouble();
            int quantity = item.get("quantity").getAsInt();
            totalAmount += price * quantity;
        }

        // Use your existing constructor
        Payment payment = new Payment(
                0,                 // payment_id (auto-increment)
                orderId,           // order_id
                method,            // payment_method
                new Date(),        // payment_date
                BigDecimal.valueOf(totalAmount), // amount
                "Success"          // payment_status
        );

        PaymentDAO dao = new PaymentDAO();
        dao.addPayment(payment); // existing method returns void

        JsonObject res = new JsonObject();
        res.addProperty("success", true);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(res.toString());
    }
}