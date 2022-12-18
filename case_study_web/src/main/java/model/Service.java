package model;

public class Service {
    private int service_id;
    private String name;
    private int area;
    private int rentprice;
    private int maxperson;
    private int renttype_id;
    private int servicetype_id;
    private String standar;
    private String other_service_description;
    private double pool_area;
    private int floor;
    private String free_service;

    public Service() {
    }

    public Service(int service_id, String name, int area, int rentprice, int maxperson, int renttype_id, int servicetype_id, String standar, String other_service_description, double pool_area, int floor, String free_service) {
        this.service_id = service_id;
        this.name = name;
        this.area = area;
        this.rentprice = rentprice;
        this.maxperson = maxperson;
        this.renttype_id = renttype_id;
        this.servicetype_id = servicetype_id;
        this.standar = standar;
        this.other_service_description = other_service_description;
        this.pool_area = pool_area;
        this.floor = floor;
        this.free_service = free_service;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getRentprice() {
        return rentprice;
    }

    public void setRentprice(int rentprice) {
        this.rentprice = rentprice;
    }

    public int getMaxperson() {
        return maxperson;
    }

    public void setMaxperson(int maxperson) {
        this.maxperson = maxperson;
    }

    public int getRenttype_id() {
        return renttype_id;
    }

    public void setRenttype_id(int renttype_id) {
        this.renttype_id = renttype_id;
    }

    public int getServicetype_id() {
        return servicetype_id;
    }

    public void setServicetype_id(int servicetype_id) {
        this.servicetype_id = servicetype_id;
    }

    public String getStandar() {
        return standar;
    }

    public void setStandar(String standar) {
        this.standar = standar;
    }

    public String getOther_service_description() {
        return other_service_description;
    }

    public void setOther_service_description(String other_service_description) {
        this.other_service_description = other_service_description;
    }

    public double getPool_area() {
        return pool_area;
    }

    public void setPool_area(double pool_area) {
        this.pool_area = pool_area;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getFree_service() {
        return free_service;
    }

    public void setFree_service(String free_service) {
        this.free_service = free_service;
    }
}
