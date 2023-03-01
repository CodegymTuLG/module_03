package model;

public class Product {
    private int productId;
    private String productName;
    private double price;
    private double discount;
    private int stock;
    private String orderDate;

    public Product() {
    }

    public Product(String productName, double price, double discount, int stock) {
        this.productName = productName;
        this.price = price;
        this.discount = discount;
        this.stock = stock;
    }

    public Product(int productId, String productName, double price, double discount, int stock) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.discount = discount;
        this.stock = stock;
    }

    public Product(int productId, String productName, double price, double discount, int stock, String orderDate) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.discount = discount;
        this.stock = stock;
        this.orderDate = orderDate;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
