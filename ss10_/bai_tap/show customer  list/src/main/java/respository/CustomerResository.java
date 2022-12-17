package respository;

import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerResository implements ICustomerResository{
    private static List<Customer> customerList = new ArrayList<>();
    static{
        customerList.add(new Customer(1,"Mai Van Hoan","1983-08-20","Ha Noi","views/image/connan.jpg"));
        customerList.add(new Customer(2,"Mai Van Trung","1982-08-20","Ha Noi","views/image/connan.jpg"));
        customerList.add(new Customer(3,"Mai Van Tung","1992-08-20","Ha Noi","views/image/connan.jpg"));
    }
    @Override
    public List<Customer> showList() {
        return customerList;
    }
}
