package service.positionmaster;

import model.PositionMaster;
import model.ServiceTypeMaster;
import respository.positionmaster.IPositionMasterRespository;
import respository.positionmaster.PositionMasterRespository;
import respository.servicetypemaster.IServiceTypeMasterRespository;
import respository.servicetypemaster.ServiceTypeMasterRespository;

import java.util.List;

public class FacilityPositionMaster implements IFacilityPositionMaster {
    IPositionMasterRespository positionMasterRespository = new PositionMasterRespository();
    @Override
    public List<PositionMaster> selectAllPosition() {
        return positionMasterRespository.selectAllPosition();
    }
}
