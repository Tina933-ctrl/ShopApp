package model;

public class Product {

    private int id;
    private String name;
    private String size;
    private String color;
    private String material;
    private double price;
    private int stock;

    public Product() {

    }

    public Product(int id, String name, String size, String color, String material, double price, int stock) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.color = color;
        this.material = material;
        this.price = price;
        this.stock = stock;
    }

    public Product( String name, String size, String color, String material, double price, int stock) {

        this.name = name;
        this.size = size;
        this.color = color;
        this.material = material;
        this.price = price;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public String getMaterial() {
        return material;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getFullName() {
        return name + "-" + color + "," + size + "," + material;
    }
}
