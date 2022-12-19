package respository.servicetypemaster;

import model.ServiceTypeMaster;

import java.util.List;

public interface IServiceTypeMasterRespository {
    List<ServiceTypeMaster> selectAllServiceTypeMaster();
}
