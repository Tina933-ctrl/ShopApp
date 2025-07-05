package dao;

import model.Sale;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static util.DBConnection.getConnection;

public class SaleDAO {

    public void insertSale(Sale sale) {

        String sql = "INSERT INTO sale (customer_id, product_id, quantity, sale_date, total_price) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, sale.getCustomerId());
            ps.setInt(2, sale.getProductId());
            ps.setInt(3, sale.getQuantity());
            ps.setTimestamp(4, Timestamp.valueOf(sale.getSaleDate()));
            ps.setDouble(5, sale.getTotalPrice());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Sale> getAllSales() {

       List<Sale> sales = new ArrayList<>();
       String sql = "SELECT sale.*, customer.name AS customer_name, " +
                "product.name AS product_name, product.color, product.size, product.material " +
                "FROM sale " +
                "JOIN customer ON sale.customer_id = customer.id " +
                "JOIN product ON sale.product_id = product.id";


       try (Connection conn = getConnection();
            Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

           while(rs.next()) {
               Sale s = new Sale();
               s.setId(rs.getInt("id"));
               s.setCustomerId(rs.getInt("customer_id"));
               s.setProductId(rs.getInt("product_id"));
               s.setQuantity(rs.getInt("quantity"));
               s.setSaleDate(rs.getTimestamp("sale_date").toLocalDateTime());
               s.setTotalPrice(rs.getDouble("total_price"));

               s.setCustomerName(rs.getString("customer_name"));

               String fullProductName = rs.getString("product_name") + " - " +
                                        rs.getString("color") + ", " +
                                        rs.getString("size") + ", " +
                                        rs.getString("material");

               s.setProductName(fullProductName);

               sales.add(s);
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return sales;
    }


    public void deleteSale(int id) {

        String sql = "DELETE FROM sale WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
     }

    public boolean processSale(Sale sale) {
        String checkSql = "SELECT stock, price FROM product WHERE id = ?";
        String insertSaleSql = "INSERT INTO sale (customer_id, product_id, quantity, sale_date, total_price) VALUES (?, ?, ?, ?, ?)";
        String updateStockSql = "UPDATE product SET stock = stock - ? WHERE id = ? AND stock >= ?";
        String updateCustomerSql = "UPDATE customer SET total_spent = total_spent + ? WHERE id = ?";

        try (Connection conn = getConnection()) {
            conn.setAutoCommit(false);

            int stock = 0;
            double unitPrice = 0.0;

            // 1. Verifică stoc și preț
            try (PreparedStatement ps = conn.prepareStatement(checkSql)) {
                ps.setInt(1, sale.getProductId());
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    stock = rs.getInt("stock");
                    unitPrice = rs.getDouble("price");
                } else {
                    System.out.println("Produsul nu există.");
                    conn.rollback();
                    return false;
                }
            }

            if (stock < sale.getQuantity()) {
                System.out.println("Stoc insuficient.");
                conn.rollback();
                return false;
            }

            double totalPrice = Math.round(unitPrice * sale.getQuantity() * 100.0)/100.0;
            sale.setTotalPrice(totalPrice);

            // 2. Inserează în `sale`
            try (PreparedStatement ps = conn.prepareStatement(insertSaleSql)) {
                ps.setInt(1, sale.getCustomerId());
                ps.setInt(2, sale.getProductId());
                ps.setInt(3, sale.getQuantity());
                ps.setTimestamp(4, Timestamp.valueOf(sale.getSaleDate()));
                ps.setDouble(5, totalPrice);
                ps.executeUpdate();
            }

            // 3. Actualizează stocul
            try (PreparedStatement ps = conn.prepareStatement(updateStockSql)) {
                ps.setInt(1, sale.getQuantity());
                ps.setInt(2, sale.getProductId());
                ps.setInt(3, sale.getQuantity());
                int affected = ps.executeUpdate();
                if (affected == 0) {
                    System.out.println("Eroare la actualizarea stocului.");
                    conn.rollback();
                    return false;
                }
            }

            // 4. Actualizează totalul cheltuit de client
            try (PreparedStatement ps = conn.prepareStatement(updateCustomerSql)) {
                ps.setDouble(1, totalPrice);
                ps.setInt(2, sale.getCustomerId());
                ps.executeUpdate();
            }

            conn.commit();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
