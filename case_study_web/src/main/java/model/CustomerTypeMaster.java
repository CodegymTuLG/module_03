package model;

public class CustomerTypeMaster {
    private int customertype_id;
    private String type;

    public CustomerTypeMaster() {
    }

    public CustomerTypeMaster(int customertype_id) {
        this.customertype_id = customertype_id;
    }

    public CustomerTypeMaster(int customertype_id, String type) {
        this.customertype_id = customertype_id;
        this.type = type;
    }

    public int getCustomertype_id() {
        return customertype_id;
    }

    public void setCustomertype_id(int customertype_id) {
        this.customertype_id = customertype_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
