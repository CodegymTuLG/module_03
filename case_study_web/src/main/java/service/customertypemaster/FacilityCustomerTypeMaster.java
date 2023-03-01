package service.customertypemaster;

import model.CustomerTypeMaster;
import model.LevelMaster;
import respository.customertype.CustomerTypeRespository;
import respository.customertype.ICustomerTypeRespository;
import respository.levelmaster.ILevelMasterRespository;
import respository.levelmaster.LevelMasterRespository;

import java.util.List;

public class FacilityCustomerTypeMaster implements IFacilityCustomerTypeMaster {
     ICustomerTypeRespository customerTypeRespository = new CustomerTypeRespository();
    @Override
    public List<CustomerTypeMaster> selectAllCustomerType() {
        return customerTypeRespository.selectAllCustomerType();
    }
}
