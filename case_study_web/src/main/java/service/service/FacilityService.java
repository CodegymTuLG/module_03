package service.service;

import model.Service;
import respository.renttypemaster.IRentTypeMasterRespository;
import respository.renttypemaster.RentTypeMasterRespository;
import respository.service.IServiceRespository;
import respository.service.ServiceRespository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacilityService implements IFacilityService {
    IServiceRespository serviceRespository = new ServiceRespository();

    @Override
    public void insertService(Service service) throws SQLException {
        serviceRespository.insertService(service);
    }

    @Override
    public List<Service> selectAllService() {
        return serviceRespository.selectAllService();
    }

    @Override
    public boolean deleteService(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateService(Service service) throws SQLException {
        return false;
    }
}
