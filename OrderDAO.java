
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.util.Date;

import model.Order;
import util.DBConnection;

public class OrderDAO {

    public void addOrder(Order order) {
        String query = "INSERT INTO Orders(student_id, order_date, total_amount, order_status) VALUES (?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, order.getStudentId());
            ps.setTimestamp(2, new java.sql.Timestamp(order.getOrderDate().getTime()));
            ps.setBigDecimal(3, order.getTotalAmount());
            ps.setString(4, order.getOrderStatus());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        String query = "SELECT * FROM Orders";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Order o = new Order(
                    rs.getInt("order_id"),
                    rs.getInt("student_id"),
                    rs.getTimestamp("order_date"),
                    rs.getBigDecimal("total_amount"),
                    rs.getString("order_status")
                );
                orders.add(o);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public void updateOrder(Order order) {
        String query = "UPDATE Orders SET student_id=?, order_date=?, total_amount=?, order_status=? WHERE order_id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, order.getStudentId());
            ps.setTimestamp(2, new java.sql.Timestamp(order.getOrderDate().getTime()));
            ps.setBigDecimal(3, order.getTotalAmount());
            ps.setString(4, order.getOrderStatus());
            ps.setInt(5, order.getOrderId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteOrder(int orderId) {
        String query = "DELETE FROM Orders WHERE order_id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, orderId);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}