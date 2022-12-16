package model;

public class Product {
    private int id;
    private String name;
    private String marker;

    public Product() {
    }

    public Product(int id, String name, String marker) {
        this.id = id;
        this.name = name;
        this.marker = marker;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarker() {
        return marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }
}
