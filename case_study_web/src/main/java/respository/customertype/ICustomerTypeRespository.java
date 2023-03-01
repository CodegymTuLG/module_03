package respository.customertype;

import model.CustomerTypeMaster;
import model.LevelMaster;
import model.RentTypeMaster;

import java.util.List;

public interface ICustomerTypeRespository {
    List<CustomerTypeMaster> selectAllCustomerType();
}
