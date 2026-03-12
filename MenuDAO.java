

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import model.MenuItem;
import util.DBConnection;

public class MenuDAO {

    public void addMenuItem(MenuItem item) {
        String query = "INSERT INTO menu_items(item_name, price, category, availability_status) VALUES (?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, item.getItemName());
            ps.setBigDecimal(2, item.getPrice());
            ps.setString(3, item.getCategory());
            ps.setString(4, item.getAvailabilityStatus());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<MenuItem> getAllMenuItems() {
        List<MenuItem> items = new ArrayList<>();
        String query = "SELECT * FROM menu_items";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                MenuItem item = new MenuItem(
                    rs.getInt("item_id"),
                    rs.getString("item_name"),
                    rs.getBigDecimal("price"),
                    rs.getString("category"),
                    rs.getString("availability_status")
                );
                items.add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    public void updateMenuItem(MenuItem item) {
        String query = "UPDATE menu_items SET item_name=?, price=?, category=?, availability_status=? WHERE item_id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, item.getItemName());
            ps.setBigDecimal(2, item.getPrice());
            ps.setString(3, item.getCategory());
            ps.setString(4, item.getAvailabilityStatus());
            ps.setInt(5, item.getItemId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMenuItem(int itemId) {
        String query = "DELETE FROM menu_items WHERE item_id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, itemId);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}