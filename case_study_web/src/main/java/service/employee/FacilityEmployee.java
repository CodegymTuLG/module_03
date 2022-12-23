package service.employee;

import model.Service;
import respository.service.IServiceRespository;
import respository.service.ServiceRespository;

import java.sql.SQLException;
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
        return serviceRespository.deleteService(id);
    }

    @Override
    public boolean updateService(Service service) throws SQLException {
        return serviceRespository.updateService(service);
    }
}
