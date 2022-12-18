package dao.service;

import model.Service;

import java.sql.SQLException;
import java.util.List;

public interface IServiceDAO {
    public void insertService(Service service) throws SQLException;

    public List<Service> selectAllService();

    public boolean deleteService(int id) throws SQLException;

    public boolean updateService(Service service) throws SQLException;
}
