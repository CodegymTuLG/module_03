package dao.servicetypemaster;

import model.ServiceTypeMaster;

import java.util.List;

public interface IServiceTypeMasterDAO {
    List<ServiceTypeMaster> selectAllServiceTypeMaster();
}
