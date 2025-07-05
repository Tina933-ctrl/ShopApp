package model;

import java.time.LocalDateTime;

public class Sale {

    private int id;
    private int customerId;
    private int productId;
    private int quantity;
    private LocalDateTime saleDate;
    private Double totalPrice;
    private String customerName;
    private String productName;


    public Sale() {

    }

    public Sale(int id, int customerId, int productId, int quantity, LocalDateTime saleDate, Double totalPrice) {
        this.id = id;
        this.customerId = customerId;
        this.productId = productId;
        this.quantity = quantity;
        this.saleDate = saleDate;
        this.totalPrice = totalPrice;

    }

    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDateTime getSaleDate() {
        return saleDate;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setSaleDate(LocalDateTime saleDate) {
        this.saleDate = saleDate;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", saleDate=" + saleDate +
                ", totalPrice=" + totalPrice +
                '}';
    }

}
