package service.customer;

import model.Customer;
import respository.customer.CustomerRespository;
import respository.customer.ICustomerRespository;

import java.sql.SQLException;
import java.util.List;

public class FacilityCustomer implements IFacilityCustomer{
    ICustomerRespository customerRespository = new CustomerRespository();
    @Override
    public void insertCustomer(Customer customer) throws SQLException {
        customerRespository.insertCustomer(customer);
    }

    @Override
    public List<Customer> selectAllCustomer() {
        return customerRespository.selectAllCustomer();
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        return customerRespository.deleteCustomer(id);
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        return customerRespository.updateCustomer(customer);
    }

    @Override
    public List<Customer> search(String nameSearch, String searchAddress, String searchType) {
        return customerRespository.search(nameSearch, searchAddress, searchType);
    }
}
