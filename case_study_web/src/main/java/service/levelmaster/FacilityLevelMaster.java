package service.levelmaster;

import model.LevelMaster;
import respository.customertype.ICustomerTypeRespository;
import respository.customertype.CustomerTypeRespository;
import respository.levelmaster.ILevelMasterRespository;
import respository.levelmaster.LevelMasterRespository;
import respository.positionmaster.IPositionMasterRespository;
import respository.positionmaster.PositionMasterRespository;

import java.util.List;

public class FacilityLevelMaster implements IFacilityLevelMaster {
     ILevelMasterRespository levelMasterRespository = new LevelMasterRespository();
    @Override
    public List<LevelMaster> selectAllLevel() {
        return levelMasterRespository.selectAllLevel();
    }
}
