package service.servicetypemaster;

import model.ServiceTypeMaster;
import respository.service.IServiceRespository;
import respository.service.ServiceRespository;
import respository.servicetypemaster.IServiceTypeMasterRespository;
import respository.servicetypemaster.ServiceTypeMasterRespository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacilityServiceTypeMaster implements IFacilityServiceTypeMaster {
    IServiceTypeMasterRespository serviceTypeMasterRespository = new ServiceTypeMasterRespository();

    @Override
    public List<ServiceTypeMaster> selectAllServiceTypeMaster() {
        return serviceTypeMasterRespository.selectAllServiceTypeMaster();
    }
}
