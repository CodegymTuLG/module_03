package service.renttypemaster;

import model.RentTypeMaster;
import respository.renttypemaster.IRentTypeMasterRespository;
import respository.renttypemaster.RentTypeMasterRespository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacilityRentTypeMaster implements IFacilityRentTypeMaster {
    IRentTypeMasterRespository rentTypeMasterRespository = new RentTypeMasterRespository();
    @Override
    public List<RentTypeMaster> selectAllRentTypeMaster() {
        return rentTypeMasterRespository.selectAllRentTypeMaster();
    }

}
