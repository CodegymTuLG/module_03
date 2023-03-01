package model;

import java.io.PrintWriter;

public class Accompaniedservice {
    private int accompaniedservice_id;
    private String accompaniedservice;
    private int price;
    private String unit;
    private String status;
    private String count;

    public Accompaniedservice() {
    }

    public Accompaniedservice(int accompaniedservice_id, String accompaniedservice, int price, String unit, String status) {
        this.accompaniedservice_id = accompaniedservice_id;
        this.accompaniedservice = accompaniedservice;
        this.price = price;
        this.unit = unit;
        this.status = status;
    }

    public Accompaniedservice(String accompaniedservice, int price, String unit, String count) {
        this.accompaniedservice = accompaniedservice;
        this.price = price;
        this.unit = unit;
        this.count = count;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public int getAccompaniedservice_id() {
        return accompaniedservice_id;
    }

    public void setAccompaniedservice_id(int accompaniedservice_id) {
        this.accompaniedservice_id = accompaniedservice_id;
    }

    public String getAccompaniedservice() {
        return accompaniedservice;
    }

    public void setAccompaniedservice(String accompaniedservice) {
        this.accompaniedservice = accompaniedservice;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
