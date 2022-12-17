package service;

import model.Customer;
import respository.CustomerResository;
import respository.ICustomerResository;

import java.util.List;

public class CustomerService implements ICustomerService{
ICustomerResository customerResository = new CustomerResository();
    @Override
    public List<Customer> showList() {
        return customerResository.showList();
    }
}
