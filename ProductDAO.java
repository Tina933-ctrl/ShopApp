package dao;

import model.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static util.DBConnection.getConnection;

public class ProductDAO {


    public void insert(Product product) {
        String sql = "INSERT INTO product (name, size, color, material, price, stock) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getSize());
            stmt.setString(3, product.getColor());
            stmt.setString(4, product.getMaterial());
            stmt.setDouble(5, product.getPrice());
            stmt.setInt(6, product.getStock());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Product product = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("size"),
                        rs.getString("color"),
                        rs.getString("material"),
                        rs.getDouble("price"),
                        rs.getInt("stock")
                );
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public Product findById(int id) {
        Product p = null;
        String sql = "SELECT * FROM product WHERE  id=?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                p = new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setSize(rs.getString("size"));
                p.setColor(rs.getString("color"));
                p.setMaterial(rs.getString("material"));
                p.setPrice(rs.getDouble("price"));
                p.setStock(rs.getInt("stock"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    public void updateProduct(Product product) {
        String sql = "UPDATE product SET name=?, size=?, color=?, material=?, price=?, stock=? WHERE id=?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, product.getName());
            ps.setString(2, product.getSize());
            ps.setString(3, product.getColor());
            ps.setString(4, product.getMaterial());
            ps.setDouble(5, product.getPrice());
            ps.setInt(6, product.getStock());
            ps.setInt(7, product.getId());
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean decreaseStock(int productId, int quantity) {
        String sql = "UPDATE product SET stock = stock - ? WHERE id = ? AND stock >=?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, quantity);
            ps.setInt(2, productId);
            ps.setInt(3, quantity);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected == 0) {
                System.out.println("Stoc insuficient pentru produsul cu ID: " + productId);
                return false;
            }

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM product WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

