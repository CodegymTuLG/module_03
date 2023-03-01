package respository.customer;

import model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerRespository {
    public void insertCustomer(Customer customer) throws SQLException;

    public List<Customer> selectAllCustomer();

    public boolean deleteCustomer(int id) throws SQLException;

    public boolean updateCustomer(Customer customer) throws SQLException;

    public List<Customer> search(String nameSearch, String searchAddress, String searchType);
}
