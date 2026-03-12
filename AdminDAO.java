package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Admin;
import util.DBConnection;

public class AdminDAO {

    public void addAdmin(Admin admin) {
        String query = "INSERT INTO admin(admin_name, email, password) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, admin.getAdminName());
            ps.setString(2, admin.getEmail());
            ps.setString(3, admin.getPassword());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Admin> getAllAdmins() {
        List<Admin> admins = new ArrayList<>();
        String query = "SELECT * FROM admin";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Admin a = new Admin(
                    rs.getInt("admin_id"),
                    rs.getString("admin_name"),
                    rs.getString("email"),
                    rs.getString("password")
                );
                admins.add(a);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admins;
    }

    public void updateAdmin(Admin admin) {
        String query = "UPDATE admin SET admin_name=?, email=?, password=? WHERE admin_id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, admin.getAdminName());
            ps.setString(2, admin.getEmail());
            ps.setString(3, admin.getPassword());
            ps.setInt(4, admin.getAdminId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAdmin(int adminId) {
        String query = "DELETE FROM admin WHERE admin_id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, adminId);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
