package model;

public class Customer {
    private int id;
    private String name;
    private String birthday;
    private String address;
    private String imageUrl;

    public Customer() {
    }

    public Customer(int id, String name, String birthday, String address, String imageUrl) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.imageUrl = imageUrl;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
