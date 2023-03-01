package model;

public class Customer {
    private int customer_id;
    private CustomerTypeMaster customerTypeMaster;
    private String name;
    private String birthday;
    private int sex;
    private String cardid;
    private String phonenumber;
    private String email;
    private String address;

    public Customer() {
    }

    public Customer(int customer_id) {
        this.customer_id = customer_id;
    }

    public Customer(CustomerTypeMaster customerTypeMaster, String name, String birthday, int sex, String cardid, String phonenumber, String email, String address) {
        this.customerTypeMaster = customerTypeMaster;
        this.name = name;
        this.birthday = birthday;
        this.sex = sex;
        this.cardid = cardid;
        this.phonenumber = phonenumber;
        this.email = email;
        this.address = address;
    }

    public Customer(int customer_id, CustomerTypeMaster customerTypeMaster, String name, String birthday, int sex, String cardid, String phonenumber, String email, String address) {
        this.customer_id = customer_id;
        this.customerTypeMaster = customerTypeMaster;
        this.name = name;
        this.birthday = birthday;
        this.sex = sex;
        this.cardid = cardid;
        this.phonenumber = phonenumber;
        this.email = email;
        this.address = address;
    }

    public Customer(String name) {
        this.name = name;
    }

    public String isSex(){
        return sex == 0 ?  "Female" : "Male";
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public CustomerTypeMaster getCustomerTypeMaster() {
        return customerTypeMaster;
    }

    public void setCustomerTypeMaster(CustomerTypeMaster customerTypeMaster) {
        this.customerTypeMaster = customerTypeMaster;
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

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
