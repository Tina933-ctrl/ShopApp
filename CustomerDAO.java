package dao;

import model.Customer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static util.DBConnection.getConnection;

public class CustomerDAO {

    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM customer";

        try (Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Customer c = new Customer();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setEmail(rs.getString("email"));
                c.setPhone(rs.getString("phone"));
                c.setAddress(rs.getString("address"));
                c.setTotalSpent(rs.getDouble("total_spent"));
                customers.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public void insertCustomer(Customer customer) {
        String sql = "INSERT INTO customer(name, email, phone, address, total_spent) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, customer.getName());
            ps.setString(2, customer.getEmail());
            ps.setString(3, customer.getPhone());
            ps.setString(4, customer.getAddress());
            ps.setDouble(5, customer.getTotalSpent() != null ? customer.getTotalSpent() : 0.0);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Customer findById(int id) {
        Customer customer = null;
        String sql = "SELECT * FROM customer WHERE id=?";

        try (Connection conn =getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setEmail(rs.getString("email"));
                customer.setPhone(rs.getString("phone"));
                customer.setAddress(rs.getString("address"));
                customer.setTotalSpent(rs.getDouble("total_spent"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }


    public void updateCustomer(Customer customer) {

        String sql = "UPDATE customer SET name=?, email=?, phone=?, address=?, total_spent=? WHERE id=?";

        try (Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, customer.getName());
            ps.setString(2, customer.getEmail());
            ps.setString(3, customer.getPhone());
            ps.setString(4, customer.getAddress());
            ps.setDouble(5, customer.getTotalSpent());
            ps.setInt(6, customer.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean updateTotalSpent(int customerId, double amount) {
        String sql = "UPDATE customer SET total_spent = total_spent + ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDouble(1, amount);
            ps.setInt(2, customerId);
            int rowsAffected = ps.executeUpdate();

            return rowsAffected > 0; //  return true dacă s-a modificat ceva

        } catch (SQLException e) {
            e.printStackTrace();
            return false; //  în caz de eroare
        }
    }



    public void deleteCustomer(int id) {
        String sql = "DELETE FROM customer WHERE id = ?";

        try (Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
