package dao.renttypemaster;

import model.RentTypeMaster;
import model.ServiceTypeMaster;

import java.util.List;

public interface IRentTypeMasterDAO {
    List<RentTypeMaster> selectAllRentTypeMaster();
}
