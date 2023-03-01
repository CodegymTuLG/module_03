package model;

import service.contract.FacilityContract;

import java.util.List;

public class Contract {
    private int contract_id;
    private String startdate;
    private String enddate;
    private String deposit;
    private String payment;
    Employee employee;
    Customer customer;
    Service service;
    List<Accompaniedservice> accompaniedserviceList;

    public Contract() {
    }

    public Contract(Service service, Customer customer, Employee employee, String startdate, String enddate, String deposit) {
        this.startdate = startdate;
        this.enddate = enddate;
        this.deposit = deposit;
        this.customer = customer;
        this.service = service;
        this.employee = employee;
    }

    public Contract(String startdate, String enddate, String deposit, String payment, Employee employee, Customer customer, Service service) {
        this.startdate = startdate;
        this.enddate = enddate;
        this.deposit = deposit;
        this.payment = payment;
        this.employee = employee;
        this.customer = customer;
        this.service = service;
    }
    public Contract(int contract_id, Service service, Customer customer, String startdate, String enddate, String deposit, String payment, List<Accompaniedservice> accompaniedserviceList) {
        this.contract_id = contract_id;
        this.startdate = startdate;
        this.enddate = enddate;
        this.deposit = deposit;
        this.payment = payment;
        this.customer = customer;
        this.service = service;
        this.accompaniedserviceList = accompaniedserviceList;
    }

    public List<Accompaniedservice> getAccompaniedserviceList() {
        return accompaniedserviceList;
    }

    public void setAccompaniedserviceList(List<Accompaniedservice> accompaniedserviceList) {
        this.accompaniedserviceList = accompaniedserviceList;
    }

    public int getContract_id() {
        return contract_id;
    }

    public void setContract_id(int contract_id) {
        this.contract_id = contract_id;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
