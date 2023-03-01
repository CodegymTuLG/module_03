package model;

public class Employee {
    private int employee_id;
    private String name;
    private String birthday;
    private String cardid;
    private double salary;
    private String phonenumber;
    private String email;
    private String address;
    PositionMaster positionMaster;
    LevelMaster levelMaster;
    WorkPartMaster workPartMaster;

    public Employee() {
    }

    public Employee(int employee_id) {
        this.employee_id = employee_id;
    }

    public Employee(int employee_id, String name, String birthday, String cardid, double salary, String phonenumber, String email, String address, PositionMaster positionMaster, LevelMaster levelMaster, WorkPartMaster workPartMaster) {
        this.employee_id = employee_id;
        this.name = name;
        this.birthday = birthday;
        this.cardid = cardid;
        this.salary = salary;
        this.phonenumber = phonenumber;
        this.email = email;
        this.address = address;
        this.positionMaster = positionMaster;
        this.levelMaster = levelMaster;
        this.workPartMaster = workPartMaster;
    }

    public Employee(String name, String birthday, String cardid, double salary, String phonenumber, String email, String address, PositionMaster positionMaster, LevelMaster levelMaster, WorkPartMaster workPartMaster) {
        this.name = name;
        this.birthday = birthday;
        this.cardid = cardid;
        this.salary = salary;
        this.phonenumber = phonenumber;
        this.email = email;
        this.address = address;
        this.positionMaster = positionMaster;
        this.levelMaster = levelMaster;
        this.workPartMaster = workPartMaster;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
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

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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

    public PositionMaster getPositionMaster() {
        return positionMaster;
    }

    public void setPositionMaster(PositionMaster positionMaster) {
        this.positionMaster = positionMaster;
    }

    public LevelMaster getLevelMaster() {
        return levelMaster;
    }

    public void setLevelMaster(LevelMaster levelMaster) {
        this.levelMaster = levelMaster;
    }

    public WorkPartMaster getWorkPartMaster() {
        return workPartMaster;
    }

    public void setWorkPartMaster(WorkPartMaster workPartMaster) {
        this.workPartMaster = workPartMaster;
    }
}
