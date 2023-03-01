package service.customertypemaster;

import model.CustomerTypeMaster;
import model.LevelMaster;

import java.util.List;

public interface IFacilityCustomerTypeMaster {
    List<CustomerTypeMaster> selectAllCustomerType();
}
