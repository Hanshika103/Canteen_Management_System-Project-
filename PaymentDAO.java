

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.util.Date;

import model.Payment;
import util.DBConnection;

public class PaymentDAO {

    public void addPayment(Payment payment) {
        String query = "INSERT INTO payment(order_id, payment_method, payment_date, amount, payment_status) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, payment.getOrderId());
            ps.setString(2, payment.getPaymentMethod());
            ps.setTimestamp(3, new java.sql.Timestamp(payment.getPaymentDate().getTime()));
            ps.setBigDecimal(4, payment.getAmount());
            ps.setString(5, payment.getPaymentStatus());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Payment> getAllPayments() {
        List<Payment> payments = new ArrayList<>();
        String query = "SELECT * FROM payment";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Payment p = new Payment(
                    rs.getInt("payment_id"),
                    rs.getInt("order_id"),
                    rs.getString("payment_method"),
                    rs.getTimestamp("payment_date"),
                    rs.getBigDecimal("amount"),
                    rs.getString("payment_status")
                );
                payments.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payments;
    }

    public void updatePayment(Payment payment) {
        String query = "UPDATE payment SET order_id=?, payment_method=?, payment_date=?, amount=?, payment_status=? WHERE payment_id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, payment.getOrderId());
            ps.setString(2, payment.getPaymentMethod());
            ps.setTimestamp(3, new java.sql.Timestamp(payment.getPaymentDate().getTime()));
            ps.setBigDecimal(4, payment.getAmount());
            ps.setString(5, payment.getPaymentStatus());
            ps.setInt(6, payment.getPaymentId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePayment(int paymentId) {
        String query = "DELETE FROM payment WHERE payment_id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, paymentId);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}