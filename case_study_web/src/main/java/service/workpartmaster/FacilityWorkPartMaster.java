package service.workpartmaster;

import model.ServiceTypeMaster;
import respository.servicetypemaster.IServiceTypeMasterRespository;
import respository.servicetypemaster.ServiceTypeMasterRespository;

import java.util.List;

public class FacilityServiceTypeMaster implements IFacilityServiceTypeMaster {
    IServiceTypeMasterRespository serviceTypeMasterRespository = new ServiceTypeMasterRespository();

    @Override
    public List<ServiceTypeMaster> selectAllServiceTypeMaster() {
        return serviceTypeMasterRespository.selectAllServiceTypeMaster();
    }
}
